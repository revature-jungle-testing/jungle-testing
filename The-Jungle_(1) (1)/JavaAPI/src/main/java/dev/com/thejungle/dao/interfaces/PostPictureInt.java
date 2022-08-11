package dev.com.thejungle.dao.interfaces;


import java.util.List;

import dev.com.thejungle.entity.PostPicture;

public interface PostPictureInt {
    

    // create method
    PostPicture createPicture(PostPicture createPicture);

    // get method

    List<PostPicture> getAllPictures();
}
