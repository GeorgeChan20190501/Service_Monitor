package com.cognizant.ams.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ams.bean.SysRole;
import com.cognizant.ams.bean.SysRoleMenu;
import com.cognizant.ams.dao.SysRoleMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	/**
	 * 根据用户查询菜单列表
	 * 
	 * @param username
	 * @return
	 */
	/*
	 * public List<SysRole> getUserRole(String username){ List<SysRole>
	 * list=sysRoleMapper.getUserRole(username); return list; }
	 * 
	 *//**
		 * 查询所有有效菜单（页面默认加载）
		 * 
		 * @return
		 */

	/*
	 * public List<SysRole> getAllRole(){ SysRoleExample sysRoleExample =new
	 * SysRoleExample(); SysRoleExample.Criteria
	 * criteria=sysRoleExample.createCriteria();
	 * criteria.andIsDeletedEqualTo("0");//标志：1删除 0 未删除 List<SysRole>
	 * list=sysRoleMapper.selectByExample(sysRoleExample); return list; }
	 * 
	 * 
	 *//**
		 * 根据参数查询菜单
		 * 
		 * @param Role
		 * @return
		 *//*
			 * public List<SysRole> getRole(SysRole Role){ SysRoleExample example=new
			 * SysRoleExample(); SysRoleExample.Criteria criteria=example.createCriteria();
			 * String nodecode=Role.getNodeCode(); String nodename=Role.getNodeName();
			 * String isdeleted=Role.getIsDeleted(); if (!"".equals(nodecode)){
			 * criteria.andNodeCodeEqualTo(nodecode); } if (!"".equals(nodename)){
			 * criteria.andNodeNameEqualTo(nodename); } if (!"".equals(isdeleted)){
			 * criteria.andIsDeletedEqualTo(isdeleted); } List<SysRole>
			 * SysRoleList=sysRoleMapper.selectByExample(example);
			 * 
			 * return SysRoleList; }
			 * 
			 * public int insertRole(SysRole newRole){ int
			 * result=sysRoleMapper.insert(newRole); return result; }
			 * 
			 * public int deteteRole(String nodecode){ SysRoleExample example=new
			 * SysRoleExample(); SysRoleExample.Criteria criteria=example.createCriteria();
			 * criteria.andNodeCodeEqualTo(nodecode); int
			 * result=sysRoleMapper.deleteByExample(example); return result; }
			 * 
			 * 
			 * public int updateRole(SysRole Role){ SysRoleExample example=new
			 * SysRoleExample(); SysRoleExample.Criteria
			 * criteria=example.createCriteria();//创建更新的条件
			 * criteria.andNodeCodeEqualTo(Role.getNodeCode()); int
			 * result=sysRoleMapper.updateByExample(Role,example); return result; }
			 * 
			 * public List<SysRole> queryRole(SysRole sysRole) { List<SysRole>
			 * list=sysRoleMapper.queryRole(sysRole); return list; }
			 */

	public int addRole(SysRole sysRole) {
		int result = sysRoleMapper.addRole(sysRole);
		return result;

	}
	/*
	 * public void deleteRole(List<String> list) { sysRoleMapper.deleteRole(list); }
	 * 
	 * public void updateRole(List<SysRole> list) { sysRoleMapper.updateRole(list);
	 * }
	 */

	public List<SysRole> queryRole(SysRole sysRole) {
		List<SysRole> list = sysRoleMapper.queryRole(sysRole);
		return list;
	}

	public void deleteRole(List<String> list) {
		sysRoleMapper.deleteRole(list);
	}

	public int updateRole(List<SysRole> list) {
		int a = sysRoleMapper.updateRole(list);
		return a;
	}

	public String[] getRoleCode(List<String> listId) {
		
		return sysRoleMapper.getRoleCode(listId);
	}

	public void roleGrant(List<SysRoleMenu> list) {
		sysRoleMapper.roleGrant(list);
		
	}

}
