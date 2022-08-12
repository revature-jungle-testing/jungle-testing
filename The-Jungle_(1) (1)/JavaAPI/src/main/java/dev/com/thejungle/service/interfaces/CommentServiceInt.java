package dev.com.thejungle.service.interfaces;

import dev.com.thejungle.entity.Comment;

public interface CommentServiceInt {

    // check to see if text is too long
    boolean checkCommentLength(Comment commentToCheck);

    // create method
    Comment createCommentService(Comment createComment);
    
}
