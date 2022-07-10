package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 定義攔截器
public class IndexInterceptor implements HandlerInterceptor {

    /**
     *
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler chosen handler to execute, for type and/or instance evaluation
     * @return true = 放行, false = 攔截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 重定向到首頁
        response.sendRedirect("/web/stock.html");
        return false;
    }
}
