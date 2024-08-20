package com.yupi.project.config;

import com.yupi.project.util.TokenThreadUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", TokenThreadUtil.getToken());
    }
}
