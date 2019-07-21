package com.atguigu.atcrowdfunding.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.TManager;
import com.atguigu.atcrowdfunding.manager.dao.TestDao;
import com.atguigu.atcrowdfunding.manager.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;

	private TManager tManager;
	@Override
	public void query() {
		// TODO Auto-generated method stub
		
		tManager=testDao.query();
		System.out.println(tManager.getName());
	}

}
