package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    /**
     * 에러가 전달받아 처리하는 메서드.
     * @param request
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/api/error")
    @ResponseBody
    public void apiError(HttpServletRequest request) throws Exception {
        String message = (String) request.getAttribute("message");
        String exception = (String) request.getAttribute("exceptionClass");

        if(exception.equals("UnauthorizedException")){
            throw new RuntimeException(message);
        } else if(exception.equals("CustomException")){
            throw new IOException(message);
        } else {
            throw new Exception(message);
        }
    }


    @CrossOrigin
    @GetMapping("/api/test")
    @ResponseBody
    public Map test(HttpServletRequest request){
        System.out.println("==================== 테스트");

        Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String key = e.nextElement();
            System.out.println("============== " + key + " : " + request.getHeader(key));
        }

        Map result = new HashMap();
        result.put("code", "0000");
        result.put("message", "인증테스트 성공");
        return result;
    }
}