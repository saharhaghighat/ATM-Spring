package com.atmspring.atmspring.config;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiUrlProperties {

    private List<String> publicUrls;

    public ApiUrlProperties() {
        this.publicUrls = new ArrayList<>();
        this.publicUrls.add("/account/login");
    }

    public List<String> getPublicUrls() {
        return publicUrls;
    }
}
