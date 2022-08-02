package unitTest.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.PersistenceException;

import dev.com.thejungle.customexception.UnallowedSpaces;
import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.interfaces.UserDAOInt;
import dev.com.thejungle.entity.User;
import dev.com.thejungle.service.implementations.UserService;
import dev.com.thejungle.service.interfaces.UserServiceInt;

public class UserServiceTest {

    public static UserServiceInt userService;
    public static UserDAOInt userDao;

    @BeforeClass
    public static void setup(){
        userDao = new UserDAO();
        userService = new UserService(userDao);

    }
    
    //POSTIVE
    @Test
    public void serviceCreateNewUserPosi(){
        User createNewUser = new User(
            1994, 
            "Lyndon", 
            "Sully", 
            "notjerk@hotmail.com", 
            "everbetterCoderNA", 
            "apasscode", 
            "He's swole", 
            java.sql.Date.valueOf("1993-01-05"), 
            ".PeeEnGee"
            );
        User result = userService.createNewUserService(createNewUser);
        Assert.assertNotNull(result);
    }
    
    @Test
    public void serviceRequestLoginPosi(){
        User loginServiceRequest = new User(
            "bestCoderNA", 
            "apasscode"
            );
        User result = userService.loginService(loginServiceRequest);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetUserByIdPosi(){
        User result = userService.getUserByIdService(1337);
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceSearchForUserPosi(){
        ArrayList<User> result = userService.searchForUserService("bestCoderNA");
        Assert.assertNotNull(result);
    }

    @Test
    public void serviceGetAllUsersPosi(){
        List<User> result = userService.getAllUsersService();
        Assert.assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void serviceGetGroupsNamesPosi(){
        HashMap<Integer, String> result = userService.getGroupsNames(1337);
        Assert.assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void serviceGetGroupsPosi(){
        ArrayList<Integer> result = userService.getGroups(1337);
        Assert.assertNotNull(result);
    }

    //NEGATIVES
    @Test
    public void serviceCreateNewUserNeg(){
        try{
            User createNewUser = new User(
            1994, 
            "Lyndon", 
            "Sully", 
            "notjerk@hotmail.com", 
            "even better Coder NA", 
            "a passcode", 
            "He's swole", 
            java.sql.Date.valueOf("1994-01-11"), 
            ".PeeEnGee"
            );
            User result = userService.createNewUserService(createNewUser);
            Assert.fail();
        }catch(UnallowedSpaces e){
            Assert.assertEquals("No spaces allowed in username or password", e.getMessage());
        }
    }
    
    // @Test
    // public void serviceRequestLoginNeg(){
    //     User loginServiceRequest = new User(
    //         "bestCoderNA", 
    //         "apasscode"
    //         );
    //     User result = userService.loginService(loginServiceRequest);
    //     Assert.assertNotNull(result);
    // }

    // @Test
    // public void serviceGetUserByIdNeg(){
    //     User result = userService.getUserByIdService(1337);
    //     Assert.assertNotNull(result);
    // }

    // @Test
    // public void serviceSearchForUserNeg(){
    //     ArrayList<User> result = userService.searchForUserService("bestCoderNA");
    //     Assert.assertNotNull(result);
    // }

    // @Test
    // public void serviceGetAllUsersNeg(){
    //     List<User> result = userService.getAllUsersService();
    //     Assert.assertNotNull(result);
    // }

    // @Test(expected = NullPointerException.class)
    // public void serviceGetGroupsNamesNeg(){
    //     HashMap<Integer, String> result = userService.getGroupsNames(1337);
    //     Assert.assertNotNull(result);
    // }

    // @Test(expected = NullPointerException.class)
    // public void serviceGetGroupsNeg(){
    //     ArrayList<Integer> result = userService.getGroups(1337);
    //     Assert.assertNotNull(result);
    // }
    

}
