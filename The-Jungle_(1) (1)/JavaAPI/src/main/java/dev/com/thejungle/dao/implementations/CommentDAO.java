package dev.com.thejungle.dao.implementations;

import java.util.List;


import dev.com.thejungle.dao.interfaces.CommentInt;
import dev.com.thejungle.entity.Comment;
import dev.com.thejungle.utility.HibernateUtil;

public class CommentDAO implements CommentInt{

    @Override
    public Comment createComment(Comment createComment) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(createComment);
        HibernateUtil.endTransaction();
        return createComment;
    }

    @Override
    public List<Comment> getAllComments() {
        HibernateUtil.beginTransaction();
        List<Comment> requestList = HibernateUtil.getSession().createQuery("from Comment", Comment.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }
    
}
