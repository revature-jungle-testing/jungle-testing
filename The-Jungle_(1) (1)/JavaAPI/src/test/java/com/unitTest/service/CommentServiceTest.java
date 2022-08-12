package com.unitTest.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.dao.implementations.CommentDAO;
import dev.com.thejungle.entity.Comment;
import dev.com.thejungle.service.implementations.CommentService;
import dev.com.thejungle.service.interfaces.CommentServiceInt;

public class CommentServiceTest {

    // actually affecting database
        public static CommentDAO commentDAO = new CommentDAO();
        public static CommentServiceInt commentService = new CommentService(commentDAO);
        
    // mock 
        public static CommentDAO mockDao = Mockito.mock(CommentDAO.class);
        public static CommentServiceInt mockService = new CommentService(commentDAO);

    // test to create a comment positive
    @Test
    public void serviceCreateNewCommentPositive(){
        Comment createGoodComment = new Comment(
            168, 
            232, 
            "I love Minnesota too!"
        );
        Comment result = commentService.createCommentService(createGoodComment);
        Assert.assertNotNull(result);
    }

    // test to create a comment negative
    @Test
    public void serviceCreateNewCommentNegative(){
        try {
            Comment createBadComment = new Comment(
                168,
                764,
                "I also enjoyed my time in Minnesota. It was very cold and I had to trek miles in the snow when a wild moose overturned my car, but it was worth it because I got to buy a delicious apple turnover from the local supermarket. Minnesota is a really beautiful state!"
            );
            commentService.createCommentService(createBadComment);
        } catch(TooManyCharacters e) {
            Assert.assertEquals("Your comment is too long!", e.getMessage());
        }
    }
    
}
