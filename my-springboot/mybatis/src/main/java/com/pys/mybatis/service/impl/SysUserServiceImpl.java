package com.pys.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pys.mybatis.dao.SysUserMapper;
import com.pys.mybatis.model.SysUser;
import com.pys.mybatis.service.SysUserService;
import com.pys.mybatis.utils.PageRequest;
import com.pys.mybatis.utils.PageResult;
import com.pys.mybatis.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserServiceImpl implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    public SysUser findByUserId(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return PageInfo
     */
    private PageInfo<SysUser> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> sysMenus = sysUserMapper.selectPage();
        return new PageInfo<SysUser>(sysMenus);
    }
}