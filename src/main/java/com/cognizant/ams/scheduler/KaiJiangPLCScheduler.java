package com.cognizant.ams.scheduler;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.service.FunService;

@Component
public class KaiJiangPLCScheduler {
	
	@Autowired
	private FunService funService;

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void run() {
		// 产生随机开奖号码
		//Set<Integer> set9 = new HashSet<Integer>();
		String daxiao="大";
		int arr9[] = new int[3];
		
		for (int i=0;i<3;i++) {
			arr9[i] =(int) Math.ceil(Math.random() * 10);
		}
		int a = (int) Math.ceil(Math.random() * 2);
	
		SmFun smFun = new SmFun();
		for (int i = 0; i < arr9.length; i++) {
			if (i == 0) {
				smFun.setFval1(arr9[0]+"");
			}
			if (i == 1) {
				smFun.setFval2(arr9[1]+"");
			}
			if (i == 2) {
				smFun.setFval3(arr9[2]+"");
			}
		}
		if (a==1) {
			daxiao="小";
		}
		smFun.setFval9(daxiao);
		smFun.setType("PLC");
		smFun.setFval8("sys");
		//System.out.println(arr9[0]+","+arr9[1]+","+arr9[2]);
		funService.kaiJiang(smFun);
		System.out.println("PLC开奖执行成功");
		System.out.println("开始自动兑奖");
		
		//先获取本次开奖结果。 2.获取本期所有投注  3.判断是否中奖，4.按奖项新增积分
		funService.duijiang(smFun);
		System.out.println("自动兑奖完成");
	}

	public static void main(String[] args) throws Exception {
		new KaiJiangPLCScheduler().run();
		//System.out.println(Math.ceil(Math.random() * 9));
	}
}
