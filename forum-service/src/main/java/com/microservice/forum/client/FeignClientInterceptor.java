package com.microservice.forum.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
public class FeignClientInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       // assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        final String authorization = HttpHeaders.AUTHORIZATION;
        String token = request.getHeader(authorization);
        if (token != null) {

            requestTemplate.header("AUTHORIZATION",token);


        }
    }

}