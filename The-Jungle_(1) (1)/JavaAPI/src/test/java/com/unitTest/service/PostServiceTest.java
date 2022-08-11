package com.unitTest.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.dao.implementations.PostDAO;
import dev.com.thejungle.entity.Post;
import dev.com.thejungle.service.implementations.PostService;
import dev.com.thejungle.service.interfaces.PostServiceInt;

public class PostServiceTest {

    public static PostDAO postDAO = new PostDAO();
    public static PostServiceInt postService = new PostService(postDAO);
    public static PostDAO mockDao = Mockito.mock(PostDAO.class);
    public static PostServiceInt mockService = new PostService(mockDao);
    
    
    // POSITIVE
    @Test 
    public void serviceCreateNewPostPosi(){
        Post createNewPost = new Post(
            3500, 
            "Ay, I'm walking here!", 
            ".jpg"
            );
        Post result = postService.createPostService(createNewPost);
        Assert.assertNotNull(result);
    }

    // NEGATIVE
    @Test  
    public void serviceCreateNewPostNeg(){
        try {
            Post createBadPost = new Post(
                3500, 
                "Ay, I'm walking here! How dare you, I'm a New Yorka. We eat pizza and drink cahfee. I gotta take the subway to get to my jab. Impractical Jokers: the best show ever, no doubt about it. Sewer rats. Taxis and cabs. Gotham City. This is the Big Apple, this is the big city-- where it's all happening. If you can make it here, you can make it anywhere.", 
                ".jpg"
            );
            postService.createPostService(createBadPost);
            Assert.fail();
        } catch(TooManyCharacters e) {
            Assert.assertEquals("Your post is too long!", e.getMessage());
        }
    }

}
