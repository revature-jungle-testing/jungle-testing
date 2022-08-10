package dev.com.thejungle.dao.interfaces;

import java.util.List;

import dev.com.thejungle.entity.Comment;

public interface CommentInt {

    // create method
    Comment createComment(Comment createComment);

    // get method
    
    List<Comment> getAllComments();
}
