package dev.com.thejungle.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.EntityManager;

import dev.com.thejungle.dao.implementations.PostPictureDAO;
import dev.com.thejungle.entity.PostPicture;
import dev.com.thejungle.utility.HibernateUtil;
import java.util.Base64;


public class main {


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        PostPictureDAO postPictureDAO = new PostPictureDAO();
        PostPicture result = postPictureDAO.getAllPictures(230);
        

        byte[] encoded = Base64.getMimeEncoder().encode(result.getPicture());

        String printStr = "data:image/jpeg;base64, ";
        String encodedStr = new String(encoded);
        String imageStr = printStr+encodedStr;

        System.out.println(imageStr);
        // System.out.println(result.getPostId());
        // postPicture.setPostId(1);
    
    }
}
