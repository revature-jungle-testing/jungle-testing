package dev.com.thejungle.service.implementations;

import java.util.Base64;
import java.util.List;

import dev.com.thejungle.dao.implementations.PostPictureDAO;
import dev.com.thejungle.entity.PostPicture;
import dev.com.thejungle.service.interfaces.PostPictureServiceInt;

public class PostPictureService implements PostPictureServiceInt{

    private final PostPictureDAO postPictureDAO;

    public PostPictureService (PostPictureDAO postPictureDAO){
        this.postPictureDAO = postPictureDAO;
    }
    



       
    // creating picture after checking image size

        @Override
        public PostPicture createPictureService(PostPicture createPicture) {
            // TODO Auto-generated method stub
            return postPictureDAO.createPicture(createPicture);
        }

    // getting all posted pictures

        @Override
        public PostPicture getAllPicturesService(int postID) {
            // TODO Auto-generated method stub
            return postPictureDAO.getAllPictures(postID);
        }


        @Override
        public boolean checkImgSize(PostPicture imageToCheck) {
            // TODO Auto-generated method stub
            byte[] encoded = Base64.getMimeEncoder().encode(imageToCheck.getPicture());

            String printStr = "data:image/jpeg;base64, ";
            String encodedStr = new String(encoded);
            String imageStr = printStr+encodedStr;
            if(imageStr.length() > 1E6){
                return false;
            }else{
                return true;
            }
            
        }
    
}
