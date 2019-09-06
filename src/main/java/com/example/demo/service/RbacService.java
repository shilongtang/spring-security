package com.example.demo.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 青菜
 * @Date: 2019/9/5 上午11:25
 * @Description: role-Based-access control 用户，角色 ，资源(菜单，按钮，URL)
 * @Version 1.0
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);


}
