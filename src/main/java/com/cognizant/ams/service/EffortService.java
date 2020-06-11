package com.cognizant.ams.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmConfigExample;
import com.cognizant.ams.bean.SmEfforts;
import com.cognizant.ams.bean.SmEffortsExample;
import com.cognizant.ams.dao.SmConfigMapper;
import com.cognizant.ams.dao.SmEffortsMapper;

@SuppressWarnings("deprecation")
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

	@SuppressWarnings("unused")
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
	public int delete(List<String>  efforts) {
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
	   effortsExample.setOrderByClause(" userid asc,workday desc,tasktype");
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
	   effortsExample.setOrderByClause(" userid asc,workday desc,tasktype");
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
	   effortsExample.setOrderByClause(" userid asc,workday desc,tasktype");
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
	   effortsExample.setOrderByClause(" userid asc,workday desc,tasktype");
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	
	/**
	 * 按所有user的effort
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	@SuppressWarnings("unused")
	public List<SmEfforts> queryAllEfforts(){
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
		effortsExample.setOrderByClause(" userid asc,workday desc,tasktype");
	   List<SmEfforts> effList= effortMapper.selectByExample(effortsExample);
	   return effList;
	}
	
	public List<SmConfig> queryAppConfig() {
		smConfigExample=new SmConfigExample();
		SmConfigExample.Criteria criteria=smConfigExample.createCriteria();
		   criteria.andTypeEqualTo("applist");
		return smConfigMapper.selectByExample(smConfigExample);
	}
	/**
	 * 查询配置，根据key找value或者根据value找key
	 * @param type
	 * @param key
	 * @param val
	 * @return
	 */
	public List<SmConfig> queryAppConfig(String type, String key,String val) {
		smConfigExample=new SmConfigExample();
		SmConfigExample.Criteria criteria=smConfigExample.createCriteria();
		   criteria.andTypeEqualTo(type);
		   if (Strings.isNotBlank(key)) {
			   criteria.andCkeyEqualTo(key);
		}
		   if (Strings.isNotBlank(val)) {
			   criteria.andCval1EqualTo(val);
			}
		List<SmConfig>   configs=smConfigMapper.selectByExample(smConfigExample);
		   
		return configs;
	}

	public int saveOrUpdateEffort(List<SmEfforts> effortList) {
		int result=effortMapper.saveOrUpdateEffort(effortList);
		return result;
		// TODO Auto-generated method stub
		
	}

	public int deleteEffortsByDate(String effortUser, String starttime, String endtime) {
		int result=0;
		effortsExample=new SmEffortsExample();
		SmEffortsExample.Criteria criteria=effortsExample.createCriteria();
		criteria.andUseridEqualTo(effortUser);
	   criteria.andWorkdayBetween(starttime, endtime);
	   effortMapper.deleteByExample(effortsExample);
		return result;
	
		
	}
 
}
