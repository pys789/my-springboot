package com.pys.shiro.controller;

import com.pys.shiro.dto.LoginParam;
import com.pys.shiro.utils.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class LoginController {

	@Autowired
	private PasswordHelper passwordHelper;

	/**
	 * POST登录
	 * @return
	 */
	@PostMapping(value = "/login")
	public String login(@RequestBody @Valid LoginParam user) {
		// 添加用户认证信息
		String encryptPassword = passwordHelper.encryptPassword(user.getPassword(), user.getName());
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), encryptPassword);
		// 进行验证，这里可以捕获异常，然后返回对应信息
		SecurityUtils.getSubject().login(usernamePasswordToken);
		return "登录成功";
	}

	@GetMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "退出成功";
	}

	/**
	 * 登录成功才能访问
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		return "访问成功";
	}

	/**
	 * 只有 admin 角色才能访问
	 * @return
	 */
	@RequiresRoles("admin")
	@GetMapping(value = "/test/role")
	public String testRole() {
		return "请求成功";
	}

}