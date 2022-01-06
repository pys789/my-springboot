package com.pys.mybatis.dao;

import com.pys.mybatis.model.SysUser;

import java.util.List;

public interface SysUserMapper {

    SysUser selectByPrimaryKey(Long id);
    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 分页查询用户
     * @return
     */
    List<SysUser> selectPage();
}