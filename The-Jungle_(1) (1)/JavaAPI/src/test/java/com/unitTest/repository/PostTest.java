package com.unitTest.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.com.thejungle.dao.implementations.PostDAO;
import dev.com.thejungle.dao.interfaces.PostInt;
import dev.com.thejungle.entity.Post;

public class PostTest {
    
    public static PostInt postDAO = new PostDAO();

    // create a new post 
    @Test
    public void createPost(){
        Post newPost = new Post(
            1337,
            "Minnesota is the best!",
            ".png"
        );

        Post result = postDAO.createPost(newPost);
        Assert.assertNotNull(result);
    }

    // get all posts
    @Test
    public void getAllPosts(){
        List<Post> result = postDAO.getAllPosts(1337);
        Assert.assertNotNull(result);
    }
}
