package com.cognizant.ams.dao;

import com.cognizant.ams.bean.SmApplist;
import com.cognizant.ams.bean.SmApplistExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmApplistMapper {
    long countByExample(SmApplistExample example);

    int deleteByExample(SmApplistExample example);

    int insert(SmApplist record);

    int insertSelective(SmApplist record);

    List<SmApplist> selectByExample(SmApplistExample example);

    int updateByExampleSelective(@Param("record") SmApplist record, @Param("example") SmApplistExample example);

    int updateByExample(@Param("record") SmApplist record, @Param("example") SmApplistExample example);

	List<SmApplist> queryAppConfig(SmApplist smApplist);

	void addConfig(SmApplist smApplist);

	void updateConfig(List<SmApplist> list);

	void deleteConfig(List<String> list);
}