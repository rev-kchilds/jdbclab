# JDBC Lab

## Scenario
We only have one table in our database called "users". We would like to do CRUD operations on this table from Java. The structure of the project has already been made. The methods that you will need to implement for this lab are inside of UserRepoImplementation.java.
```java
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
```

## Objective
Implement all of the methods in the UserRepoImplementation.java class utilizing JDBC so that all of the prewritten tests pass.


### Please refer to the JDBC_NOTES.MD file if you need more assistance on how to use JDBC