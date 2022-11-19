package com.esprit.microservices.bean;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReclamationResponse {
    private String title ;
    private String content ;
    private Boolean status;

}
