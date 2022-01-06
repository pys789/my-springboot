package com.pys.ds.service.impl;

import com.pys.ds.config.DataSource;
import com.pys.ds.config.DataSourceKey;
import com.pys.ds.dao.SysUserMapper;
import com.pys.ds.model.SysUser;
import com.pys.ds.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }

    @DataSource(value= DataSourceKey.SLAVE)
    @Transactional
    @Override
    public List<SysUser> findAll2() {
        // 测试事务
        // sysUserMapper.deleteByPrimaryKey(1L);
        return sysUserMapper.selectAll();
    }
}