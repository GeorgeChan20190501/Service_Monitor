package com.cognizant.ams.dao;

import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.bean.SmFunExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmFunMapper {
    long countByExample(SmFunExample example);

    int deleteByExample(SmFunExample example);

    int insert(SmFun record);

    int insertSelective(SmFun record);

    List<SmFun> selectByExample(SmFunExample example);

    int updateByExampleSelective(@Param("record") SmFun record, @Param("example") SmFunExample example);

    int updateByExample(@Param("record") SmFun record, @Param("example") SmFunExample example);

	List<SmFun> getPrePeriod(SmFun smFun);

	void touzhu(List<SmFun> list);
}