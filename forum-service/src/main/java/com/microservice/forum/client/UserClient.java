package com.microservice.forum.client;


import com.microservice.forum.beans.UserResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "USER-SERVICE", configuration = FeignClientInterceptor.class)
public interface UserClient {

    @GetMapping(value="/api/username", consumes = "application/json")
    @Headers("Authorization: application/json")
    public UserResponse getUser() ;

    @GetMapping(value="/api/user/{id}", consumes = "application/json")
    @Headers("Authorization: application/json")
    public UserResponse getUserById(@PathVariable("id")String id) ;

}
