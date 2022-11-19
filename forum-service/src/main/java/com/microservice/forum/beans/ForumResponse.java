package com.microservice.forum.beans;

import com.microservice.forum.entities.ForumType;

import com.microservice.forum.entities.Post;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForumResponse {

    private Integer id;
    private String title;
    private String topic;
    private ForumType type;
    private Date created;
    private Date date;
    private UserResponse createdBy;
    private List<Post> posts;

}