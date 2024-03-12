package com.example.booksapi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Request received - Method: {}, URI: {}, Headers: {}", request.getMethod(), request.getRequestURI(), request.getHeaderNames());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Response sent - Status: {}, Headers: {}", response.getStatus(), response.getHeaderNames());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}

