package dev.com.thejungle.app.appcontroller.controllers;

import java.util.HashMap;

import com.google.gson.Gson;

import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.entity.PostPicture;
import dev.com.thejungle.service.implementations.PostPictureService;
import io.javalin.http.Handler;
import java.util.Base64;


public class PostPictureController {

    private PostPictureService postPictureService;

    public PostPictureController(PostPictureService postPictureService) {
        this.postPictureService = postPictureService;
    }

    public Handler createNewPost = ctx -> {
        Gson gson = new Gson();
        int postId = Integer.parseInt(ctx.pathParam("postId"));
        try {
            PostPicture newPost = new PostPicture();
            newPost.setPicture(Base64.getMimeDecoder().decode(ctx.body()));
            newPost.setPostId(postId);
            PostPicture createdPost = this.postPictureService.createPictureService(newPost);
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
    //////
    public Handler getPostID = ctx -> {
        int postId = Integer.parseInt(ctx.pathParam("postId"));

            PostPicture result = postPictureService.getAllPicturesService(postId);
            byte[] encoded = Base64.getMimeEncoder().encode(result.getPicture());

            String printStr = "data:image/jpeg;base64, ";
            String encodedStr = new String(encoded);
            String imageStr = printStr+encodedStr;
            
            ctx.result(imageStr);
            ctx.status(200);
            
    };

    
}
