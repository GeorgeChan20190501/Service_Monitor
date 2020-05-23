package com.cognizant.ams.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.bean.SmUserjf;
import com.cognizant.ams.bean.SmUserjfmx;
import com.cognizant.ams.common.utils.DateFormatUtils;
import com.cognizant.ams.dao.SmFunMapper;
import com.cognizant.ams.dao.SmUserjfMapper;
import com.cognizant.ams.dao.SmUserjfmxMapper;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FunService {

	@Autowired
	private SmFunMapper smFunMapper;
 
	@Autowired
	private SmUserjfMapper smUserjfMapper;
	
	@Autowired
	private SmUserjfmxMapper smUserjfmxMapper;
	
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


	public List<SmUserjf> getUserJF(SmUserjf smUserjf) {
		return smUserjfMapper.getUserJF(smUserjf);
	}


	public void updateJiFen(SmUserjf smUserjf) {
		smUserjfMapper.updateJiFen(smUserjf);
	}


	public void addJiFenRecord(SmUserjfmx smUserjfmx) {
		smUserjfmxMapper.addJiFenRecord(smUserjfmx);
	}


	public void kaiJiang(SmFun smFun) {
		smFunMapper.kaiJiang(smFun)	;
	}


	public void addJiFen(SmUserjf smUserjf) {
		smUserjfMapper.addJiFen(smUserjf);
	}
	
	public List<SmUserjfmx> jiFenMXQuery(SmUserjfmx smUserjfmx) {
		return smUserjfmxMapper.jiFenMXQuery(smUserjfmx);
	}
	

	public void loginJiFen(String username) {
		//根据用户名去积分明细中查看有无当日登录成功经历，如有不赠送。
		SmUserjfmx smUserjfmx = new SmUserjfmx();
		smUserjfmx.setAccount(username);
		String today=DateFormatUtils.getSTDCNDate().substring(0,10);
		System.out.println(today);
		smUserjfmx.setCreateTime(today);
		smUserjfmx.setOpType("登录赠送");
		List<SmUserjfmx> smUserjfmx2=jiFenMXQuery(smUserjfmx);
		if (smUserjfmx2.size()>0) {   //已经赠送
			System.out.println("今日已经赠送登录积分");
		}
		else {
			System.out.println("赠送登录积分");
			SmUserjf smUserjf =new SmUserjf();
			smUserjf.setAccount(username);
			//获取剩余值
			List<SmUserjf> smList=getUserJF(smUserjf);
			if (smList.size()>0) {
				String sy =smList.get(0).getTotalVal();
				String  newSy =( Integer.parseInt(sy)+200)+"";
				smUserjf.setTotalVal(newSy);
				smUserjfmx.setTotalVal(newSy);
				smUserjfmx.setOpVal("+200");
				addJiFenRecord(smUserjfmx);
				updateJiFen(smUserjf);
			}
			else {
				System.out.println("此用户还没有加入积分系统，现在自动开通");
				smUserjf.setTotalVal("1200");
				smUserjfmx.setTotalVal("1200");
				smUserjfmx.setOpVal("+200");
				addJiFenRecord(smUserjfmx);
				addJiFen(smUserjf);
			}
		}
	}

	

}
