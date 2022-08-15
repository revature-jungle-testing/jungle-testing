package com.unitTest.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.com.thejungle.dao.implementations.CommentDAO;
import dev.com.thejungle.dao.interfaces.CommentInt;
import dev.com.thejungle.entity.Comment;

public class CommentTest {
    
    public static CommentInt commentDAO = new CommentDAO();

    // test creating a comment
    @Test
    public void createComment(){
        Comment newComment = new Comment(
            168,
            1337,
            "Oh bugger off, Australia >>>"
        );
        Comment result = commentDAO.createComment(newComment);
        Assert.assertNotNull(result);
    }

    // test deleting a comment
    @Test
    public void deleteComment(){
        Comment commentToBeDeleted = new Comment(
            168,
            774,
            "Mini soda"
        );
        commentDAO.createComment(commentToBeDeleted);
        boolean result = commentDAO.removeComment(commentToBeDeleted);
        Assert.assertTrue(result);
    }

    // test getting all comments on a post
   @Test
    public void getAllCommentsPost(){
        List<Comment> result = commentDAO.getAllCommentsByPost(168);
        Assert.assertNotNull(result);
    }

    // test getting all comments by a user
    @Test
    public void getAllCommentsUser(){
        List<Comment> result = commentDAO.getAllCommentsByUser(764);
        Assert.assertNotNull(result);
    }
}
