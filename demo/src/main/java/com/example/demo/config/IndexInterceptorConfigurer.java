package com.example.demo.config;

import com.example.demo.interceptor.IndexInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

// 攔截器註冊
@Configuration
public class IndexInterceptorConfigurer implements WebMvcConfigurer {

    // 配置攔截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        HandlerInterceptor interceptor = new IndexInterceptor();

        //白名單
        List<String> whiteList = new ArrayList<>();
        whiteList.add("/css/**");
        whiteList.add("/js/**");
        whiteList.add("/web/stock.html");
        whiteList.add("/stock/**");

        //全部路經添加至黑名單, 除了指定白名單外
        //當重定向次數過多, 可能會導致瀏覽器無法正常訪問

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(whiteList);
    }
}
