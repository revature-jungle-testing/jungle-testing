package com.unitTest.service;


import org.mockito.Mockito;
import org.junit.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.com.thejungle.customexception.BlankInputs;
import dev.com.thejungle.customexception.DuplicateEmail;
import dev.com.thejungle.customexception.DuplicateUsername;
import dev.com.thejungle.customexception.InvalidInputException;
import dev.com.thejungle.customexception.NoValuePasscode;
import dev.com.thejungle.customexception.TooManyCharacters;
import dev.com.thejungle.customexception.UnallowedSpaces;
import dev.com.thejungle.customexception.UserNotFound;
import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.interfaces.UserDAOInt;
import dev.com.thejungle.entity.User;
import dev.com.thejungle.service.implementations.UserService;
import dev.com.thejungle.service.interfaces.UserServiceInt;

public class UserServiceTest {

    public static UserDAO userDao = new UserDAO();
    public static UserServiceInt userService = new UserService(userDao);
    public static UserDAO mockDao = Mockito.mock(UserDAO.class);
    public static UserServiceInt mockService = new UserService(mockDao);
    

    
    //POSITIVE
    @Test   // need to mock these and the serviceCreateNewUserNeg
    public void serviceCreateNewUserPosi(){
        long date = 742892400000L;
        User createNewUser = new User(
            1993, 
            "Herman", 
            "Fluitt", 
            "jerk@hotmail.com"+Math.random()* 1000, 
            "bestCoderNA"+Math.random()* 1000, 
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
    @Test(expectedExceptions = DuplicateEmail.class)
    public void createUserDupeEmailNeg(){
            long date = 742892400000L;
            User createUserDupeEmail = new User(
            1994, 
            "Lyndon", 
            "Sully", 
            "email@email.com", 
            "evenbetterCoderNA", 
            "apasscode", 
            "He's swole", 
            date, 
            ".PeeEnGee"
            );
            Mockito.when(mockDao.createNewUser(createUserDupeEmail)).thenThrow(new DuplicateEmail("email already used"));
            mockService.createNewUserService(createUserDupeEmail);
    }
    
    @Test(expectedExceptions = DuplicateUsername.class)
    public void createUserDupeUsernameNeg(){
            long date = 742892400000L;
            User createUserDupeUsername = new User(
            1994, 
            "Lyndon", 
            "Sully", 
            "email@email.com", 
            "Austin", 
            "apasscode", 
            "He's swole", 
            date, 
            ".PeeEnGee"
            );
            Mockito.when(mockDao.createNewUser(createUserDupeUsername)).thenThrow(new DuplicateUsername("username already taken"));
            mockService.createNewUserService(createUserDupeUsername);
    }

    // need to refactor UserService for this test
    // @Test(expected = UnallowedSpaces.class)
    // public void createUserUnallowedSpacesEmailNeg(){
    //         long date = 742892400000L;
    //         User createUserUnallowedSpacesEmail = new User(
    //         1994, 
    //         "Lyndon", 
    //         "Sully", 
    //         "emai lmail@email.com", 
    //         "evenbetterCoderNAna", 
    //         "apasscode", 
    //         "He's swole", 
    //         date, 
    //         ".PeeEnGee"
    //         );
    //         Mockito.when(mockDao.createNewUser(createUserUnallowedSpacesEmail)).thenThrow(new UnallowedSpaces("no spaces in email"));
    //         mockService.createNewUserService(createUserUnallowedSpacesEmail);
    // }

    @Test(expectedExceptions = UnallowedSpaces.class)
    public void createUserUnallowedSpacesUsernameNeg(){
        long date = 742892400000L;
        User createUserUnallowedSpacesUsername = new User(
        1994, 
        "Lyndon", 
        "Sully", 
        "emailmail@email.com", 
        "evenbet terCoderNAna", 
        "apasscode", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserUnallowedSpacesUsername)).thenThrow(new UnallowedSpaces("no spaces in username"));
        mockService.createNewUserService(createUserUnallowedSpacesUsername);
    }

    @Test(expectedExceptions = UnallowedSpaces.class)
    public void createUserUnallowedSpacesPasscodeNeg(){
        long date = 742892400000L;
        User createUserUnallowedSpacesPasscode = new User(
        1994, 
        "Lyndon", 
        "Sully", 
        "emailmail@email.com", 
        "evenbetterCoderNAna", 
        "apas scode", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserUnallowedSpacesPasscode)).thenThrow(new UnallowedSpaces("no spaces in passcode"));
        mockService.createNewUserService(createUserUnallowedSpacesPasscode);
    }

