package dev.com.thejungle.service.interfaces;

import java.util.List;

import dev.com.thejungle.entity.Post;

public interface PostServiceInt {
    
    // create a post
    Post createPostService(Post post);

    // get all posts
    List<Post> getAllPostsService(int UserId);

    // check length of post
    boolean checkTextLength(Post textToCheck);
}
