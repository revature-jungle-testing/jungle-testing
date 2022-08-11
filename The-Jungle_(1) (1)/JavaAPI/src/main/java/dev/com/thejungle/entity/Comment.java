package dev.com.thejungle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment_table")
public class Comment {
    

    // Private Fields

    @Id
    @GeneratedValue
    private int comment_id;
    private int post_id;
    private int user_id;
    private int group_id;
    private int reply_user;
    private String comment_text;
    

    // Constructors

    public Comment() {}


    // Partial
    public Comment(int post_id, int user_id, int group_id, int reply_user, String comment_text) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.group_id = group_id;
        this.reply_user = reply_user;
        this.comment_text = comment_text;
    }

    // Full Constructor
    public Comment(int comment_id, int post_id, int user_id, int group_id, int reply_user, String comment_text) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.group_id = group_id;
        this.reply_user = reply_user;
        this.comment_text = comment_text;
    }


    // Getters & Setters

    public int getComment_id() {
        return comment_id;
    }


    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }


    public int getPost_id() {
        return post_id;
    }


    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public int getGroup_id() {
        return group_id;
    }


    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }


    public int getReply_user() {
        return reply_user;
    }


    public void setReply_user(int reply_user) {
        this.reply_user = reply_user;
    }


    public String getComment_text() {
        return comment_text;
    }


    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }



    // ToString Method
    
    @Override
    public String toString() {
        return "Comment [comment_id=" + comment_id + ", comment_text=" + comment_text + ", group_id=" + group_id
                + ", post_id=" + post_id + ", reply_user=" + reply_user + ", user_id=" + user_id + "]";
    }

    

    


}
