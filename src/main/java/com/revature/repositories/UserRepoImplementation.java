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
 * The database that is setup for this demo is H2 database which is an in memory database. 
*/
public class UserRepoImplementation implements UserRepository{

    @Override
    public boolean createUser(User user) {
        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "insert into users (username, password) values (?, ?);";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "select * from users;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getOneUserGivenId(int id) {
        User user = null;

        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "select * from users where id = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

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
    public boolean updateUser(User user) {
        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "update users set username = ?, password = ? where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserGivenId(int id) {
        try {
            Connection connection = ConnectionUtil.getConnection();

            String sql = "delete from users where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
