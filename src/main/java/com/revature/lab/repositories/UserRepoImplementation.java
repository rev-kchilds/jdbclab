package com.revature.lab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.lab.models.User;
import com.revature.lab.util.ConnectionUtil;


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
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "SELECT * from users";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getOneUserGivenId(int id) {
        User user = null;

        try {
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "SELECT * from users WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean createUser(User user) {
        try {
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "INSERT INTO users (username,password) VALUES (?,?);";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            /* remove line below and implement JDBC logic here */
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "CHANGE ME";

            PreparedStatement ps = connection.prepareStatement(sql);

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserGivenId(int id) {
        try {
            /* remove line below and implement JDBC logic here */
            /* remove line below and implement JDBC logic here */
            Connection connection = ConnectionUtil.getConnection();

            //Write SQL logic here
            String sql = "CHANGE ME";

            PreparedStatement ps = connection.prepareStatement(sql);

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
