package com.pys.shiro.service;


import com.pys.shiro.model.ShiroUser;

public interface LoginService {

	ShiroUser findByName(String name);


	
}