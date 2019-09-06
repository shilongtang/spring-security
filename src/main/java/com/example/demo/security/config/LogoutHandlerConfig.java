package com.example.demo.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午8:00
 * @Description: 注销配置
 * @Version 1.0
 */
@Component
public class LogoutHandlerConfig implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        try {
            //redirectUrl即为前端传来自定义跳转url地址
            String url = httpServletRequest.getParameter("redirectUrl");
            //实现自定义重定向
            httpServletResponse.sendRedirect(url);
        }catch (IOException e){

        }
    }
}
