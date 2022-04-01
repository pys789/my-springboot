package com.pys.mybatis.dao;

import com.pys.mybatis.model.EnumTest;

public interface EnumTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EnumTest record);

    int insertSelective(EnumTest record);

    EnumTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnumTest record);

    int updateByPrimaryKey(EnumTest record);
}