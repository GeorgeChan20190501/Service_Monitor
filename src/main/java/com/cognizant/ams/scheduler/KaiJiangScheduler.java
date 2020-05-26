package com.cognizant.ams.scheduler;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cognizant.ams.bean.SmFun;
import com.cognizant.ams.service.FunService;

@Component
public class KaiJiangScheduler {
	
	@Autowired
	private FunService funService;

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void run() {
		// 产生随机开奖号码

		Set<Integer> set35 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();

		int arr35[] = new int[5];
		int arr2[] = new int[2];

		while (set35.size() < 5) {
			int a = (int) Math.ceil(Math.random() * 35);
			set35.add(a);
		}

		while (set2.size() < 2) {
			int a = (int) Math.ceil(Math.random() * 12);
			set2.add(a);
		}

		int m = 0;

		for (int i : set35) {
			arr35[m] = i;
			m++;
		}
		int n = 0;
		for (int i : set2) {
			arr2[n] = i;
			n++;
		}

		int length = arr2.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				int temp = 0;
				if (arr2[i] > arr2[j]) {
					temp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp;
				}
			}
		}

		int length1 = arr35.length;
		for (int i = 0; i < length1 - 1; i++) {
			for (int j = i + 1; j < length1; j++) {
				int temp = 0;
				if (arr35[i] > arr35[j]) {
					temp = arr35[i];
					arr35[i] = arr35[j];
					arr35[j] = temp;
				}
			}
		}
		SmFun smFun = new SmFun();
		for (int i = 0; i < arr35.length; i++) {
			if (i == 0) {
				smFun.setFval1(arr35[0]+"");
			}
			if (i == 1) {
				smFun.setFval2(arr35[1]+"");
			}
			if (i == 2) {
				smFun.setFval3(arr35[2]+"");
			}
			if (i == 3) {
				smFun.setFval4(arr35[3]+"");
			}
			if (i == 4) {
				smFun.setFval5(arr35[4]+"");
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (i == 0) {
				smFun.setFval6(arr2[0]+"");
			}
			if (i == 1) {
				smFun.setFval7(arr2[1]+"");
			}
		}
		smFun.setFval8("sys");
		smFun.setType("DLT");
		funService.kaiJiang(smFun);
		System.out.println("开奖执行成功");
	}

	public static void main(String[] args) throws Exception {
		new KaiJiangScheduler().run();
	}
}
