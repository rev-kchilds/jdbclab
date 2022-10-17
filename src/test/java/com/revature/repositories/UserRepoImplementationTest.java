package com.revature.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.User;
import com.revature.util.H2Util;

public class UserRepoImplementationTest {

    UserRepository userRepository = new UserRepoImplementation();
    
    @BeforeEach
    public void BeforeEach(){
        H2Util.generateTables();
    }

    @AfterEach
    public void AfterEach(){
        H2Util.dropAllTables();
    }

    @Test
    void testGetAllUsers() {
        //arrange
        User user1 = new User("revuser1", "pass123");
        User user2 = new User("revuser2", "pass123");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        
        for(User user : users){
            userRepository.createUser(user);
        }

        //act
        List<User> actualResult = userRepository.getAllUsers();

        assertEquals(users.size(), actualResult.size());

    }

    @Test
    void testGetOneUserGivenId() {
        //arrange
        User user1 = new User("revuser1", "pass123");
        User user2 = new User("revuser2", "pass123");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        for(User user : users){
            userRepository.createUser(user);
        }

        //act
        User actualResult = userRepository.getOneUserGivenId(2);
        user2.setId(2);

        assertEquals(user2, actualResult);
    }

    @Test
    void testCreateUser() {
        //arrange
        User user = new User("revuser123", "pass123");
        User expectedUser = new User(1,"revuser123", "pass123");


        //act
        boolean actualResult = userRepository.createUser(user);
        User actualUser = userRepository.getOneUserGivenId(1);

        //assert
        assertTrue(actualResult);
        assertEquals(expectedUser, actualUser);

    }

    @Test
    void testUpdateUser() {
        //arrange
        User user = new User("revuser1", "pass1");
        userRepository.createUser(user);
        User expectedResult = new User(1,"revuser123", "pass123");

        //act
        boolean actualResult = userRepository.updateUser(expectedResult);
        User updatedUser = userRepository.getOneUserGivenId(1);

        //assert
        assertTrue(actualResult);
        assertEquals(expectedResult, updatedUser);
    }

    @Test
    void testDeleteUserGivenId() {
        //arrange
        User user = new User("revuser123", "pass123");
        userRepository.createUser(user);

        //act
        boolean actualResult = userRepository.deleteUserGivenId(1);

        //assert
        assertTrue(actualResult);
    }
}
