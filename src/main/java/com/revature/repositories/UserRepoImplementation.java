package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/* This is the class you will need to implement 
 * 
 * The database that is setup for this demo is H2 database which is an in memory database. To access this database, instead of using DriverManager.getConnection(url,username,password); we will want to use the method predefined in the ConnectionUtil class.
 * 
*/
public class UserRepoImplementation implements UserRepository{

    @Override
    public boolean createUser(User user) {
        try {
            /* Implement JDBC logic here */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {
            /* Implement JDBC logic here */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getOneUserGivenId(int id) {
        User user = null;

        try {
            /* Implement JDBC logic here */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            /* Implement JDBC logic here */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserGivenId(int id) {
        try {
            /* Implement JDBC logic here */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
