package dev.com.thejungle.service.interfaces;

import java.util.List;

import dev.com.thejungle.entity.PostPicture;

public interface PostPictureServiceInt {
    
    // check to see image is too big
    boolean checkImgSize(PostPicture imageToCheck);

    // create method
    PostPicture createPictureService(PostPicture createPicture);



    PostPicture getAllPicturesService(int postID);
    
}
