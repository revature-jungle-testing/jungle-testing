package dev.com.thejungle.dao.interfaces;

import java.util.List;

import dev.com.thejungle.entity.Post;

public interface PostInt {
    

    // Create Method
    Post createPost(Post createPost); 

    // Get/Read Method
    List<Post> getAllPosts(int UserId);
}
