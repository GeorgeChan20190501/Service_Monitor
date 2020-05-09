package com.cognizant.ams.dao;

import com.cognizant.ams.bean.SysMenu;
import com.cognizant.ams.bean.SysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
    long countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
	List<SysMenu> getUserMenu(String username);

	List<SysMenu> queryMenu(SysMenu sysMenu);

	int addMenu(SysMenu sysMenu);

	void deleteMenu(List<String> list);

	void updateMenu(List<SysMenu> list);
}