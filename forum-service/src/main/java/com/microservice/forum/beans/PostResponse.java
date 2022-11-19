package com.microservice.forum.beans;

import com.microservice.forum.entities.Forum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private int id ;
    private String title;
    private String Content;
    private UserResponse postBy;
    private Date date ;
    private ForumResponse forum;
}
