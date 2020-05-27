package com.cognizant.ams.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.bean.SmUserjf;
import com.cognizant.ams.bean.SmUserjfmx;
import com.cognizant.ams.common.utils.CommonUtils;
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
		SmFun smFunduijiang = new SmFun();
		//获取系统开奖的期号。
		String qiString=smFunMapper.getQiHao("PLC");
		smFunduijiang.setType("PLC");
		smFunduijiang.setFkey(qiString);
		List<SmFun> list =  getPrePeriod(smFunduijiang);	  //当前期
		System.out.println("投了多少注："+(list.size()-1));
		if (list.size()>0) {
			for (SmFun sm : list) {
				if (!sm.getFval8().equals("sys")) {
					String string =sortp(smFun,sm);
					System.out.println("开奖是："+smFun.getFval1()+","+smFun.getFval2()+","+smFun.getFval3()+","+smFun.getFval9()+" == 投注是："+sm.getFval1()+","+sm.getFval2()+","+sm.getFval3()+","+sm.getFval9()+"====="+string);
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
	
	public static void duijiangTest() {
		//先获取本次开奖结果。 2.获取本期所有投注  3.判断是否中奖，4.按奖项新增积分
		SmFun smFun =new SmFun();
		smFun.setFval1("1"); smFun.setFval2("5");  smFun.setFval3("8"); smFun.setFval9("小"); 
		//获取系统开奖的期号。
		List<SmFun> list =  new ArrayList<SmFun>();	  //当前期
		SmFun smFun1 =new SmFun();
		smFun1.setFval1("1"); smFun1.setFval2("0");  smFun1.setFval3("0"); smFun1.setFval9("大");  list.add(smFun1);
		
		SmFun smFun2 =new SmFun();
		smFun2.setFval1("0"); smFun2.setFval2("5");  smFun2.setFval3("2"); smFun2.setFval9("大");  list.add(smFun2);
		
		SmFun smFun3 =new SmFun();
		smFun3.setFval1("0"); smFun3.setFval2("2");  smFun3.setFval3("8"); smFun3.setFval9("大");  list.add(smFun3);
		
		SmFun smFun4 =new SmFun();
		smFun4.setFval1("4"); smFun4.setFval2("0");  smFun4.setFval3("2"); smFun4.setFval9("小");  list.add(smFun4);
		
		SmFun smFun5 =new SmFun();
		smFun5.setFval1("2"); smFun5.setFval2("0");  smFun5.setFval3("9"); smFun5.setFval9("小");  list.add(smFun5);
		
		SmFun smFun6 =new SmFun();
		smFun6.setFval1("0"); smFun6.setFval2("6");  smFun6.setFval3("4"); smFun6.setFval9("小");  list.add(smFun6);
		
		SmFun smFun7 =new SmFun();
		smFun7.setFval1("0"); smFun7.setFval2("6");  smFun7.setFval3("9"); smFun7.setFval9("小");  list.add(smFun7);
		
		SmFun smFun8 =new SmFun();
		smFun8.setFval1("9"); smFun8.setFval2("2");  smFun8.setFval3("0"); smFun8.setFval9("小");  list.add(smFun8);
		
		System.out.println("投了多少注："+(list.size()));
		/*
		 * if (list.size()>0) { for (SmFun sm : list) { String string =sortp(smFun,sm);
		 * System.out.println("开奖是："+smFun.getFval1()+","+smFun.getFval2()+","+smFun.
		 * getFval3()+","+smFun.getFval9()+" == 投注是："+sm.getFval1()+","+sm.getFval2()+
		 * ","+sm.getFval3()+","+sm.getFval9()+"====="+string); } }
		 */
		
	}
	
	public  String sortp(SmFun jiang,SmFun tou) {
		String account = tou.getFval8();
		int jiang1 [] =new int[3];
		int tou1 [] =   new int[3];
		String jball1 =jiang.getFval1();
		jiang1[0]=Integer.parseInt(jball1);
		String jball2 =jiang.getFval2();
		jiang1[1]=Integer.parseInt(jball2);
		String jball3 =jiang.getFval3();
		jiang1[2]=Integer.parseInt(jball3);
		String jball9 =jiang.getFval9();
	
		
		String tball1 =tou.getFval1();
		tou1[0]=Integer.parseInt(tball1);
		String tball2 =tou.getFval2();
		tou1[1]=Integer.parseInt(tball2);
		String tball3 =tou.getFval3();
		tou1[2]=Integer.parseInt(tball3);
		String tball9 =tou.getFval9();
		
		String jiang2 = jball1+""+jball2+""+jball3;
		boolean daxiao=jball9.equals(tball9);
		int zhi=CommonUtils.zhi(jiang1,tou1);
		int mix =CommonUtils.mix(jiang2, tou1);
		
		if (zhi==3&&daxiao) {  //一等奖    直3+1大小     1:500     1/2000
			jifenopt(account, "PLC一等奖派奖", "100000");
			tou.setFval10("PLC一等奖派奖");
			updatePaiJiang(tou);
			return "PLC一等奖派奖";
		}
		
		if (zhi==3&&(!daxiao)) {  //二等奖    直3+0大小  1:300     1/1000
			jifenopt(account, "PLC二等奖派奖", "80000");
			tou.setFval10("PLC二等奖派奖");
			updatePaiJiang(tou);
			return "PLC二等奖派奖";
		}
		
		if (zhi!=3&&mix==3&&daxiao) {  //三等奖    乱3+1大小  1:200         3/1000    0.3%
			jifenopt(account, "PLC三等奖派奖", "45000");
			tou.setFval10("PLC三等奖派奖");
			updatePaiJiang(tou);
			return "PLC三等奖派奖";
		}
		if (mix==3&&zhi!=3 &&(!daxiao) ) {// 乱3+0  0.6%     和值：0.6%
			jifenopt(account, "PLC四等奖派奖", "10000");
			tou.setFval10("PLC四等奖派奖");
			updatePaiJiang(tou);
			return "PLC四等奖派奖";
		}

		
		if ((zhi==2&&daxiao) || (zhi==2 && (!daxiao)) ) {		//直2+1  1.35%  或者  直接2+0     2.7%      和值：4%
			jifenopt(account, "PLC五等奖派奖", "4000");
			tou.setFval10("PLC五等奖派奖");
			updatePaiJiang(tou);
			return "PLC五等奖派奖";
		}
		
		
		
		 if ((mix==2&&daxiao&&zhi!=2)) { 						//乱2+1  8.1%     或者        和值：8.1%
			 	jifenopt(account, "PLC六等奖派奖", "600");
				tou.setFval10("PLC六等奖派奖");
				updatePaiJiang(tou);
				return "PLC六等奖派奖";
		 }
		 
	
		 if ( zhi==1 && daxiao) { 	// 直接1+1        和值：12.1%
			 jifenopt(account, "PLC七等奖派奖", "100");
				tou.setFval10("PLC七等奖派奖");
				updatePaiJiang(tou);
			 return "PLC七等奖派奖";
		 }
		 
 
		
		return "";

		 
		
	}
	public static void main(String[] args) {
		//duijiangTest();
	}
}
