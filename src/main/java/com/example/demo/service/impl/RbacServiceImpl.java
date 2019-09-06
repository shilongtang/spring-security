package com.example.demo.service.impl;

import com.example.demo.service.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 青菜
 * @Date: 2019/9/5 上午11:35
 * @Description:
 * @Version 1.0
 */
@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        String userName = (String) authentication.getPrincipal();
        //读取当前用户是否拥有 url 权限
        //todo 未实现
        if (antPathMatcher.match("", request.getRequestURI())) {
            return true;
        }
        return false;
    }
}
