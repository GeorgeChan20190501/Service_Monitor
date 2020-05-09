package com.cognizant.ams.dao;

import com.cognizant.ams.bean.SysUser;
import com.cognizant.ams.bean.SysUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    int updateLDAPUser(SysUser record);

	List<SysUser> getUser(SysUser sysUser);

	void addUser(SysUser sysUser);

	void deleteUserMenu(SysUser sysUser);

	void deleteUser(List<SysUser> userlist);

	void updateUser(List<SysUser> userlist);

	void grantUser(List<SysUser> userlist);

	
}