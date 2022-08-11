package dev.com.thejungle.service.implementations;

import java.util.List;

import dev.com.thejungle.dao.implementations.PostPictureDAO;
import dev.com.thejungle.entity.PostPicture;
import dev.com.thejungle.service.interfaces.PostPictureServiceInt;

public class PostPictureService implements PostPictureServiceInt{

    private final PostPictureDAO postPictureDAO;

    public PostPictureService (PostPictureDAO postPictureDAO){
        this.postPictureDAO = postPictureDAO;
    }
    

    // checking maximum pic size is 500 kb = 500,000 bytes

        @Override
        public boolean checkImgSize(PostPicture imageToCheck) {
            if(imageToCheck.getPicture().length() > 500000){
                return false;
            } else {
                return true;
            }
        }

    // creating picture after checking image size

        @Override
        public PostPicture createPictureService(PostPicture createPicture) {
            // TODO Auto-generated method stub
            return null;
        }

    // getting all posted pictures

        @Override
        public List<PostPicture> getAllPicturesService() {
            // TODO Auto-generated method stub
            return null;
        }
    
}
