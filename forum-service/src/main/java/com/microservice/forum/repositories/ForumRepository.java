package com.microservice.forum.repositories;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.forum.entities.Forum;

@Repository
public interface ForumRepository   extends JpaRepository<Forum, Integer>{

	@Query("select f from Forum f where :date between f.created and f.date")
	public List<Forum> findForumByDate(@Param("date")Date date);
}
