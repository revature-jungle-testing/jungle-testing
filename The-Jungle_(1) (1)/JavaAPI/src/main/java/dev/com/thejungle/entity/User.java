package dev.com.thejungle.entity;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_table")

public class User {

    // PRIVATE VARIABLES
    @Id
    @GeneratedValue
    @Column(name = "user_id")
     private int userId;
     @Column(name = "first_name")
     private String firstName;
     @Column(name = "last_name")
     private String lastName;
     @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "passcode")
    private String passcode;
    @Column(name = "user_about")
    private String userAbout;
    @Column(name = "user_birth_date")
    private Date userBirthdate;
    @Column(name = "image_format")
    private String imageFormat;


    // CONSTRUCTORS
    public User(){}

    public User(String username, String passcode) {
        this.username = username;
        this.passcode = passcode;
    }
    public User(String firstName, String lastName, String email, String username, long userBirthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.userBirthdate = new Date(userBirthdate);
    }
    public User(int userId, String firstName, String lastName, String email, String username, long userBirthdate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.userBirthdate = new Date(userBirthdate);
    }

    public User(int userId, String firstName, String lastName, String email, String username, String passcode,
                String userAbout, long userBirthdate, String imageFormat) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.passcode = passcode;
        this.userAbout = userAbout;
        this.userBirthdate = new Date(userBirthdate);;
        this.imageFormat = imageFormat;
    }


    // TOSTRING, HASHCODE, AND EQUALS
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", passcode='" + passcode + '\'' +
                ", userAbout='" + userAbout + '\'' +
                ", userBirthdate='" + userBirthdate + '\'' +
                ", imageFormat='" + imageFormat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName,
                user.lastName) && Objects.equals(email, user.email) && Objects.equals(username, user.username) &&
                Objects.equals(passcode, user.passcode) && Objects.equals(userAbout, user.userAbout) &&
                Objects.equals(userBirthdate, user.userBirthdate) && Objects.equals(imageFormat, user.imageFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, username, passcode, userAbout, userBirthdate, imageFormat);
    }



    // GETTERS AND SETTERS
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
    }

    public Date getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(long userBirthdate) {
        this.userBirthdate = new Date(userBirthdate);
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }


}
