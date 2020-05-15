package com.cognizant.ams.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmConfigExample;
import com.cognizant.ams.bean.SmEfforts;
import com.cognizant.ams.bean.SmEffortsExample;
import com.cognizant.ams.bean.SmSn;
import com.cognizant.ams.bean.SysMenuExample;
import com.cognizant.ams.dao.SmConfigMapper;
import com.cognizant.ams.dao.SmEffortsMapper;
import com.cognizant.ams.dao.SmSnMapper;

@Service
public class EffortService {

	@Autowired
	private SmEffortsMapper effortMapper;
	
	@Autowired
	private SmConfigMapper smConfigMapper;

	private SmEffortsExample effortsExample;
	private SmConfigExample smConfigExample;
	
	/**
	 * Effort保存
	 * @param effort
	 * @return
	 */
	public int save(SmEfforts effort) {
		effort.setCreateTime(new Date().toLocaleString());
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
		int result=effortMapper.insert(effort);
		
		return result;
	}
	
	/**
	 * Effort更新
	 * @param effort
	 * @return
	 */
	public int update(List<SmEfforts> efforts) {
		int result=effortMapper.updateEffort(efforts);
		return result;
	}
	
	/**
	 * Effort删除
	 * @param effort
	 * @return
	 */
	public int delete(List  efforts) {
	    int result=effortMapper.deleteEffort(efforts);
		return result;
	}
	
	/**
	 * 根据用户和工作日查询effort
	 * @param workday
	 * @param usercode
	 * @return
	 */
	public List<SmEfforts> queryEffortsByUser(String usercode){
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
	   criteria.andUseridEqualTo(usercode);
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	/**
	 * 根据用户和工作日查询effort
	 * @param workday
	 * @param usercode
	 * @return
	 */
	public List<SmEfforts> queryEffortsByWorkday(String workday,String usercode){
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
	   criteria.andWorkdayEqualTo(workday);
	   criteria.andUseridEqualTo(usercode);
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	
	/**
	 * 按时间段查询user的effort
	 * @param startdate
	 * @param enddate
	 * @param usercode
	 * @return
	 */
	public List<SmEfforts> queryEfforts(String startdate, String enddate, String usercode){
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
	   criteria.andWorkdayBetween(startdate, enddate);
	   criteria.andUseridEqualTo(usercode);
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	/**
	 * 按时间段查询所有user的effort
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	public List<SmEfforts> queryAllEffortsByDate(String startdate, String enddate){
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
	   criteria.andWorkdayBetween(startdate, enddate);
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	
	/**
	 * 按所有user的effort
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	public List<SmEfforts> queryAllEfforts(){
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	
	public List<SmConfig> queryAppConfig() {
		smConfigExample=new SmConfigExample();
		SmConfigExample.Criteria criteria=smConfigExample.createCriteria();
		   criteria.andTypeEqualTo("applist");
		return smConfigMapper.selectByExample(smConfigExample);
	}
	public SmConfig queryAppConfigbyEaicode(String eaicode) {
		smConfigExample=new SmConfigExample();
		SmConfigExample.Criteria criteria=smConfigExample.createCriteria();
		   criteria.andTypeEqualTo("applist");
		   criteria.andCkeyEqualTo(eaicode);
		return smConfigMapper.selectByExample(smConfigExample).get(0);
	}
 
}
