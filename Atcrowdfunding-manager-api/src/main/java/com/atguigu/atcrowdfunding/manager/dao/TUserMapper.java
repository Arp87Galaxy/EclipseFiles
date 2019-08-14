package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.TUser;
import java.util.List;
import java.util.Map;





public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    TUser selectByPrimaryKey(Integer id);

    List<TUser> selectAll();

    int updateByPrimaryKey(TUser record);

	TUser queryUserlogin(Map<String, Object> paramMap);

//	List<TUser> queryList(@Param("startIndex")Integer startIndex, @Param("pagesize")Integer pagesize);
//
//	Integer queryCount();

	List<TUser> queryList(Map<String, Object> paramMap);

	Integer queryCount(Map<String, Object> paramMap);

	int updateUser(TUser tUser);

//	TUser queryUser(Integer integer);
}