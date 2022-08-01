package dev.com.thejungle;



import dev.com.thejungle.dao.implementations.UserDAO;
import dev.com.thejungle.dao.util.HibernateUtil;
import dev.com.thejungle.entity.User;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        User user = new User(-1, "fname", "lname", "email", "username", "passcode", "userabout", 19840101, "image");
        UserDAO userDAO = new UserDAO();
        userDAO.createNewUser(user);

    }

    
}
