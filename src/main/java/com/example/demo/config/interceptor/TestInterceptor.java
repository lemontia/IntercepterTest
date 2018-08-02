package com.example.demo.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("@ 인터셉터 진입");
        String param1 = request.getParameter("param1");

        if(param1 == null){
            request.setAttribute("message", "유효하지 않은 토큰입니다");
            request.setAttribute("exceptionClass", "Exception");
            request.getRequestDispatcher("/api/error").forward(request, response);
        }else if(!param1.equals("test")){
            throw new Exception("파라미터 값이 잘못되었습니다.\n기대값: test, 받은값: " + param1);
        }

        return true;
    }
}
