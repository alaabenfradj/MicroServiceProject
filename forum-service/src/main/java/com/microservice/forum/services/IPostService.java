package com.microservice.forum.services;



import java.util.List;

import com.microservice.forum.entities.Post;

public interface IPostService {

	Post AddPost(Post p);

	void deletePost(int id);

	Post updatePost(Post p);

	Post findById(int id);

	List<Post> getAllPosts();
	
}
