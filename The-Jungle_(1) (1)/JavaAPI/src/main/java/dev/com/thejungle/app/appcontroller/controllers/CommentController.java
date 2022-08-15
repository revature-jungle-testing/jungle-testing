package dev.com.thejungle.app.appcontroller.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.dao.implementations.CommentDAO;
import dev.com.thejungle.entity.Comment;
import dev.com.thejungle.service.implementations.CommentService;
import io.javalin.http.Handler;

public class CommentController {

    private CommentService commentService;
    private CommentDAO commentDAO;
    private Gson gson;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
        this.gson = new Gson();
    }
    
    // create comment
    public Handler createNewComment = ctx -> {
        Gson gson = new Gson();
        try {
            Comment newComment = gson.fromJson(ctx.body(), Comment.class);
            Comment createdComment = this.commentService.createCommentService(newComment);
            if (createdComment == null) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            String createdCommentJson = gson.toJson(createdComment);
            ctx.result(createdCommentJson);
            ctx.status(201);
        } catch (TooManyCharacters e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
    
    // delete comment
    public Handler deleteComment = ctx -> {
        String json = ctx.body();
        Comment commentToDelete = this.gson.fromJson(json, Comment.class);
        String identifier = ctx.pathParam("comment_id");
        int commentId = Integer.parseInt(identifier);
        commentToDelete.setComment_id(commentId);
        this.commentDAO.removeComment(commentToDelete);
        Map<String, String> message = new HashMap<>();
        message.put("message", "comment was deleted");
        String messageJson = this.gson.toJson(message);
        ctx.result(messageJson);
        ctx.status(200);
    };

    // get comment by post_id
    public Handler getCommentByPost = ctx -> {
        int postId = Integer.parseInt(ctx.pathParam("postId"));
        Gson gson = new Gson();
        List<Comment> comment = this.commentService.getCommentsByPost(postId);
            if(comment == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String commentJSON = gson.toJson(comment);
                ctx.result(commentJSON);
                ctx.status(200);
            }
    };

    // get comment by user_id
    public Handler getCommentByUser = ctx -> {
        int userId = Integer.parseInt(ctx.pathParam("user_id"));
        Gson gson = new Gson();
        List<Comment> comment = this.commentService.getCommentsByPost(userId);
            if(comment == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String commentJSON = gson.toJson(comment);
                ctx.result(commentJSON);
                ctx.status(200);
            }
    };

}
