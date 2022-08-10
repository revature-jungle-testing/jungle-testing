package com.unitTest.repository;

import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.Test;


import dev.com.thejungle.dao.implementations.ChatDAO;
import dev.com.thejungle.dao.interfaces.ChatDAOInt;
import dev.com.thejungle.entity.ChatMessage;

public class ChatTest {
    
    public static ChatDAOInt chatDao = new ChatDAO();



    // positive
    @Test
    public void createMessageTest(){
        ChatMessage createMessage = new ChatMessage(
            10000,
            10000,
            "hello olleh!"
        );

        ChatMessage result = chatDao.createMessage(createMessage);
        Assert.assertNotNull(result);
    }

    @Test
    public void getMessageHistoryGlobal(){
        ArrayList<ChatMessage> result = chatDao.getMessageHistory();
        Assert.assertNotNull(result);

    }
    
    @Test
    public void getMessageHistoryGroup(){
        ArrayList<ChatMessage> result = chatDao.getMessageHistory(10000);
        Assert.assertNotNull(result);
    }


   
}
