package dev.com.thejungle.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import dev.com.thejungle.dao.interfaces.PostPictureInt;
import dev.com.thejungle.entity.PostPicture;
import dev.com.thejungle.utility.HibernateUtil;

public class PostPictureDAO implements PostPictureInt{
   


    // Create
    @Override
    public PostPicture createPicture(PostPicture createPicture) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(createPicture);
        HibernateUtil.persistandcomiit(createPicture);

        return createPicture;
    }

    // Get
    @Override
    public List<PostPicture> getAllPictures() {
        HibernateUtil.beginTransaction();
        List<PostPicture> requestList = HibernateUtil.getSession().createQuery("from PostPicture", PostPicture.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }
    
}
