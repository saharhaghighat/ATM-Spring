package com.atmspring.atmspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class RequestConfig {
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST ,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SharedUserContext sharedUserContext(){
        return new SharedUserContext();
    }
}
