package com.microservice.forum.services;


import java.util.Date;
import java.util.List;

import com.microservice.forum.beans.ForumResponse;
import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;

public interface IForumService {

	Forum addForum(Forum f);
	void deleteForum(int id);
	Forum updateForum(Forum f);
	Forum getForumById(int id);
	List<ForumResponse>getAllForums();
	List<Post> getPostByForum(int id);

	ForumResponse assignPostsToForums(Post post, int id);

	List <Forum>findForumsByDate(Date date);
	
	List <ForumResponse>findForumsByType(ForumType f);

	List<ForumResponse> filterForums(String title, String type, String userName ,Date date);
}
