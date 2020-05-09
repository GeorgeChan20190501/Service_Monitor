package com.cognizant.ams.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cognizant.ams.bean.SysUser;
import com.cognizant.ams.bean.SysUserExample;
import com.cognizant.ams.bean.SysUserExample.Criteria;
import com.cognizant.ams.common.ldap.LdapADHelper;
import com.cognizant.ams.common.utils.DateFormatUtils;
import com.cognizant.ams.dao.SysUserMapper;

@Service
public class LogonService {

	@Autowired
	private SysUserMapper sysUserMapper;

	Logger logger = LoggerFactory.getLogger(LogonService.class);

	public boolean checkUser(String username, String password) {
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andAccountEqualTo(username);
		List<SysUser> users = sysUserMapper.selectByExample(sysUserExample);
		if (users.size() > 0) {
			String flag = users.get(0).getCertifyflag();
			if (flag != null) {
				if (flag.equals("0")) {
					if (password.equals(users.get(0).getPassword())) {
						return true;
					}
				} else { // 非系统用户走ldap

					String info = LdapADHelper.getADInfo(username, password);
					if (!info.equals("LADPERROR")) { // 用户名或密码错误
						JSONObject jsonInfo = JSON.parseObject(info);
						SysUser sysUserLDAP = jsonInfo.toJavaObject(SysUser.class); // 域控信息转对象
						// 用户验证成功，更新数据。
						// 先获取数据，比较，如不同则更新
						SysUser sysUserLocal = users.get(0);
						if (null!=sysUserLocal.getUsername()&&sysUserLocal.getUsername().equals(sysUserLDAP.getUsername())) {
							logger.info(sysUserLDAP.getUsername() + "历史用户信息：无更新");
						} else {
							sysUserLDAP.setPassword(password);
							sysUserLDAP.setUpdateTime(DateFormatUtils.getSTDCNDate());
							int rows = sysUserMapper.updateLDAPUser(sysUserLDAP);
							if (rows > 0) {
								logger.info(sysUserLDAP.getUsername() + "历史用户信息：有更新，更新成功");
							}
						}
						return true;
					}
				}
			}
		}
		return false;
	}

}
