package com.unitTest.service;



import java.util.List;

import org.junit.Assert;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import dev.com.thejungle.customexception.InvalidInputException;
import dev.com.thejungle.dao.implementations.ChatDAO;
import dev.com.thejungle.entity.ChatMessage;
import dev.com.thejungle.service.interfaces.ChatServiceInt;

import dev.com.thejungle.service.implementations.ChatService;

public class ChatServiceTest {

    public static ChatDAO chatDao = new ChatDAO();
    public static ChatServiceInt chatService = new ChatService(chatDao);
    public static ChatDAO mockDao = Mockito.mock(ChatDAO.class);
    public static ChatServiceInt mockService = new ChatService(mockDao);




    //POSITIVE

    @Test
    public void serviceCreateNewChatPosi(){
        ChatMessage createMessage = new ChatMessage(
            10000,
            10000,
            "hello olleh!"
        );
        ChatMessage result = chatService.serviceCreateMessageObject(createMessage);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetChatMessagesPosi(){
        int groupId = 10000;
        List<ChatMessage> result = chatService.serviceGetMessageHistory(groupId);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetAllMessageHistoryPosi(){
        List<ChatMessage> result = chatService.serviceGetMessageHistory();
        Assert.assertNotNull(result);
    }


    //NEGATIVE

    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceCreateNewChatNegativeUserIdTest(){
        ChatMessage createMessageNegative = new ChatMessage(
            -1,
            999900,
            "hellow wrongg spell"
        );
        Mockito.when(chatService.serviceCreateMessageObject(createMessageNegative)).thenThrow(new InvalidInputException("Invalid User ID"));
        mockService.serviceCreateMessageObject(createMessageNegative);
    }
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceCreateNewChatNegativeGroupIdTest(){
        ChatMessage createMessageNegative = new ChatMessage(
            10000,
            -1,
            "hellow wrongg spell"
        );
        Mockito.when(chatService.serviceCreateMessageObject(createMessageNegative)).thenThrow(new InvalidInputException("Invalid Group ID"));
        mockService.serviceCreateMessageObject(createMessageNegative);
    }
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceCreateNewChatNegativeEmptyStringTest(){
        ChatMessage createMessageNegative = new ChatMessage(
            10000,
            10000,
            ""
        );
        Mockito.when(chatService.serviceCreateMessageObject(createMessageNegative)).thenThrow(new InvalidInputException("Invalid Chat Content"));
        mockService.serviceCreateMessageObject(createMessageNegative);
    }
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceCreateNewChatNegativeLongCharsTest(){
        ChatMessage createMessageNegative = new ChatMessage(
            10000,
            10000,
            "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec p"
        );
        Mockito.when(chatService.serviceCreateMessageObject(createMessageNegative)).thenThrow(new InvalidInputException("Long Content"));
        mockService.serviceCreateMessageObject(createMessageNegative);
    }
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceGetMessageHistoryByGroupIdNegTest(){
        int groupId = 0;
        Mockito.when(chatService.serviceGetMessageHistory(groupId)).thenThrow(new InvalidInputException("Invalid Group ID"));
        mockService.serviceGetMessageHistory(groupId);
    }





    
   



    
}
