package dev.com.thejungle.app.appcontroller.controllers;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import dev.com.thejungle.customexception.PostNotFound;
import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.entity.Post;
import dev.com.thejungle.service.implementations.PostService;
import io.javalin.http.Handler;

public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    // Get All Posts
    public Handler getAllPosts = ctx -> {
        Gson gson = new Gson();
        try {
            List<Post> posts = this.postService.getAllPostsService();
            if (posts == null) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            String usersJSONs = gson.toJson(posts);
            ctx.result(usersJSONs);
            ctx.status(200);
        } catch (PostNotFound e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // Create New Post
    public Handler createNewPost = ctx -> {
        Gson gson = new Gson();
        try {
            Post newPost = gson.fromJson(ctx.body(), Post.class);
            Post createdPost = this.postService.createPostService(newPost);
            if (createdPost == null) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            String createdPostJson = gson.toJson(createdPost);
            ctx.result(createdPostJson);
            ctx.status(201);
        } catch (TooManyCharacters e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
}
