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
    private String comment_text;
    

    // Constructors

    public Comment() {}


    public Comment(int post_id, int user_id, String comment_text) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.comment_text = comment_text;
    }

    // Full Constructor
    public Comment(int comment_id, int post_id, int user_id, String comment_text) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.user_id = user_id;
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


    public String getComment_text() {
        return comment_text;
    }


    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }



    // ToString Method
    
    @Override
    public String toString() {
        return "Comment [comment_id=" + comment_id + ", comment_text=" + comment_text + ", post_id=" + post_id + ", user_id=" + user_id + "]";
    }

    

    


}
