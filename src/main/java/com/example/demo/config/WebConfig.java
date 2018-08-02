package com.example.demo.config;

import com.example.demo.config.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TestInterceptor testInterceptor;

    // 인터셉터에서 제외되는 URL 주소
    private static final String[] EXCLUDE_PATHS = {
            "/api/error",
    };

    // 인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(EXCLUDE_PATHS);
    }
}
