package com.revature;

import com.revature.models.User;
import com.revature.repositories.UserRepoImplementation;
import com.revature.repositories.UserRepository;
import com.revature.util.H2Util;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        UserRepository userRepository = new UserRepoImplementation();
        H2Util.generateTables();

        User user1 = new User("revuser123", "pass123");
        
        userRepository.createUser(user1);

        System.out.println(userRepository.getAllUsers());

        H2Util.dropAllTables();

        
    }
}
