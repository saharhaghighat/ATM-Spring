package com.atmspring.atmspring.filter;

import com.atmspring.atmspring.config.ApiUrlProperties;
import com.atmspring.atmspring.config.SharedUserContext;
import com.atmspring.atmspring.utill.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final ApiUrlProperties apiUrlProperties;

    public RequestFilter(JwtUtils jwtUtils, ApiUrlProperties apiUrlProperties) {
        this.jwtUtils = jwtUtils;
        this.apiUrlProperties = apiUrlProperties;
        ;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (apiUrlProperties.getPublicUrls().contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
        } else if (jwtUtils.validateToken(token)){
            Claims claims= jwtUtils.getAllClaimsFromToken(token);
            SharedUserContext sharedUserContext=new SharedUserContext();
            sharedUserContext.setUserId((Long) claims.get("uid"));
            sharedUserContext.setAccNumb(claims.get("acc_Numb").toString());
            sharedUserContext.setNationalCode(claims.getSubject());
            filterChain.doFilter(request, response);
        }
        else
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    }
}
