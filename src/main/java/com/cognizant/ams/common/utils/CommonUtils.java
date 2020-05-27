package com.cognizant.ams.common.utils;

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
		int arr [] =new int [3];
		arr[0]=0;
		arr[1]=1;
		arr[2]=5;
		
		
		int jiang [] =new int [3];
		jiang[0]=2;
		jiang[1]=5;
		jiang[2]=9;
		System.out.println("混合="+mix("051", arr));;
		
		System.out.println("直接="+zhi(jiang, arr));;
	}
	
}
