package dev.com.thejungle.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "chat_log_table")
public class ChatMessage {

    @Id
    @GeneratedValue
    @Column(name = "chat_id")
    private int chatId;
    @Column(name = "chat_date")
    private java.sql.Timestamp chatDate;
    @Column(name = "user_id")
    private int userId;
    @Transient
    private String userName;
    @Column(name = "goup_id")
    private int groupId;
    @Column(name = "chat_content")
    private String chatContent;
 
    public ChatMessage() {

    }

    public ChatMessage(int userId, int groupId, String chatContent) {
        this.setUserId(userId);
        this.setGroupId(groupId);
        this.setChatContent(chatContent);
    }

    public ChatMessage(int chatId, java.sql.Timestamp chatDate, int userId, String userName, int groupId, String chatContent) {
        this.setChatId(chatId);
        this.setChatDate(chatDate);
        this.setUserId(userId);
        this.setUserName(userName);
        this.setGroupId(groupId);
        this.setChatContent(chatContent);
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public java.sql.Timestamp getChatDate() {
        return chatDate;
    }

    public void setChatDate(java.sql.Timestamp chatDate) {
        this.chatDate = chatDate;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "chatId=" + chatId +
                ", chatDate='" + chatDate + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", groupId=" + groupId +
                ", chatContent='" + chatContent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessage that = (ChatMessage) o;
        return chatId == that.chatId && userId == that.userId && groupId == that.groupId && Objects.equals(chatDate, that.chatDate) && Objects.equals(userName, that.userName) && Objects.equals(chatContent, that.chatContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, chatDate, userId, userName, groupId, chatContent);
    }
}
