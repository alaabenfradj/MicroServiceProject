package com.microservice.forum.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private List<RoleResponse> roles =new ArrayList<RoleResponse>() ;


}
