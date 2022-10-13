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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUserGivenId(int id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
