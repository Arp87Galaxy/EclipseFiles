package com.atguigu.atcrowdfunding.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.TUser;
import com.atguigu.atcrowdfunding.exception.LoginFailException;
import com.atguigu.atcrowdfunding.manager.dao.TUserMapper;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.atguigu.atcrowdfunding.util.Page;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private TUserMapper tUserMapper;

	@Override
	public TUser queryUserLogin(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		TUser tUser =tUserMapper.queryUserlogin(paramMap);
		if(tUser==null) {
			throw new LoginFailException("用户账号或密码不正确");
		}
		return tUser;
	}
	@Override
	public Page queryPage(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Page page = new Page((Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));
		
		Integer startIndex = page.getStartIndex();
		paramMap.put("startIndex", startIndex);
		List<TUser> datas= tUserMapper.queryList(paramMap);
		
		page.setDatas(datas);
		
		Integer totalsize = tUserMapper.queryCount(paramMap);
		page.setTotalsize(totalsize);
		return page;
	}

//	@Override
//	@Deprecated
//	public Page queryPage(Integer pageno, Integer pagesize) {
//		// TODO Auto-generated method stub
//		Page page = new Page(pageno,pagesize);
//		
//		Integer startIndex = page.getStartIndex();
//		List<TUser> datas= tUserMapper.queryList(startIndex,pagesize);
//		
//		page.setDatas(datas);
//		
//		Integer totalsize = tUserMapper.queryCount();
//		page.setTotalsize(totalsize);
//		return page;
//	}

	@Override
	public int saveUser(TUser tUser) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createtime = sdf.format(date);
		
		tUser.setCreatetime(createtime);
		tUser.setUserpswd(MD5Util.digest(Const.PASSWORD));
		return tUserMapper.insert(tUser);
	}
	@Override
	public TUser queryUser(TUser tUser) {
		
		tUser= tUserMapper.selectByPrimaryKey(tUser.getId());

		return tUser;
	}
	@Override
	public int modifyUser(TUser tUser) {
		// TODO Auto-generated method stub
		int status = tUserMapper.updateUser(tUser);
		return status;
	}
	@Override
	public int deleteUser(TUser tUser) {
		// TODO Auto-generated method stub
		int status = tUserMapper.deleteByPrimaryKey(tUser.getId());
		return status;
	}
	@Override
	public int deleteBatchUser(Integer[] arrayId ) {
		int status = 0;
		for(Integer id:arrayId) {
			status += tUserMapper.deleteByPrimaryKey(id);
		}

		return status;
	}



}
