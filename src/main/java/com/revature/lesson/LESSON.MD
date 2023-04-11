# JDBC Notes

JDBC stands for Java DataBase Connnectivity. It is utilized to connect our java code with a database. JDBC will allow us to execute SQL statements from java and retrieve the result set of that query to be utilized in java.

## JDBC classes to know
### **Connection**: Creates an active connection to a database
Example:
```java
Connection connection = DriverManager.getConnection(url,username,password);

//for this lab, we created a ConnectionUtil Singleton class so you do not have to worry about the credentials to the database.
//The connection statement will look more like this for this lab
Connection connection = ConnectionUtil.getConnection();
```

### **PreparedStatement**: An object that represents a precompiled SQL statement.
Example:
```java
String sqlStatement = "SELECT * FROM users WHERE username = ? AND password = ?"

PreparedStatement ps = connection.prepareStatement(sqlStatement);
ps.setString(1, user.getUsername());
ps.setString(2, user.getPassword());
```
In the example above, notice how we have a ? in the sql statement. This syntax allows the PreparedStatement object to insert dynamic variables into the statement. We do this with setter methods in the PreparedStatement object. What setter method we utilize is determined by what datatype we are trying to insert. 
```java
//to insert a string
ps.setString(1, "user123");

//to insert an int
ps.setInt(1, 34);
```
The first argument in these setter methods represent which question mark we are referencing in the sql statement (starts at index 1). The second argument in the setter methods represent the value we are trying to insert (this will replace the ? when we actually execute the statement)

### **NOTE**: How we execute the prepared statement is different based on what sublanguage of sql we are working with. For example if we are trying to execute a DML statement, then theres only one more method we have to call

```java
ps.executeUpdate();
```

if its a dql operation, we will call the method ps.executeQuery(); and store the value in a ResultSet object that we can loop through

```java
ResultSet rs = ps.executeQuery();
```

Retrieving all records from table songs (DQL EXAMPLE):
```java
public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {
            //retrieve active connection to db
            Connection connection = DriverManager.getConnection(url,username, password);
 
            String sql = "select * from users;";

            //create precompiled sql statement
            PreparedStatement ps = connection.prepareStatement(sql);

            //execute the statement and retrieve result set
            ResultSet rs = ps.executeQuery();

            //loop through each record and add record to user list object
            while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
```


Inserting a Record into Table users (DML EXAMPLE):
```java
public void createUser(User user) {
        try {
            //retrieve active connection to db
            Connection connection = ConnectionUtil.getConnection();

            String sql = "INSERT INTO users (username, password) values (?, ?);";

            //create precompiled sql statement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            //execute the statement to db
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```

