package com.atguigu.atcrowdfunding.manager.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.bean.TManager;

public interface TestDao {
//	@Select("select * from t_manager")
	public ArrayList query();
	public void insert(Map map);
}
