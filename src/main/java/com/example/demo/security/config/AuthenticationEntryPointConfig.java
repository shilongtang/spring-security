package com.example.demo.security.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 青菜
 * @Date: 2019/8/30 下午6:12
 * @Description: 未登录
 * @Version 1.0
 */
@Component
public class AuthenticationEntryPointConfig implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JSONObject json = new JSONObject();
        json.put("msg","未登录");
        httpServletResponse.setContentType("application/json;charset=utf-8");

        httpServletResponse.getWriter().write("null");
    }
}
