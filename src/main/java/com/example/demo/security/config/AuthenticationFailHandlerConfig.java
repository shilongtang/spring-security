package com.example.demo.security.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 青菜
 * @Date: 2019/9/4 下午5:25
 * @Description:
 * @Version 1.0
 */
@Slf4j
@Component
public class AuthenticationFailHandlerConfig extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        JSONObject json = new JSONObject();
        json.put("msg","登录失败");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json.toJSONString());
    }
}
