package dev.com.thejungle.service.implementations;

import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.dao.implementations.CommentDAO;
import dev.com.thejungle.entity.Comment;
import dev.com.thejungle.service.interfaces.CommentServiceInt;

public class CommentService implements CommentServiceInt {

    private final CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO){
        this.commentDAO = commentDAO;
    }

    @Override
    public boolean checkCommentLength(Comment commentToCheck) {
        if(commentToCheck.getComment_text().length() > 100){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Comment createCommentService(Comment createComment) {
        boolean valCheck1 = checkCommentLength(createComment);

        if(valCheck1){
            return this.commentDAO.createComment(createComment);
        } else {
            throw new TooManyCharacters("Your comment is too long!");
        }
    }
    
}
