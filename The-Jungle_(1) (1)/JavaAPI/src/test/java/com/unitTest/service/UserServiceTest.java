package com.unitTest.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.com.thejungle.customexception.InvalidInputException;
import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.customexception.UnallowedSpaces;
import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.interfaces.UserDAOInt;
import dev.com.thejungle.entity.User;
import dev.com.thejungle.service.implementations.UserService;
import dev.com.thejungle.service.interfaces.UserServiceInt;

public class UserServiceTest {

    public static UserDAO userDao;
    public static UserServiceInt userService;
    public static UserDAO mockDao;
    public static UserServiceInt mockService;
    

    @BeforeClass
    public static void setup(){
        userDao = new UserDAO();
        userService = new UserService(userDao);
        mockDao = Mockito.mock(UserDAO.class);
        mockService = new UserService(mockDao);
    }
    
    //POSITIVE
    @Test   // need to mock these and the serviceCreateNewUserNeg
    public void serviceCreateNewUserPosi(){
        long date = 742892400000L;
        User createNewUser = new User(
            1993, 
            "Herman", 
            "Fluitt", 
            "jerk@hotmail.com", 
            "bestCoderNA", 
            "apasscode", 
            "He's swole", 
            date, 
            ".PeeEnGee"
            );
        User result = userService.createNewUserService(createNewUser);
        Assert.assertNotNull(result);
    }
    
    @Test
    public void serviceRequestLoginPosi(){
        String username = "ApeEscape";
        String passcode = "banana";
        User result = userService.loginService(username, passcode);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetUserByIdPosi(){
        User result = userService.getUserByIdService(1337);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceSearchForUserPosi(){
        ArrayList<User> result = userService.searchForUserService("ApeEscape");
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetAllUsersPosi(){
        List<User> result = userService.getAllUsersService();
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetGroupsNamesPosi(){
        HashMap<Integer, String> result = userService.getGroupsNames(10000);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetGroupsPosi(){
        ArrayList<Integer> result = userService.getGroups(10000);
        Assert.assertNotNull(result);
    }

    //NEGATIVES
    @Test
    public void createUserDupeEmailNeg(){
        try{
            long date = 742892400000L;
            User createUserDupeEmail = new User(
            1994, 
            "Lyndon", 
            "Sully", 
            "email@email.com", 
            "even better Coder NA", 
            "a passcode", 
            "He's swole", 
            date, 
            ".PeeEnGee"
            );
            User result = userService.createNewUserService(createUserDupeEmail);
            Assert.fail();
        }catch(UnallowedSpaces e){
            Assert.assertEquals("No spaces allowed in username or password", e.getMessage());
        }
    }
    
    @Test
    public void serviceRequestLoginNeg(){
        try{
            String username = "Lorem ipsum dolor sit amet, consectetuer adipiscing eli";
            String passcode = "apasscodeortwo";
            User result = userService.loginService(username, passcode);
            Assert.fail();
        }catch(TooManyCharacters e){
            Assert.assertEquals("You are exceeding your character limit", e.getMessage());
        }
        
    }

    @Test
    public void serviceGetUserByIdNeg(){
        try{
            User result = userService.getUserByIdService(-1337);
            Assert.fail();
        }catch(InvalidInputException e){
            Assert.assertEquals("Invalid Input: UserId Must Be A Non 0 Positive", e.getMessage());
        }
    }

    @Test
    public void serviceSearchForUserNeg(){
        try{
            ArrayList<User> result = userService.searchForUserService("Lorem ipsum dolor sit amet, consectetuer adipiscing eli");
            Assert.fail();
        }catch(InvalidInputException e){
            Assert.assertEquals("Invalid Input: UserName Exceeds 50 Characters", e.getMessage());
        }
    }

    @Test
    public void serviceGetGroupsNamesNeg(){
        try{
            HashMap<Integer, String> result = userService.getGroupsNames(-1337);
            Assert.fail();
        }catch(InvalidInputException e){
            Assert.assertEquals("User Id needs to be positive", e.getMessage());

        }
    }

    @Test
    public void serviceGetGroupsNeg(){
        try{
            ArrayList<Integer> result = userService.getGroups(2000000);

        }catch(InvalidInputException e){
            Assert.assertEquals("User Id needs to be positive and in range", e.getMessage());
        }
    }
    

}
