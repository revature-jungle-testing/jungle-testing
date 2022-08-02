package dev.com.thejungle.dao.implementations;

import dev.com.thejungle.dao.util.HibernateUtil;
import dev.com.thejungle.dao.interfaces.ChatDAOInt;
import dev.com.thejungle.entity.ChatMessage;
// import dev.com.thejungle.utility.ConnectionDB;

// import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

public class ChatDAO implements ChatDAOInt {

    /**
     * connects to database to create a new ChatMessage
     * @param chatMessage Object that contains information of the chat sent by the user
     * @return ChatMessage that was created in the database
     */
    @Override
    public ChatMessage createMessage(ChatMessage chatMessage) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(chatMessage);
        HibernateUtil.endTransaction();
        return chatMessage;

    }

    /**
     * connects to database to retrieve messages from 5 minutes ago in group chat
     * @param groupId id of group
     * @return ArrayList of ChatMessage objects from 5 minutes ago in group chat room
     * Will return empty ArrayList if no messages
     */
    @Override
    public List<ChatMessage> getMessageGroupHistory(int groupId) { // get group message history?
        HibernateUtil.beginTransaction();
        // HibernateUtil.getSession().update(groupId);
        List<ChatMessage> chatHistoryGroup = HibernateUtil.getSession().createQuery(
            "select chatId, chatDate, ChatMessage.userId, User.userName, groupId, chatContent " +
            "from ChatMessage inner join User on User.userId = ChatMessage.userId " + 
            "where chatDate > now() and groupId as :groupid order by chatId asc", 
            ChatMessage.class).setParameter("groupid", groupId).getResultList();
        HibernateUtil.endTransaction();
        return chatHistoryGroup;
    }

    /**
     * connects to database to retrieve messages from 5 minutes ago in global chat
     * @return ArrayList of ChatMessage objects from 5 minutes ago in group chat room
     * Will return empty ArrayList if no messages
     */
    @Override
    public List<ChatMessage> getMessageGlobalHistory() { // get global message history?
        HibernateUtil.beginTransaction();
        String SQLReq = "...";
        Query query = HibernateUtil.getSession().createQuery(SQLReq);
        List<ChatMessage> chatHistoryGlobal = query.getResultList();
        
        // HibernateUtil.getSession().createSQLQuery(
        //     "select chat_id, chat_date, chat_log_table.user_id, user_table.username, group_id, " +
        //     "chat_content from chat_log_table inner join user_table on user_table.user_id = chat_log_table.user_id where group_id is null", 
        //     ChatMessage.class).getResultList();
        HibernateUtil.endTransaction();
        return chatHistoryGlobal;
    }
}