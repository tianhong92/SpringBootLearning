package com.tianhong.springbootfirstapp.controller;

import com.tianhong.springbootfirstapp.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private int age;

    @Autowired
    ConfigBean configBean;

    @RequestMapping("/")
    public String index() {
        return configBean.toString();
    }
}
