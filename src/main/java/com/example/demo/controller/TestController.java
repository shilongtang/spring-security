package com.example.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午5:01
 * @Description:
 * @Version 1.0
 */
@RestController
public class TestController {

    @GetMapping("/whoIm")
    public String whoIm()
    {
        return "安达市多";
    }

    @GetMapping("/role/test/whoIm")
    public Object roleTest()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @GetMapping("/test2/whoIm")
    public Object test2()
    {
        return SecurityContextHolder.getContext().getAuthentication().getClass();
    }

}
