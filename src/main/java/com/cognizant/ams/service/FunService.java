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


	public void duijiang(SmFun smFun) {
		//先获取本次开奖结果。 2.获取本期所有投注  3.判断是否中奖，4.按奖项新增积分
		String benqiz= smFun.getFval1()+"," +smFun.getFval2()+"," +smFun.getFval3();
		String benqi= smFun.getFval1()+"," +smFun.getFval2()+"," +smFun.getFval3()+"," +smFun.getFval9();
		SmFun smFunduijiang = new SmFun();
		//获取系统开奖的期号。
		String qiString=smFunMapper.getQiHao("PLC");
		smFunduijiang.setType("PLC");
		smFunduijiang.setFkey(qiString);
		List<SmFun> list =  getPrePeriod(smFunduijiang);	  //当前期
		System.out.println("投了多少注："+(list.size()-1));
		if (list.size()>0) {
			for (SmFun smFun2 : list) {
				
				String zhi3= smFun2.getFval1()+"," +smFun2.getFval2()+"," +smFun2.getFval3();
				String zhi21= smFun2.getFval1()+"," +smFun2.getFval2();
				String zhi22= smFun2.getFval1()+"," +smFun2.getFval3();
				String zhi23= smFun2.getFval2()+"," +smFun2.getFval3();
				String account =smFun2.getFval8();
				
				int countx = 0;
				int county = 0;
				
				if (!smFun2.getFval8().equals("sys")) {  //非系统开奖才能兑奖
					System.out.println("当前投注："+zhi3+smFun2.getFval9()+"=====系统开奖=="+benqi);
				if(benqi.contains(smFun2.getFval1())) {
					++countx;
				}
				if(benqi.contains(smFun2.getFval2())) {
					++countx;
				}
				if(benqi.contains(smFun2.getFval3())) {
					++countx;
				}
				if(benqi.contains(smFun2.getFval9())) {
					++county;
				}
				
				System.out.println(smFun.getFkey()+"中了"+countx+"个号, 猜大小中了："+county);
				
				if (zhi3.equals(benqiz)&&county==1) {  //直3+大小
					//判断是否一等奖。1赔500
					jifenopt(account, "PLC一等奖派奖", (100*500)+"");
					smFun2.setFval10("PLC一等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				 //二等奖   直3    1赔400
				if (zhi3.equals(benqiz)&&county==0) { 
					jifenopt(account, "PLC二等奖派奖", (100*300)+"");
					smFun2.setFval10("PLC二等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				
				//三等将。乱三+大小     1赔 200
				if (!zhi3.equals(benqiz)&&countx==3&&county==1) {  
					jifenopt(account, "PLC三等奖派奖", (100*150)+"");
					smFun2.setFval10("PLC三等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				
				
				//四等奖：直2+大小 或 乱三    1赔100  
				if (((benqi.contains(zhi21)||benqi.contains(zhi22)||benqi.contains(zhi23))&&county==1)|| (countx==3&&county==0)) {  
					jifenopt(account, "PLC四等奖派奖", (100*60)+"");
					smFun2.setFval10("PLC四等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				
				//五等奖：乱2+大小    直2         1赔30
				if ((countx==2&&county==1)||  ((benqi.contains(zhi21)||benqi.contains(zhi22)||benqi.contains(zhi23))&&county==0)) {  
					jifenopt(account, "PLC五等奖派奖", (100*20)+"");
					smFun2.setFval10("PLC五等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				
				//六等奖：乱2+   直1+大小                1赔6
				
				if ((countx==2&&county==0)||  ((smFun.getFval1().equals(smFun2.getFval1())|| smFun.getFval2().equals(smFun2.getFval2()) || smFun.getFval3().equals(smFun2.getFval3()))&&county==0)) {  
					jifenopt(account, "PLC六等奖派奖", (100*6)+"");
					smFun2.setFval10("PLC六等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				
				//乱1+大小							    1赔付3
				if ((countx==1&&county==1)) {  
					jifenopt(account, "PLC七等奖派奖", (100*3)+"");
					smFun2.setFval10("PLC七等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				
				//七等奖  大小                          1赔1.2
				
				if ((countx==0&&county==1)) {  
					jifenopt(account, "PLC八等奖派奖", (220)+"");
					smFun2.setFval10("PLC八等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
				//乱1                                        1配0.5
				if ((countx==1&&county==0)) {  
					jifenopt(account, "PLC九等奖派奖", (50)+"");
					smFun2.setFval10("PLC九等奖派奖");
					updatePaiJiang(smFun2);
					continue;
				}
			  }
			}
		}
	}

	private void updatePaiJiang(SmFun smFun2) {
		smFunMapper.updatePaiJiang(smFun2);
	}


	public void jifenopt(String username,String opration,String jiangValue) {
		SmUserjfmx smUserjfmx = new SmUserjfmx();
		smUserjfmx.setAccount(username);
		String today=DateFormatUtils.getSTDCNDate().substring(0,10);
		System.out.println(today);
		smUserjfmx.setCreateTime(today);
		smUserjfmx.setOpType(opration);
			System.out.println("兑奖积分");
			SmUserjf smUserjf =new SmUserjf();
			smUserjf.setAccount(username);
			//获取剩余值
			List<SmUserjf> smList=getUserJF(smUserjf);
				String sy =smList.get(0).getTotalVal();
				String  newSy =( Integer.parseInt(sy)+Integer.parseInt(jiangValue))+"";
				smUserjf.setTotalVal(newSy);
				smUserjfmx.setTotalVal(newSy);
				smUserjfmx.setOpVal("+ "+jiangValue);
				addJiFenRecord(smUserjfmx);
				updateJiFen(smUserjf);
		}
	public static void main(String[] args) {
		if("1,2,6,小".contains("大")) {
			System.out.println("中");
		}
		else {
			System.out.println("不中");
		}
	}
}
