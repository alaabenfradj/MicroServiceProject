package com.microservice.forum.controllers;

import java.util.List;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.microservice.forum.entities.Post;
import com.microservice.forum.services.IPostService;

@RestController
@RequestMapping("posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostRestController {

	@Autowired
	IPostService iPostService;

	@PostMapping
	public ResponseEntity<Post> addPost(@RequestBody Post post) {

		return new ResponseEntity<Post>(iPostService.AddPost(post), HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Post> update(@RequestBody Post post) {

		return new ResponseEntity<Post>(iPostService.updatePost(post), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {

		iPostService.deletePost(id);

		return new ResponseEntity<String>("Post deleted", HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable("id") int id) {

		return new ResponseEntity<Post>(iPostService.findById(id), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {

		return new ResponseEntity<List<Post>>(iPostService.getAllPosts(), HttpStatus.OK);

	}

}
