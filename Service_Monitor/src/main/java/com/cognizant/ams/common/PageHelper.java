package com.cognizant.ams.common;

import java.util.List;

/**
 * 
 * @author change
 * @Desc 统一分页处理
 * @Date 2019年8月25日
 */
public class PageHelper {

	/**
	 * 
	 * @User change
	 * @Date 2019年8月25日
	 * @Desc TODO
	 * @param list  需要进行分页的list集合
	 * @param currentPage 当前页码
	 * @param pageSize      每页大小
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List getDataByFenye(List  list,String currentPage,String pageSize) {
		
		int totalCount =0;
		int current =1;
		int pagesize=0;
		if (currentPage!=null) {
			current=Integer.parseInt(currentPage);
		}
		if (pageSize!=null) {
			pagesize=Integer.parseInt(pageSize);
		}
		if (list==null) {
			return null;
		}
		totalCount=list.size();
		int start=(current-1)*pagesize;
		int end=current*pagesize;
		System.out.println("总条数为"+totalCount+"条，当前起始记录为start="+start+"，结束页end记录为"+end);
		if (totalCount>=end) {
			list = list.subList(start,end );
		}
		else {
			list = list.subList(start, totalCount);
		}
	return  list;
	}
 
}
