package com.microservice.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.forum.entities.Post;
import com.microservice.forum.repositories.PostRepository;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	PostRepository postRepository;
	@Override
	public Post AddPost(Post p) {
		// TODO Auto-generated method stub
		return postRepository.save(p);
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		postRepository.deleteById(id);
	}

	@Override
	public Post updatePost(Post p) {
		// TODO Auto-generated method stub
		return postRepository.save(p);
	}

	@Override
	public Post findById(int id) {
		// TODO Auto-generated method stub
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return postRepository.findAll();

	}

}
