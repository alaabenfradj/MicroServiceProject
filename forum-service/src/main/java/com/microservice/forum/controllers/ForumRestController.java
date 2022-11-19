package com.microservice.forum.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;


import com.microservice.forum.beans.ForumResponse;
import com.microservice.forum.beans.UserResponse;
import com.microservice.forum.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;
import com.microservice.forum.services.IForumService;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequestMapping("forums")
@CrossOrigin(origins = "http://localhost:3000")
public class ForumRestController {

    @Autowired
    IForumService iForumService;
    @Autowired
    UserClient userClient;


    @PostMapping
    public ResponseEntity<Forum> addForum(@RequestBody Forum forum) {

        return new ResponseEntity<Forum>(iForumService.addForum(forum), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Forum> update(@RequestBody Forum forum) {

        return new ResponseEntity<Forum>(iForumService.updateForum(forum), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        iForumService.deleteForum(id);
        return new ResponseEntity<>("Forum deleted", HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Forum> findById(@PathVariable("id") int id) {

        return new ResponseEntity<Forum>(iForumService.getForumById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ForumResponse>> getAllForums() {

        return new ResponseEntity<List<ForumResponse>>(iForumService.getAllForums(), HttpStatus.OK);

    }

    @GetMapping("/forum/{id}")
    public ResponseEntity<List<Post>> getPostsByForum(@PathVariable("id") int id) {

        return new ResponseEntity<List<Post>>(iForumService.getPostByForum(id), HttpStatus.OK);

    }

    @PutMapping("/forum/{id}")
    public ResponseEntity<ForumResponse> assignPostsToForums(@PathVariable("id") int id, @RequestBody Post post) {

        return new ResponseEntity<>(iForumService.assignPostsToForums(post, id), HttpStatus.OK);
    }

    @PutMapping("/date")
    public ResponseEntity<List<Forum>> getForumByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        return new ResponseEntity<List<Forum>>(iForumService.findForumsByDate(date), HttpStatus.OK);

    }

    @PutMapping("/type")
    public ResponseEntity<List<ForumResponse>> getForumByDate(@RequestParam("type") ForumType type) {

        return new ResponseEntity<>(iForumService.findForumsByType(type), HttpStatus.OK);

    }

    @GetMapping("/user")
    public UserResponse getUser() {

        return userClient.getUser();

    }

    @GetMapping("/getUser/{id}")
    public UserResponse getUserById(@PathVariable("id")String id) {
        return userClient.getUserById(id);

    }


    @GetMapping("/search")
    public ResponseEntity<List<ForumResponse>>getFiltredForums(
            @RequestParam(name = "title",required = false)String title,
            @RequestParam(name="type",required = false)String type,
            @RequestParam(name="userName",required=false)String userName,
            @RequestParam(name="startDate",required=false)@DateTimeFormat(pattern = "yyyy-MM-dd")Date date

    ){
        return new ResponseEntity<>(iForumService.filterForums(title,type,userName,date),HttpStatus.OK);
    }



}
