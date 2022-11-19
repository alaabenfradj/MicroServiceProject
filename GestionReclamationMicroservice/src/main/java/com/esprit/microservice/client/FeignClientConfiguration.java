package com.esprit.microservice.client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class FeignClientConfiguration implements RequestInterceptor {
	/*final  String AUTHORIZATION ;

    public void getAuthToken(HttpServletRequest request) {
       return request.getHeader(AUTHORIZATION);
    }*/


    @Override
    public void apply(RequestTemplate template) {
       /* template.header("Authorization",
                String.format("Bearer %s", getAuthToken()));*/
    }
}
