package com.atguigu.atcrowdfunding.manager.service;

import java.util.Map;

import com.atguigu.atcrowdfunding.bean.TUser;
import com.atguigu.atcrowdfunding.util.Page;

public interface UserService {

	TUser queryUserLogin(Map<String, Object> paramMap);

//	@Deprecated   过 时 方 法
//	Page queryPage(Integer pageno, Integer pagesize);
	
	int saveUser(TUser tUser);

	Page queryPage(Map<String, Object> paramMap);

	TUser queryUser(TUser tUser);

	int modifyUser(TUser tUser);

	int deleteUser(TUser tUser);

	int deleteBatchUser(Integer[] arrayId); 


}
