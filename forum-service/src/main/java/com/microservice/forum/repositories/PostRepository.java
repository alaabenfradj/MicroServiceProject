package com.microservice.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.forum.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
