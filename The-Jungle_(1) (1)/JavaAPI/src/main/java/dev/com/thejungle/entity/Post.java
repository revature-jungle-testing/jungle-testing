package dev.com.thejungle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "post_table")
public class Post {
    
//Private Variables
@Id
@GeneratedValue
@Column(name = "post_id")
private int postId;
@Column(name = "user_id")
private int userId;
@Column(name= "group_id")
private int groupId;
@Column(name= "post_text")
private String postText;
@Column(name= "image_format")
private String imageFormat;
// private int likes;


// Constructors

public Post() {}


public Post(String postText, String imageFormat, int likes) {
    this.postText = postText;
    this.imageFormat = imageFormat;
    // this.likes = likes;
}


public Post(int userId, int groupId, String postText, String imageFormat, int likes) {
    this.userId = userId;
    this.groupId = groupId;
    this.postText = postText;
    this.imageFormat = imageFormat;
    // this.likes = likes;
}


public Post(int postId, int userId, int groupId, String postText, String imageFormat, int likes) {
    this.postId = postId;
    this.userId = userId;
    this.groupId = groupId;
    this.postText = postText;
    this.imageFormat = imageFormat;
//     this.likes = likes;
}

// Getters & Setters

public int getPostId() {
    return postId;
}


public void setPostId(int postId) {
    this.postId = postId;
}


public int getUserId() {
    return userId;
}


public void setUserId(int userId) {
    this.userId = userId;
}


public int getGroupId() {
    return groupId;
}


public void setGroupId(int groupId) {
    this.groupId = groupId;
}


public String getPostText() {
    return postText;
}


public void setPostText(String postText) {
    this.postText = postText;
}


public String getImageFormat() {
    return imageFormat;
}


public void setImageFormat(String imageFormat) {
    this.imageFormat = imageFormat;
}



// public int getLikes() {
//     return likes;
// }


// public void setLikes(int likes) {
//     this.likes = likes;
// }

@Override
public String toString() {
    return "Post [groupId=" + groupId + ", imageFormat=" + imageFormat + ", postId=" + postId + ", postText=" + postText
            + ", userId=" + userId + "]";
}







}
