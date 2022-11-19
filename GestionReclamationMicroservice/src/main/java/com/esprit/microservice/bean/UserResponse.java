package com.esprit.microservice.bean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Collection;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String id ;
    private String firstName ;
    private String lastName ;
    private String userName ;
    private String email ;
    private String password ;
    private int phone ;
    private Collection roles =new ArrayList<>() ;


}

