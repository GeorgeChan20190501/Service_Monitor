package com.cognizant.ams.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ams.bean.SmSn;
import com.cognizant.ams.dao.SmSnMapper;

@Service
public class SnService {

	@Autowired
	private SmSnMapper smSnMapper;
	
	 public void saveOrUpdateSN(List<SmSn> snList) {
		 //首先根据Ticket编号取数据库查找是否已经记录过，如有直接更新。
		 List<SmSn> listExisted = smSnMapper.getSNByTicketNo(snList);
		 List<String> list1=new ArrayList<String>();
		 List<String> list2=new ArrayList<String>();
		 List<SmSn> listUpdate=new ArrayList<SmSn>();
		 List<SmSn> listAdd=new ArrayList<SmSn>();
		 for (SmSn sn : snList) {
			 for (SmSn smSn : listExisted) {
				 if (sn.getTicketNo().equals(smSn.getTicketNo())) {
					 list1.add(smSn.getTicketNo());
					 listUpdate.add(sn);
					 break;
				}
			}
			if (!list1.contains(sn.getTicketNo())) {
				list2.add(sn.getTicketNo());
				listAdd.add(sn);
			} 
		}
		 System.out.println("已有的INC"+list1);
		 System.out.println("新增的INC"+list2);
		 
		 //add
		 smSnMapper.insertNewSN(listAdd);
		 //update
		 smSnMapper.updateSN(listUpdate);
	 }

	public List<SmSn> queryFenyeSN(SmSn smSntlist) {
		// TODO Auto-generated method stub
		return smSnMapper.queryFenyeSN(smSntlist);
	}
 
}
