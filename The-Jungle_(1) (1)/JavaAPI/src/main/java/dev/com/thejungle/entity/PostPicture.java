package dev.com.thejungle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Base64;


@Entity
@Table(name= "post_picture_table")
public class PostPicture {

    
    // private fields

@Id
@GeneratedValue
@Column(name = "picture_id")
private int pictureId;
@Column(name = "post_id")
private int postId;
@Column(name = "picture", columnDefinition = "BLOB")
private byte [] picture;



    // Constructors

    public PostPicture() {}



    // Getters & Setters

    public PostPicture(int postId, byte[] picture) {
        this.postId = postId;
        this.picture = picture;
    }

    public PostPicture(String newer) {
        byte[] newest = Base64.getMimeDecoder().decode(newer);
        this.picture = newest;
    }



    public PostPicture(int pictureId, int postId, byte[] picture) {
        this.pictureId = pictureId;
        this.postId = postId;
        this.picture = picture;
    }



    public int getPictureId() {
        return pictureId;
    }



    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }



    public int getPostId() {
        return postId;
    }



    public void setPostId(int postId) {
        this.postId = postId;
    }



    public byte[] getPicture() {
        return picture;
    }



    public void setPicture(byte[] picture) {
        this.picture = picture;
    }



        // ToString

    @Override
    public String toString() {
        return "PostPicture [picture=" + picture + ", pictureId=" + pictureId + ", postId=" + postId + "]";
    }
    
    




    

}
