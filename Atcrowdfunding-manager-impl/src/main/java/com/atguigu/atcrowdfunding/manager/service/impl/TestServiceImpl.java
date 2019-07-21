package com.atguigu.atcrowdfunding.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.TManager;
import com.atguigu.atcrowdfunding.manager.dao.TestDao;
import com.atguigu.atcrowdfunding.manager.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;

	private TManager tManager=null;
	@Override
	public void query() {
		// TODO Auto-generated method stub
		
		List list=testDao.query();
		System.out.println(list);
	}
	@Override
	public void insert() {
		Map map = new HashMap();
		map.put("name", "zhang3");
		System.out.println(map);
//		tManager=new TManager();
//		tManager.setName("zhangwang");
		System.out.println("11");
		 testDao.insert(map);
		System.out.println("success");
		
	}

}
