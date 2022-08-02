package dev.com.thejungle;



import java.sql.Date;
import java.text.SimpleDateFormat;

import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.util.HibernateUtil;
import dev.com.thejungle.entity.User;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        
        Date date = new Date(1980-01-01);
        System.out.println(date); 
        //Put your date here
        User user = new User(-1, "fname", "lname", "Test123@bing.com", "Testing123", "passcode", "userabout", date, "image");
        UserDAO userDAO = new UserDAO();
        

    }

    
}
