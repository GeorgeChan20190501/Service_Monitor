package com.cognizant.ams.dao;

import com.cognizant.ams.bean.SmSn;
import com.cognizant.ams.bean.SmSnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmSnMapper {
	long countByExample(SmSnExample example);

	int deleteByExample(SmSnExample example);

	int insert(SmSn record);

	int insertSelective(SmSn record);

	List<SmSn> selectByExample(SmSnExample example);

	int updateByExampleSelective(@Param("record") SmSn record, @Param("example") SmSnExample example);

	int updateByExample(@Param("record") SmSn record, @Param("example") SmSnExample example);

	List<SmSn> getSNByTicketNo(List<SmSn> snList);

	void insertNewSN(List<SmSn> snList);

	void updateSN(List<SmSn> listUpdate);

	List<SmSn> queryFenyeSN(SmSn smSntlist);
}