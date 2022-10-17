package com.revature.repositories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

/* This is the class you will need to implement 
 * 
 * The database that is setup for this demo is H2 database which is an in memory database. To access this database, instead of using DriverManager.getConnection(url,username,password); we will want to use the method predefined in the ConnectionUtil class.
 * 
*/
public class UserRepoImplementation implements UserRepository{


    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {
            /* remove line below and implement JDBC logic here */
            throw new SQLException("method not implemented");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getOneUserGivenId(int id) {
        User user = null;

        try {
            /* remove line below and implement JDBC logic here */
            throw new SQLException("method not implemented");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean createUser(User user) {
        try {
            /* remove line below and implement JDBC logic here */
            throw new SQLException("method not implemented");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            /* remove line below and implement JDBC logic here */
            throw new SQLException("method not implemented");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserGivenId(int id) {
        try {
            /* remove line below and implement JDBC logic here */
            throw new SQLException("method not implemented");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
