package dev.com.thejungle;

import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.util.HibernateUtil;
import dev.com.thejungle.entity.User;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        

        //Put your date here
        User user = new User(-2222, "trying this again", "plz work", "iamdesperate@bing.com", "Testing124", "passcode", "userabout", java.sql.Date.valueOf("2017-11-15"), "image");
        UserDAO userDAO = new UserDAO();
        userDAO.createNewUser(user);

    }

    
}
