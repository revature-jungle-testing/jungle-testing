package dev.com.thejungle.service.implementations;

import java.util.List;

import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.dao.implementations.PostDAO;
import dev.com.thejungle.entity.Post;
import dev.com.thejungle.service.interfaces.PostServiceInt;

public class PostService implements PostServiceInt {

    private final PostDAO postDAO;

    public PostService (PostDAO postDAO) {
        this.postDAO = postDAO;
    }


    // checking length of post
    
        @Override
        public boolean checkTextLength(Post textToCheck) {
            if(textToCheck.getPostText().length() > 300){
                return false;
            } else {
                return true;
            }
        }

    // create post, checking for post length (max 300 characters?)

        @Override
        public Post createPostService(Post post) {
            boolean valCheck1 = checkTextLength(post);

            if(valCheck1){
                return this.postDAO.createPost(post);
            } else {
                throw new TooManyCharacters("Your post is too long!");
            }
        }

    // gets all the posts

        @Override
        public List<Post> getAllPostsService(int UserId) {
            return this.postDAO.getAllPosts(UserId);
        }

    
}
