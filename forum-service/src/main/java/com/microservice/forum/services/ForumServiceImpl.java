package com.microservice.forum.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.microservice.forum.beans.ForumResponse;
import com.microservice.forum.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;
import com.microservice.forum.repositories.ForumRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForumServiceImpl implements IForumService {

    @Autowired
    UserClient userClient;
    @Autowired
    ForumRepository forumRepository;


    @Autowired
    IPostService iPostService;

    @Override
    public Forum addForum(Forum f) {
        f.setCreatedBy(userClient.getUser().getId());
        return forumRepository.save(f);
    }

    @Override
    public void deleteForum(int id) {

        forumRepository.deleteById(id);
    }

    @Override
    public Forum updateForum(Forum f) {

        return forumRepository.save(f);
    }

    @Override
    public Forum getForumById(int id) {

        return forumRepository.findById(id).orElse(null);
    }

    @Override
    public List<ForumResponse> getAllForums() {
        List<ForumResponse> forumResponses = new ArrayList<>();
        for (Forum f : forumRepository.findAll()) {
            ForumResponse forumResponse = ForumResponse.builder()
                    .id(f.getId())
                    .title(f.getTitle())
                    .topic(f.getTopic())
                    .created(f.getCreated())
                    .type(f.getType())
                    .posts(f.getPosts())
                    .date(f.getDate())
                    .createdBy(userClient.getUserById(f.getCreatedBy()))
                    .build();
            forumResponses.add(forumResponse);
        }

        return forumResponses;
    }

    @Override
    public List<Post> getPostByForum(int id) {

        return this.getForumById(id).getPosts();
    }

    @Override
    @Transactional
    public ForumResponse assignPostsToForums(Post post, int id) {

        post.setPostBy(userClient.getUser().getId());
        post.setForum(this.getForumById(id));
        iPostService.AddPost(post);
        this.getForumById(id).getPosts().add(post);
        Forum f = this.getForumById(id);
        return ForumResponse.builder()
                .id(f.getId())
                .title(f.getTitle())
                .topic(f.getTopic())
                .created(f.getCreated())
                .type(f.getType())
                .posts(f.getPosts())
                .date(f.getDate())
                .createdBy(userClient.getUserById(f.getCreatedBy()))
                .build();
    }

    @Override
    public List<Forum> findForumsByDate(Date date) {
        return forumRepository.findForumByDate(date);
    }

    @Override
    public List<ForumResponse> findForumsByType(ForumType f) {

        List<ForumResponse> forums = new ArrayList<>();
        this.getAllForums().forEach(forum -> {
            if (forum.getType().equals(f)) {
                forums.add(forum);
            }
        });
        return forums;

    }

    @Override
    public List<ForumResponse> filterForums(String title, String type, String userId, Date date) {


        List<ForumResponse> forumResponses = new ArrayList<>();
        Forum forum = Forum.builder()
                .id(null)
                .title(title)
                .createdBy(userId)
                .date(date)
                .build();
        if(type!=null){
            forum.setType(ForumType.valueOf(type));
        }
        for (Forum f : forumRepository.findAll(Example.of(forum))){
            ForumResponse forumResponse = ForumResponse.builder()
                    .id(f.getId())
                    .title(f.getTitle())
                    .topic(f.getTopic())
                    .created(f.getCreated())
                    .type(f.getType())
                    .posts(f.getPosts())
                    .date(f.getDate())
                    .createdBy(userClient.getUserById(f.getCreatedBy()))
                    .build();
            forumResponses.add(forumResponse);
        }

        return forumResponses;
    }

}
