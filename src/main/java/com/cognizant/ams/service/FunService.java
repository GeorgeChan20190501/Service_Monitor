package com.cognizant.ams.service;

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


	public void duijiangDLT(SmFun smFun) {
		//先获取本次开奖结果。 2.获取本期所有投注  3.判断是否中奖，4.按奖项新增积分
		SmFun smFunduijiang = new SmFun();
		//获取系统开奖的期号。
		String qiString=smFunMapper.getQiHao("DLT");
		smFunduijiang.setType("DLT");
		smFunduijiang.setFkey(qiString);
		List<SmFun> list =  getPrePeriod(smFunduijiang);	  //当前期
		System.out.println("DLT投了多少注："+(list.size()-1));
		if (list.size()>0) {
			for (SmFun sm : list) {
				if (!sm.getFval8().equals("sys")) {
					String string =sortpDLT(smFun,sm);
					System.out.println("开奖是："+smFun.getFval1()+","+smFun.getFval2()+","+smFun.getFval3()+","+smFun.getFval4()+","+smFun.getFval5()+","+smFun.getFval6()+","+smFun.getFval7()+" == 投注是："+sm.getFval1()+","+sm.getFval2()+","+sm.getFval3()+","+sm.getFval4()+","+sm.getFval5()+","+sm.getFval6()+","+sm.getFval7()+"====="+string);
				}
			  }
		}
	}


	private String sortpDLT(SmFun jiang,SmFun tou) {
		String account = tou.getFval8();
		int jiang1 [] =new int[5];
		int tou1 [] =   new int[5];
		int jiang2 [] =new int[2];
		int tou2 [] =   new int[2];
		String jball1 =jiang.getFval1();
		jiang1[0]=Integer.parseInt(jball1);
		String jball2 =jiang.getFval2();
		jiang1[1]=Integer.parseInt(jball2);
		String jball3 =jiang.getFval3();
		jiang1[2]=Integer.parseInt(jball3);
		String jball4 =jiang.getFval4();
		jiang1[3]=Integer.parseInt(jball4);
		String jball5 =jiang.getFval5();
		jiang1[4]=Integer.parseInt(jball5);
		
		String jball6 =jiang.getFval6();
		jiang2[0]=Integer.parseInt(jball6);
		String jball7 =jiang.getFval7();
		jiang2[1]=Integer.parseInt(jball7);
	
		
		String tball1 =tou.getFval1();
		tou1[0]=Integer.parseInt(tball1);
		String tball2 =tou.getFval2();
		tou1[1]=Integer.parseInt(tball2);
		String tball3 =tou.getFval3();
		tou1[2]=Integer.parseInt(tball3);
		String tball4 =tou.getFval4();
		tou1[3]=Integer.parseInt(tball4);
		String tball5 =tou.getFval5();
		tou1[4]=Integer.parseInt(tball5);
		
		String tball6 =tou.getFval6();
		tou2[0]=Integer.parseInt(tball6);
		String tball7 =tou.getFval7();
		tou2[1]=Integer.parseInt(tball7);
		
		System.out.println("当前开奖是："+jiang1[0]+","+jiang1[1]+","+jiang1[2]+","+jiang1[3]+","+jiang1[4]+"===="+jiang2[0]+","+jiang2[1]);
		System.out.println("当投注是："+tou1[0]+","+tou1[1]+","+tou1[2]+","+tou1[3]+","+tou1[4]+"===="+tou2[0]+","+tou2[1]);		
		int zhipre=CommonUtils.zhi(jiang1,tou1);
		int zhipost =CommonUtils.zhi(jiang2, tou2);
		System.out.println("前区中了："+zhipre);
		System.out.println("后区中了："+zhipost);
		if (zhipre==5&&zhipost==2) {  //一等奖    直前5+直后2        1:1000万     
			jifenopt(account, "DLT一等奖派奖", "500000000");
			tou.setFval10("DLT一等奖派奖");
			updatePaiJiang(tou);
			return "DLT一等奖派奖";
		}
		
		if (zhipre==5&&zhipost==1) {  //二等奖    5+1
			jifenopt(account, "DLT二等奖派奖", "100000000");
			tou.setFval10("DLT二等奖派奖");
			updatePaiJiang(tou);
			return "DLT二等奖派奖";
		}
		
		if ((zhipre==5&&zhipost==0)) {  //三等奖   5+0  / 4+2
			jifenopt(account, "DLT三等奖派奖", "50000000");
			tou.setFval10("DLT三等奖派奖");
			updatePaiJiang(tou);
			return "DLT三等奖派奖";
		}
		if (zhipre==4&&zhipost==2 ) {//      4+2
			jifenopt(account, "DLT四等奖派奖", "300000");
			tou.setFval10("DLT四等奖派奖");
			updatePaiJiang(tou);
			return "DLT四等奖派奖";
		}
		if (zhipre==4&&zhipost==1 ) {//      4+1
			jifenopt(account, "DLT五等奖派奖", "60000");
			tou.setFval10("DLT五等奖派奖");
			updatePaiJiang(tou);
			return "DLT五等奖派奖";
		}
		if ((zhipre==4&&zhipost==0)  || (zhipre==3&&zhipost==2)) {//      4+0    / 3+2
			jifenopt(account, "DLT六等奖派奖", "10000");
			tou.setFval10("DLT六等奖派奖");
			updatePaiJiang(tou);
			return "DLT六等奖派奖";
		}
		if ((zhipre==2&&zhipost==2)  || (zhipre==3&&zhipost==1)) {//      2+2    / 3+1
			jifenopt(account, "DLT七等奖派奖", "1000");
			tou.setFval10("DLT七等奖派奖");
			updatePaiJiang(tou);
			return "DLT七等奖派奖";
		}
		
		if ((zhipre==1&&zhipost==2)  || (zhipre==2&&zhipost==1) || (zhipre==3&&zhipost==0) || (zhipre==0&&zhipost==2)) {//      1+2    / 2+1   / 3+0 /  0+2
			jifenopt(account, "DLT八等奖派奖", "500");
			tou.setFval10("DLT八等奖派奖");
			updatePaiJiang(tou);
			return "DLT八等奖派奖";
		}
		 
 
		
		return "";
	}
}
