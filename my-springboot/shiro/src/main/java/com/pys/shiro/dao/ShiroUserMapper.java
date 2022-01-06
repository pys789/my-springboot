package com.pys.shiro.dao;


import com.pys.shiro.model.ShiroUser;

public interface ShiroUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroUser record);

    int insertSelective(ShiroUser record);

    ShiroUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroUser record);

    int updateByPrimaryKey(ShiroUser record);

    ShiroUser queryByName(String name);
}