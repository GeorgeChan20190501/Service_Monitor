package com.cognizant.ams.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.HashedMap;

public class ExpressPattern
{
    public static  List<Map<String, String>> getSNInfo( String message,String type ){
      // 按指定模式在字符串查找
    	String pattern ="";
		
		  if (type.equals("createTime")) { 
			  //拿到所有 
			  pattern = "(\\d{2}-\\d{2}-\\d{4}(.*)M)(.*)(Work notes)(.*)"; 
		  }
		 
      if (type.equals("AMSTime")) {
    	  //响应专属
    	  pattern = "(\\d{2}-\\d{2}-\\d{4}(.*)M)(.*)(Yongming Su|zhang Song|George Chan|Andy Chen|Kevin Li|Xinwu Zhang|lan Lan|Shutao Luo|Jonny Chang|Chen Cao|Jonny Lu|LiXain Chen|Guangyong Li|Li Chen|zhang Haibo|Cylee Cao|Yanghao Shi|Haijing Geng|Junhao Hu|Oliver Wang|Neal Dong|Mei Zeng|leo luo)(.*)(Work notes)(.*)";
	  }
      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(message);
      List<Map<String, String>> list =new ArrayList<Map<String, String>>();
      Map<String, String>map ;
      while (m.find( )) {
    	 map =new HashedMap<String, String>();
         map.put("all", m.group(0) );
         map.put("workMember", m.group(4));
         map.put("time", m.group(1));
         list.add(map);
      }  
      return list;
   }
    public static void main(String[] args) {
		
		  String message = "\"05-11-2020 02:43 PM - Guangyong Li (Work notes)\r\n" +
		  "逻辑确认\r\n" + "\r\n" + "05-11-2020 11:42 AM - Guangyong Li (Work notes)\r\n" +
		  "pending\r\n" + "\r\n" + "05-11-2020 11:23 AM - jingya gao (Work notes)\r\n" +
		  "请协助处理，用户表示主管即是系统所有者\r\n" + "\r\n" +
		  "05-11-2020 09:43 AM - Cylee Cao (Work notes)\r\n" + "请联系用户提供签字\r\n" + "\r\n"
		  + "\"\r\n" + ""; 
			/*
			 * assignTime(message); wipTime(message); pedingTime(message);
			 * ResolvedTime(message);
			 */
		 
    	//System.out.println(resolvedPedingTime(message));
	}
    public static String assignTime(String message) {
    	List<Map<String, String>> list=getSNInfo(message,"createTime");
    	Collections.reverse(list);
    	String assignTime="";
    	if (list.size()>0) {
    		 assignTime=DateFormatUtils.formatAM(list.get(0).get("time"));
		}
    	
    	//System.out.println("assignTime="+assignTime);
    	return assignTime;
    }
    public static String wipTime(String message) {
    	List<Map<String, String>> list=getSNInfo(message,"AMSTime");
    	Collections.reverse(list);
    	String wipTime="";
    	if (list.size()>0) {
    		wipTime=DateFormatUtils.formatAM(list.get(0).get("time"));
		}
    	//System.out.println("wipTime="+wipTime);
    	return wipTime;
    }
    
    public static String pedingTime(String message) {
    	List<Map<String, String>> list=getSNInfo(message,"AMSTime");
    	String pedingTime="";
    	if (list.size()>0) {
    		pedingTime=DateFormatUtils.formatAM(list.get(0).get("time"));
		}
    	//System.out.println("pedingTime="+pedingTime);
    	return pedingTime;
    }
    public static String resolvedPedingTime(String message,String origin) {
    	int index = message.indexOf("pending");
    	String msg=origin.substring(0,index);
    
    	return assignTime(msg);
    }
    
    public static String ResolvedTime(String message) {
    	List<Map<String, String>> list=getSNInfo(message,"AMSTime");
    	String ResolvedTime="";
    	if (list.size()>0) {
    		ResolvedTime=DateFormatUtils.formatAM(list.get(0).get("time"));
		}
    	//System.out.println("ResolvedTime="+ResolvedTime);
    	return ResolvedTime;
    }
}





