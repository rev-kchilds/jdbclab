package com.revature.lab.repositories;

import java.util.List;

import com.revature.lab.models.User;

/* 
 * We want to be able to do all CRUD operations to our database utilizing jdbc so in our interface we will define all of the methods need for CRUD
 */
public interface UserRepository {
    //CREATE
    boolean createUser(User user);

    //READ
    List<User> getAllUsers();
    User getOneUserGivenId(int id);

    //UPDATE
    boolean updateUser(User user);

    //DELETE
    boolean deleteUserGivenId(int id);
}
