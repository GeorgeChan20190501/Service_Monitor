package com.cognizant.ams.dao;

import com.cognizant.ams.bean.SmResult;
import com.cognizant.ams.bean.SmResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmResultMapper {
    long countByExample(SmResultExample example);

    int deleteByExample(SmResultExample example);

    int insert(SmResult record);

    int insertSelective(SmResult record);

    List<SmResult> selectByExample(SmResultExample example);

    int updateByExampleSelective(@Param("record") SmResult record, @Param("example") SmResultExample example);

    int updateByExample(@Param("record") SmResult record, @Param("example") SmResultExample example);

	void saveResult(SmResult smResult);

	List<SmResult> queryAppHealth(SmResult smResultlist);
}