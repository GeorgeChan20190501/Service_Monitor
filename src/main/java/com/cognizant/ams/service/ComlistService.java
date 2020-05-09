package com.cognizant.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ams.bean.Organization;
import com.cognizant.ams.dao.OrganizationMapper;

@Service
public class ComlistService {

	@Autowired
	private OrganizationMapper organizationMapper;
	
	public List<Organization> getComlist(){
		
		List<Organization> map=organizationMapper.getAllCom();
		return map;
		
	}
}
