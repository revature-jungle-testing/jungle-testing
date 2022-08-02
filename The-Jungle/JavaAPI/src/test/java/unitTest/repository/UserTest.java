package unitTest.repository;

import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.interfaces.UserDAOInt;
import dev.com.thejungle.entity.User;

public class UserTest {

    public static UserDAOInt userDao;

    @BeforeClass
    public static void setup(){
        userDao = new UserDAO();

        
    }

    @Test
    public void createNewUser(){
        User createNewUser = new User(
            1993, 
            "Herman", 
            "Fluitt", 
            "jerk@hotmail.com", 
            "bestCoderNA", 
            "apasscode", 
            "He's swole", 
            java.sql.Date.valueOf("1993-01-05"), 
            ".PeeEnGee"
            );

        User result = userDao.createNewUser(createNewUser);
        Assert.assertNotNull(result);
    }

    @Test
    public void requestLogin(){
        User loginRequest = new User(
            "bestCoderNA", 
            "apasscode"
            );

        User result = userDao.requestLogin(loginRequest);
        Assert.assertNotNull(result);

    }

    @Test
    public void getUserById(){
        User result = userDao.getUserById(39);
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

    @Test(expected = NullPointerException.class)
    public void getGroupsNames(){
        HashMap<Integer, String> result = userDao.getGroupsNames(39);
        Assert.assertNotNull(result);
    }
    
    @Test(expected = NullPointerException.class)
    public void getGroups(){
        ArrayList<Integer> result = userDao.getGroups(39);
        Assert.assertNotNull(result);
    }
    


}
