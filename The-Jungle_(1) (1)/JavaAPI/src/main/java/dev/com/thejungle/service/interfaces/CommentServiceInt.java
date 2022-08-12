package dev.com.thejungle.service.interfaces;

import java.util.List;

import dev.com.thejungle.entity.Comment;

public interface CommentServiceInt {

    // check to see if text is too long
    boolean checkCommentLength(Comment commentToCheck);

    // create method
    Comment createCommentService(Comment createComment);

    // get comments by post id
    List<Comment> getCommentsByPost(int post_id);
    
    // get comments by user id
    List<Comment> getCommentsByUser(int user_id);
}
