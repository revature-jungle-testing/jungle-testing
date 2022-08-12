package dev.com.thejungle.dao.interfaces;

import java.util.List;

import dev.com.thejungle.entity.Comment;

public interface CommentInt {

    // create method
    Comment createComment(Comment createComment);

    // delete comment
    boolean removeComment(Comment commentToBeDeleted);

    // get all comments by a post
    List<Comment> getAllCommentsByPost(int post_id);

    // get all comments by a user
    List<Comment> getAllCommentsByUser(int user_id);
}
