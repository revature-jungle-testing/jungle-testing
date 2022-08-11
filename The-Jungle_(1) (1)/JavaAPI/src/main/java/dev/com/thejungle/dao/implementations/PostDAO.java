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

// Get Post

    @Override
    public List<Post> getAllPosts() {
        HibernateUtil.beginTransaction();
        List<Post> requestList = HibernateUtil.getSession().createQuery("from Post", Post.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
        
    }
    
}
