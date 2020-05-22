package com.cognizant.ams.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.dao.SmFunMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FunService {

	@Autowired
	private SmFunMapper smFunMapper;
 
	
	/*
	 * public int addRole(SysRole sysRole) { int result =
	 * sysRoleMapper.addRole(sysRole); return result;
	 * 
	 * }
	 */

	/*
	 * public List<SysRole> queryRole(SysRole sysRole) { List<SysRole> list =
	 * sysRoleMapper.queryRole(sysRole); return list; }
	 */


	public List<SmFun> getPrePeriod(SmFun smFun) {
		// TODO Auto-generated method stub
		return smFunMapper.getPrePeriod(smFun);
	}


	public void touzhu(List<SmFun> list) {
		smFunMapper.touzhu(list);
		
	}

	

}
