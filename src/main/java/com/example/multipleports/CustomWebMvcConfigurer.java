package com.example.multipleports;

import com.example.multipleports.first.FirstPortController;
import com.example.multipleports.second.SecondPortController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomHandlerInterceptor());
    }
}

class CustomHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return false;
        }
        var handlerClassPackage = handlerMethod.getBean().getClass().getPackage().getName();
        if (request.getLocalPort() == 8081 && handlerClassPackage.startsWith("com.example.multipleports.first")) {
            return true;
        }
        if (request.getLocalPort() == 8082 && handlerClassPackage.startsWith("com.example.multipleports.second")) {
            return true;
        }
        response.setStatus(404);
        return false;
    }
}
