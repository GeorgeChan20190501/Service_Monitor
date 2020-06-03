package com.cognizant.ams.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ams.bean.SmUserjf;
import com.cognizant.ams.bean.SmUserjfmx;
import com.cognizant.ams.bean.SysRole;
import com.cognizant.ams.bean.SysUser;
import com.cognizant.ams.bean.SysUserExample;
import com.cognizant.ams.bean.SysUserExample.Criteria;
import com.cognizant.ams.dao.SysRoleMapper;
import com.cognizant.ams.dao.SysUserMapper;

@Service
public class UserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private FunService funService;

	public List<SysUser> queryUser(SysUser sysUser) {
		List<SysUser> ldusers = sysUserMapper.getUser(sysUser);
		return ldusers;
	}
	
	public List<SysUser> getusers() {
		List<SysUser> ldusers = sysUserMapper.selectByExample(null);
		return ldusers;
	}

	public void addUser(SysUser sysUser) {
		sysUserMapper.addUser( sysUser) ;
		
	}

	public List<SysRole> getUserRole() {
		List<SysRole> role = sysRoleMapper.getUserRole();
		return role;
	}

	public List<SysUser> queryUserByAccount(SysUser sysUser) {
		SysUserExample sysUserExample =new SysUserExample();
		Criteria criteria=sysUserExample.createCriteria();
		criteria.andAccountEqualTo(sysUser.getAccount());
		List<SysUser> list=sysUserMapper.selectByExample(sysUserExample);
		return list;
	}

	public void deleteUserMenu(SysUser sysUser) {
		sysUserMapper.deleteUserMenu( sysUser) ;
	}

	public void deleteUser(List<SysUser> userlist) {
		sysUserMapper.deleteUser( userlist) ;
		
	}

	public void grantUser(List<SysUser> userlist) {
		sysUserMapper.grantUser(userlist);
	}

	public void updateUser(List<SysUser> userlist) {
		sysUserMapper.updateUser(userlist);
	}

	public void addJiFen(SysUser sysUser) {
		SmUserjfmx smUserjfmx =new SmUserjfmx();
		smUserjfmx.setAccount(sysUser.getAccount());
		smUserjfmx.setTotalVal("1000");
		smUserjfmx.setOpType("注册");
		smUserjfmx.setOpVal("+1000");
		funService.addJiFenRecord(smUserjfmx);
		SmUserjf smUserjf =new SmUserjf();
		smUserjf.setAccount(sysUser.getAccount());
		smUserjf.setTotalVal("1000");
		funService.addJiFen(smUserjf);
	}
 
}
