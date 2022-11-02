# Background

## There is a database that is already setup and connected with a table called "songs".

### **songs table**
id          |name          | artist	       	    
:-----------|--------------|--------
**1**       | Let it be    | Beatles           
**2**       | Imagine      | Beatles     

## In this lesson, we will learn how to utilize JDBC to execute SQL statements to our database from Java.

# Objective
## Complete the following methods within the SongRepository class with jdbc logic to manipulate the songs table in our database.
### Note: The SongRepository class is under the lesson/repositories package
```java
public class SongRepository {
    
    public void createSong(Song song){
        //implement JDBC logic here
    }

    public List<Song> getAllSongs(){
        //implement JDBC logic here
        return null;
    }
    
}
```


# Lesson

### JDBC stands for Java DataBase Connnectivity. It is utilized to connect our java code with a database. JDBC will allow us to execute SQL statements from java and retrieve the result set of that query to be utilized in java.

### There is 4 pieces of information that's required to connect to a database with jdbc:
- db driver
- db connection string
- db username
- db password
### This information has been given to you for the sake of this demo and is configured in the ConnectionUtil.java class under the lesson package.

## Implementing the create song method
1. before we are able to execute an sql statement we need to create an active connection to the database

```java
Connection connection = DriverManager.getConnection(url,username,password);

//for this lab, we created a ConnectionUtil Singleton class so you do not have to worry about the credentials to the database.
//The connection statement will look more like this for this lab
Connection connection = ConnectionUtil.getConnection();
```