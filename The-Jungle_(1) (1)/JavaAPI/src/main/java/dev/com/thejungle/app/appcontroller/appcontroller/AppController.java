package dev.com.thejungle.app.appcontroller.appcontroller;

import dev.com.thejungle.app.appcontroller.controllers.ChatController;
import dev.com.thejungle.app.appcontroller.controllers.CommentController;
import dev.com.thejungle.app.appcontroller.controllers.PostController;
import dev.com.thejungle.app.appcontroller.controllers.PostPictureController;
import dev.com.thejungle.app.appcontroller.controllers.UserController;
import io.javalin.Javalin;

public class AppController {
    private ChatController chatController;
    private UserController userController;
    private PostController postController;
    private PostPictureController postPictureController;
    private CommentController commentController;
    private Javalin app;

    public AppController(Javalin app, ChatController chatController, UserController userController, PostController postController, PostPictureController postPictureController, CommentController commentController) {
        this.chatController = chatController;
        this.userController = userController;
        this.postController = postController;
        this.postPictureController = postPictureController;
        this.commentController = commentController;
        this.app = app;
    }

    public void createChatRoutes() {
        app.ws("/chat/{id}/{userName}", chatController::connectToWebSocket);
    }

    public void createUserRoutes() {
        app.get("/user/search/{username}", userController.SearchUserByUsername);
        app.get("/user/{userId}", userController.getUserById);
        app.get("/users", userController.getAllUsers);
        app.post("/user/login", userController.loginUser);
        app.get("/user/group/{userId}", userController.getGroups);
        app.get("/user/groupNames/{userId}",userController.getGroupsNames);
        app.post("/user/registration", userController.registerUser);
    }

    public void createPostRoutes() {
        app.get("/user/post/{userId}", postController.getAllPosts);
        app.post("/post", postController.createNewPost);
    }

    public void createPostPicRoutes(){
        app.post("/post/image/{postId}", postPictureController.createNewPost);
        app.get("/post/image/{postId}",postPictureController.getPostID);
    }

    public void createCommentRoutes(){
        app.post("/comment/post", commentController.createNewComment);

        app.delete("/comment/post/{commentId}", commentController.deleteComment);

        app.get("/comment/post/{postId}", commentController.getCommentByPost);
        app.get("/comment/post/{userId}", commentController.getCommentByUser);
    }
}


