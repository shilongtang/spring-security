package com.example.demo.service.impl;

import com.example.demo.model.SelfUserDetails;
import com.example.demo.service.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 青菜
 * @Date: 2019/9/5 上午11:35
 * @Description:
 * @Version 1.0
 */
@Service("rbacService")
public class RbacServiceImpl implements RbacService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        System.out.println(principal instanceof SelfUserDetails);
        //System.out.println( (SelfUserDetails) principal);
        if (principal instanceof SelfUserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
           /* String userName = ((UserDetails) principal).getUsername();
            Set<String> urls = new HashSet<>(); // 数据库读取 //读取用户所拥有权限的所有URL

            urls.add("/whoim");
            // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }*/
        }
        return hasPermission;
    }
}
