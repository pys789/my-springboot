package com.pys.mybatis.controller;

import com.pys.mybatis.service.SysUserService;
import com.pys.mybatis.utils.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// http://localhost:8080/mybatis/swagger-ui.html
@RestController
@RequestMapping("user")
@Api(value = "用户测试")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    
    @GetMapping(value="/findByUserId")
    public Object findByUserId(@RequestParam Long userId) {
        return sysUserService.findByUserId(userId);
    }
    
    @GetMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @ApiOperation(value = "desc of method", notes = "")
    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody @ApiParam(value = "desc of param" , required=true) PageRequest pageQuery) {
        return sysUserService.findPage(pageQuery);
    }
}