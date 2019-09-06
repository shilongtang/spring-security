package com.example.demo.security.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 青菜
 * @Date: 2019/8/30 下午6:16
 * @Description: 无权限
 * @Version 1.0
 */
@Component
public class AccessDeniedHandlerConfig implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        JSONObject result = new JSONObject();
        result.put("msg","无权限！");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().println(result.toJSONString());
    }
}
