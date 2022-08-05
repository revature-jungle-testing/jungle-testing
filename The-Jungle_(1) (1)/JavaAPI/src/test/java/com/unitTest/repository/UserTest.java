package com.unitTest.repository;

import org.junit.Assert;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.interfaces.UserDAOInt;
import dev.com.thejungle.entity.User;

import dev.com.thejungle.customexception.InvalidInputException;


public class UserTest {

    public static UserDAOInt userDao = new UserDAO();

 

    @Test
    public void createNewUser(){
        
        long date = 742892400000L;
        User createNewUser = new User(
            558, 
            "Herman", 
            "Fluitt", 
            "thejerkstorecall23ed@hotmail.com"+ Math.random()* 1000, 
            "bestCoderbaNAnananananaa"+ Math.random()* 1000, 
            "apasscode", 
            "He's swole", 
            date,
            ".PeeEnGee"
            );
        User result = userDao.createNewUser(createNewUser);
        Assert.assertNotNull(result);
    }

    @Test
    public void requestLogin(){
        String username = "username";
        String passcode = "passcode";

        User result = userDao.requestLogin(username, passcode);
        Assert.assertNotNull(result);
    }

    @Test
    public void getUserById(){
        User result = userDao.getUserById(1337);
        Assert.assertNotNull(result);
    }

    @Test
    public void searchForUser(){
        ArrayList<User> result = userDao.searchForUser("bestCoderNA");
        Assert.assertNotNull(result);
    }

    @Test
    public void getAllUsers(){
        List<User> result = userDao.getAllUsers();
        Assert.assertNotNull(result);
    }

    @Test
    public void getGroupsNames(){
        HashMap<Integer, String> result = userDao.getGroupsNames(10000);
        Assert.assertNotNull(result);
    }
    
    @Test
    public void getGroups(){
        ArrayList<Integer> result = userDao.getGroups(10000);
        Assert.assertNotNull(result);
    }

    
}
