package com.esprit.microservices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.microservices.bean.ReclamationResponse;

@FeignClient(name = "RECLAMATION")
public interface ReclamationClient {

    @GetMapping(value = "/reclamations/{id}")
    public ReclamationResponse getReclamationById(@PathVariable("id")String id);
    
}
