package com.esprit.microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esprit.microservice.bean.EventResponse;


@FeignClient(name = "EVENT" ,configuration = FeignClientConfiguration.class)

public interface EventClient {
	
	@GetMapping(value="/events/{id}")
	    public  EventResponse getEventById(@PathVariable("id") int id) ;
		
	


}