    @Test(expectedExceptions = BlankInputs.class)
    public void createUserBlankInputsFNameNeg(){
        long date = 742892400000L;
        User createUserBlankInputs = new User(
        1994, 
        "", 
        "Sully", 
        "emai lmail@email.com", 
        "evenbetterCoderNAna", 
        "apasscode", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputs)).thenThrow(new BlankInputs("please enter your first name"));
        mockService.createNewUserService(createUserBlankInputs);
    }

    @Test(expectedExceptions = BlankInputs.class)
    public void createUserBlankInputsLNameNeg(){
        long date = 742892400000L;
        User createUserBlankInputsLName = new User(
        1994, 
        "Lyndon", 
        "", 
        "emai lmail@email.com", 
        "evenbetterCoderNAna", 
        "apasscode", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsLName)).thenThrow(new BlankInputs("please enter your last name"));
        mockService.createNewUserService(createUserBlankInputsLName);
    }

    @Test(expectedExceptions = BlankInputs.class)
    public void createUserBlankInputsEmailNeg(){
        long date = 742892400000L;
        User createUserBlankInputsLName = new User(
        1994, 
        "Lyndon", 
        "Sully", 
        "", 
        "evenbetterCoderNAna", 
        "apasscode", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsLName)).thenThrow(new BlankInputs("please enter an email"));
        mockService.createNewUserService(createUserBlankInputsLName);
    }

    @Test(expectedExceptions = BlankInputs.class)
    public void createUserBlankInputsUsernameNeg(){
        long date = 742892400000L;
        User createUserBlankInputsUsername = new User(
        1994, 
        "Lyndon", 
        "Sully", 
        "emailmail@email.com", 
        "", 
        "apasscode", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsUsername)).thenThrow(new BlankInputs("please enter a username"));
        mockService.createNewUserService(createUserBlankInputsUsername);
    }

    @Test(expectedExceptions = BlankInputs.class)
    public void createUserBlankInputsPasscodeNeg(){
        long date = 742892400000L;
        User createUserBlankInputsPasscode = new User(
        1994, 
        "Lyndon", 
        "Sully", 
        "emailmail@email.com", 
        "evenbetterCoderNAna", 
        "", 
        "He's swole", 
        date, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsPasscode)).thenThrow(new BlankInputs("email already used"));
        mockService.createNewUserService(createUserBlankInputsPasscode);
    }

    @Test(expectedExceptions = BlankInputs.class)
    public void createUserBlankInputsBirthdateNeg(){
        // long date = 742892400000L;
        User createUserBlankInputsBirthdate = new User(
        1994, 
        "Lyndon", 
        "Sully", 
        "emailmail@email.com", 
        "evenbetterCoderNAna", 
        "apasscode", 
        "He's swole", 
        0, 
        ".PeeEnGee"
        );
        Mockito.when(mockDao.createNewUser(createUserBlankInputsBirthdate)).thenThrow(new BlankInputs("email already used"));
        mockService.createNewUserService(createUserBlankInputsBirthdate);
    }

    @Test(expectedExceptions = TooManyCharacters.class)
    public void serviceRequestLoginExcessiveUserCharNeg(){
        String username = "Loremipsumdolorsitamet,consectetueradipiscingelixxxxxxx";
        String passcode = "apasscodeortwo";
        Mockito.when(userService.loginService(username, passcode)).thenThrow(new TooManyCharacters("username contains too many characters"));
        mockService.loginService(username, passcode);
    }

    @Test(expectedExceptions = NoValuePasscode.class)
    public void serviceRequestLoginNoValPassNeg(){
        String username = "Lorem";
        String passcode = "";
        Mockito.when(userService.loginService(username, passcode)).thenThrow(new NoValuePasscode("username contains too many characters"));
        mockService.loginService(username, passcode);
    }
    
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceGetUserByIdNeg(){
        int userId = -1337;
        Mockito.when(userService.getUserByIdService(userId)).thenThrow(new InvalidInputException("Invalid Input: UserId Must Be A Non 0 Positive"));
        mockService.getUserByIdService(userId);
    }

    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceSearchForUserEmptyNameNeg(){
        String noSuchUser = "Loremipsumdolorsitamet,consectetueradipiscingelixxxxxxx";
        Mockito.when(userService.searchForUserService(noSuchUser)).thenThrow(new InvalidInputException("Invalid Input: Empty Username"));
        mockService.searchForUserService(noSuchUser);
    }
    
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceSearchForUserExcessiveCharNeg(){
        String noSuchUser = "Loremipsumdolorsitamet,consectetueradipiscingelixxxxxxx";
        Mockito.when(userService.searchForUserService(noSuchUser)).thenThrow(new InvalidInputException("Invalid Input: UserName Exceeds 50 Characters"));
        mockService.searchForUserService(noSuchUser);
    }

    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceGetGroupsNamesLeetNeg(){
        int userId = -1337;
        Mockito.when(userService.getGroupsNames(userId)).thenThrow(new InvalidInputException("User Id needs to be between 0-1000000"));
        mockService.getGroupsNames(userId);
    }

    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceGetGroupsLeetNeg(){
        Mockito.when(userService.getGroups(-1337)).thenThrow(new InvalidInputException("User Id needs to be between 0-1000000"));
        mockService.getGroups(-1337);
    }
    
    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceGetGroupsMaxNeg(){
        Mockito.when(userService.getGroups(2000000)).thenThrow(new InvalidInputException("User Id needs to be between 0-1000000"));
        mockService.getGroups(2000000);
    }

    @Test(expectedExceptions = InvalidInputException.class)
    public void serviceGetGroupsNotFoundNeg(){
        Mockito.when(userService.getGroups(0)).thenThrow(new InvalidInputException("User not found"));
        mockService.getGroups(0);
    }
}
