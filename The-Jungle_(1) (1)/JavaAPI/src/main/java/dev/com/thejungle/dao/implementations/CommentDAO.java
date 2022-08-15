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
    public boolean removeComment(Comment commentToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(commentToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public List<Comment> getAllCommentsByPost(int post_id) {
        HibernateUtil.beginTransaction();
        List<Comment> commentListPost = HibernateUtil.getSession().createQuery("from Comment where post_id = :PostID", Comment.class).setParameter("PostID", post_id).getResultList();
        HibernateUtil.endTransaction();
        return commentListPost;
    }

    @Override
    public List<Comment> getAllCommentsByUser(int user_id) {
        HibernateUtil.beginTransaction();
        List<Comment> commentListUser = HibernateUtil.getSession().createQuery("from Comment where user_id = :UserID", Comment.class).setParameter("UserID", user_id).getResultList();
        HibernateUtil.endTransaction();
        return commentListUser;
    }
    
}
