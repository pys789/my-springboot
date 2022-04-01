package com.pys.mybatis.controller;

import com.pys.mybatis.dao.EnumTestMapper;
import com.pys.mybatis.dao.PersonMapper;
import com.pys.mybatis.enums.Color;
import com.pys.mybatis.enums.SexEnum;
import com.pys.mybatis.model.EnumTest;
import com.pys.mybatis.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by pengys on 2022/3/29
 */
@RestController
@RequestMapping("enum")
public class EnumTestController {

    @Resource
    private EnumTestMapper enumTestMapper;

    @Resource
    private PersonMapper personMapper;

    @GetMapping(value = "/findById")
    public EnumTest findById() {
        EnumTest test = enumTestMapper.selectByPrimaryKey(1L);
        Assert.isTrue(test.getColor().equals(Color.BLUE), "不是蓝色");
        return test;
    }

    @GetMapping(value = "/save")
    public EnumTest save() {
        EnumTest test = new EnumTest();
        test.setBrand("apple");
        test.setColor(Color.BLUE);
        enumTestMapper.insert(test);
        return test;
    }

    @GetMapping(value = "/person")
    public Person find() {
        Person person = personMapper.selectByPrimaryKey(1);
        System.out.println(person.getSex().getDesc());
        return person;
    }

    @GetMapping(value = "/person/save")
    public Person personSave() {
        Person test = new Person();
        test.setName("test");
        test.setSex(SexEnum.M);
        test.setCreateTime(new Date());
        personMapper.insert(test);
        return test;
    }
}
