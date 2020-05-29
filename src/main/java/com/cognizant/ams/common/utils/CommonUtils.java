package com.cognizant.ams.common.utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

	public static  int [] sortAZ(int [] str) {
		int length = str.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				int temp = 0;
				if (str[i] > str[j]) {
					temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		return str;
	}
	
	
	public static  int  mix(String jiang,int [] str) {
		int length = str.length;
		int jiangl=jiang.length();
		int count=0;
		for (int i = 0; i < length ; i++) {
			if (jiang.contains(str[i]+"")) {
				count++;
				int pos = jiang.indexOf(str[i]+""); 
				if (pos==0) {
					jiang=jiang.substring(pos+1,jiangl);
				}
				else if (pos==jiangl-1) {
					jiang=jiang.substring(0,jiangl-1);
				}
				else {
					String pre =jiang.substring(0,pos);
					String post = jiang.substring(pos+1,jiangl);
					jiang =pre+ post;
				}
				jiangl=jiang.length();
			}
		}
		return count;
	}
	
	
	public static  int  mix(List<String> list1,List<String> list2) {
		//list1.add("1");list1.add("3");list1.add("4");list1.add("9");list1.add("12");
		//list2.add("1");list2.add("3");list2.add("6");list2.add("12");list2.add("12");
		int count=0;
		int length1=list1.size();
		int length2=list2.size();
		for (int i = 0; i <length1; i++) {
			
			String jiang1=list1.get(i);
			for (int j= 0; j <length2; j++) {
				String tou1 = list2.get(j);
				System.out.println("list1="+list1.get(i)+"====== list="+tou1);
				   if(jiang1.equals(tou1)) {
					   list1.remove(i--);
					   list2.remove(j--);
					   length1--;
					   length2--;
					   count++;
					   break;
				   }
			}
		}
		 
		
		
		return count;
	}
	public static  int  zhi(int [] jiang,int [] tou) {
		int j1 = jiang.length;
		int count=0;
		for (int i = 0; i < j1 ; i++) {
			if (jiang[i]==tou[i]) {
				count++;
			}
		}
		
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int arr1 [] = new int[5];
		arr1[0] = 3; arr1[1] = 6; arr1[2] =16 ;arr1[3] = 23;arr1[4] = 31;
		
		int arr2 [] = new int[5];
		arr2[0] = 3; arr2[1] = 8; arr2[2] = 10;arr2[3] = 19;arr2[4] = 33;
		System.out.println("直接="+zhi(arr1,arr2));;
	}
	
}
