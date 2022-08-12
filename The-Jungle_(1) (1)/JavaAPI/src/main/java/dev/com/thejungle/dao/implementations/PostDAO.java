package dev.com.thejungle.dao.implementations;

import java.util.List;

import dev.com.thejungle.dao.interfaces.PostInt;
import dev.com.thejungle.entity.Post;
import dev.com.thejungle.utility.HibernateUtil;

public class PostDAO implements PostInt {

// Create Post

    @Override
    public Post createPost(Post createPost) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(createPost);
        HibernateUtil.endTransaction();
        return createPost;
    }
    
// Get Post by ID

    @Override
    public List<Post> getAllPosts(int UserId) {
        HibernateUtil.beginTransaction();
        List<Post> requestList = HibernateUtil.getSession().createQuery("from Post where userId = :UserID", Post.class).setParameter("UserID", UserId).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
        
    }

    
}
