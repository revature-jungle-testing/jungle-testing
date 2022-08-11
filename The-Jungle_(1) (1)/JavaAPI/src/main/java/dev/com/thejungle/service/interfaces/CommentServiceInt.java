package dev.com.thejungle.service.interfaces;

import java.util.List;

import dev.com.thejungle.entity.Comment;

public interface CommentServiceInt {

    // create method
    Comment createCommentService(Comment createComment);

    // get method
    
    List<Comment> getAllCommentsService();

    
}
