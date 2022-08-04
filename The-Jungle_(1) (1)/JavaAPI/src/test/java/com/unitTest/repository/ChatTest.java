package com.unitTest.repository;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.com.thejungle.dao.implementations.ChatDAO;
import dev.com.thejungle.dao.interfaces.ChatDAOInt;
import dev.com.thejungle.entity.ChatMessage;

public class ChatTest {
    
    public static ChatDAOInt chatDao;

    @BeforeClass
    public static void setup(){
        chatDao = new ChatDAO();
        
    }

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


    // negative
    @Test
    public void createMessageNegativeIdTest(){
        ChatMessage createMessageNegative = new ChatMessage(
            99,
            999900,
            "hellow wrongg spell"
        );
        
        ChatMessage result = chatDao.createMessage(createMessageNegative);
        Assert.assertNull(result);
    }

    @Test
    public void createMessageNegativeGroupTest(){
        ChatMessage createMessage = new ChatMessage(
            10000,
            100000,
            "if it's a countable noun say 'fewer' not 'less'"
        );

        ChatMessage result = chatDao.createMessage(createMessage);
        Assert.assertNull(result);
    }

    @Test // just for fun
    public void createMessageNegativeExcessiveChatactersTest(){
        ChatMessage createMessage = new ChatMessage(
            10000,
            10000,
            "lkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsaplkjhgfdsapsa"
        );

        ChatMessage result = chatDao.createMessage(createMessage);
        Assert.assertNull(result);
    }
}
