package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.TMemberAddress;
import java.util.List;

public interface TMemberAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMemberAddress record);

    TMemberAddress selectByPrimaryKey(Integer id);

    List<TMemberAddress> selectAll();

    int updateByPrimaryKey(TMemberAddress record);
}