package com.cognizant.ams.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResUI {

	public static Map<String, Object> getData(List<?>list) {
		Map<String, Object> map =new HashMap<>();
		int count =0;
		if (list!=null) {
			count=list.size();
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",count );
		map.put("data", list);
		return map;
	}
	
	public static Map<String, Object> getDataFenYe(List<?>list,int page,int limit) {
		Map<String, Object> map =new HashMap<>();
		int totalCount =0;
		if (list!=null) {
			totalCount=list.size();
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count",totalCount );
		if (totalCount>=page*limit) {
			list = list.subList((page-1)*limit, page*limit);
		}
		else {
			list = list.subList((page-1)*limit, totalCount);
		}
		map.put("data", list);
		return map;
	}

	
}
