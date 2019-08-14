package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.TMemberProjectFollow;
import java.util.List;

public interface TMemberProjectFollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMemberProjectFollow record);

    TMemberProjectFollow selectByPrimaryKey(Integer id);

    List<TMemberProjectFollow> selectAll();

    int updateByPrimaryKey(TMemberProjectFollow record);
}