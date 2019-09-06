package com.example.demo.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: 青菜
 * @Date: 2019/9/3 上午11:15
 * @Description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String pass = "admin";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);
        /*try {
            Thread.sleep(1000);
        }catch (Exception e){

        }*/

        boolean f = bcryptPasswordEncoder.matches("admin", hashPass);
        System.out.println(f);
    }
}
