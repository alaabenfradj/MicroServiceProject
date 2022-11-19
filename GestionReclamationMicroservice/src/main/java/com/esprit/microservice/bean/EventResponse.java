package com.esprit.microservice.bean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

    private int id ;
    private String title ;
	private String description ;
	private String type ;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date eventDate ;


}


