package com.pys.shiro.service.impl;

import com.pys.shiro.dao.ShiroRoleMapper;
import com.pys.shiro.dao.ShiroUserMapper;
import com.pys.shiro.model.ShiroUser;
import com.pys.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ShiroUserMapper userMapper;

    @Autowired
    private ShiroRoleMapper roleMapper;

    @Override
    public ShiroUser findByName(String name) {
        ShiroUser shiroUser = userMapper.queryByName(name);
        if(shiroUser!=null){
            List<String> roles = roleMapper.getRolesByUserId(shiroUser.getId());
            shiroUser.setRoles(roles);
        }
        return shiroUser;
    }
}