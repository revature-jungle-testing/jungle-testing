package dev.com.thejungle.dao.implementations;

import dev.com.thejungle.customexception.*;
import dev.com.thejungle.dao.interfaces.UserDAOInt;
import dev.com.thejungle.dao.util.HibernateUtil;
import dev.com.thejungle.entity.User;
import dev.com.thejungle.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class UserDAO implements UserDAOInt {


    /**
     * connects to database to create a new User
     * @param user Object that contains information of the user
     * @return User that was created in the database
     */
    @Override
    public User createNewUser(User user) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(user);
        HibernateUtil.endTransaction();
        return user;
    }
        
    @Override
    public User requestLogin(User user) {
        HibernateUtil.beginTransaction();
        User returnUser = (User) HibernateUtil.getSession().createQuery("FROM User where username = :username and passcode = :passcode", User.class).setParameter("username", user.getUsername()).setParameter("passcode", user.getPasscode()).uniqueResult();
        HibernateUtil.endTransaction();
        return returnUser; 

       
}

    /**
     * connects to the database to search for a user using userId
     * @param userId id of user to search by
     * @return User with its information
     */
    @Override
    public User getUserById(int userId) {
        HibernateUtil.beginTransaction();
        User user = HibernateUtil.getSession().get(User.class, userId);
        HibernateUtil.endTransaction();
        return user;
    }

    /**
     * connects to the database to search for Users using username and retrieve its results
     * @param username username to search by
     * @return ArrayList of Users matching the search result
     */
    @Override
    public ArrayList<User> searchForUser(String username) {
        HibernateUtil.beginTransaction();
        ArrayList<User> users = (ArrayList<User>) HibernateUtil.getSession().createQuery("FROM User where username like :username", User.class).setParameter("username", "%" + username + "%" ).list();
        HibernateUtil.endTransaction();
        return users;
    }

    /**
     * connects to the database to retrieve all existing Users
     * @return List of Users
     */
    @Override
    public List<User> getAllUsers() {
        HibernateUtil.beginTransaction();
        List<User> users = HibernateUtil.getSession().createQuery("FROM User", User.class).getResultList();
        HibernateUtil.endTransaction();
        return users;
    }
    @Override
    public HashMap<Integer, String> getGroupsNames(int userId) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select gmjt.group_id, gt.group_name from group_member_junction_table gmjt" +
                    " inner join group_table gt ON gmjt.group_id = gt.group_id" +
                    " where gmjt.user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            HashMap<Integer, String> groupIds = new HashMap<>();
            while(resultSet.next()){
                groupIds.put(resultSet.getInt("group_id"), resultSet.getString("group_name"));
            }
            return groupIds;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    /**
     * connects to the database to retrieve list of groups that a specific user is in
     * @param userId id of user to search by
     * @return ArrayList of Integer filled with groupIds
     */
    @Override
    public ArrayList<Integer> getGroups(int userId) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select group_id from group_member_junction_table where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Integer> groupIds = new ArrayList<>();
            if (!resultSet.isBeforeFirst()){
                throw new InvalidInputException();
            } else {
                while (resultSet.next()) {
                    groupIds.add(resultSet.getInt("group_id"));
                }
                return groupIds;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

}
