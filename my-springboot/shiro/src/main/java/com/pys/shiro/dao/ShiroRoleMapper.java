package com.pys.shiro.dao;


import com.pys.shiro.model.ShiroRole;

import java.util.List;

public interface ShiroRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroRole record);

    int insertSelective(ShiroRole record);

    ShiroRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroRole record);

    int updateByPrimaryKey(ShiroRole record);

    List<String> getRolesByUserId(Long id);
}