import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

//        DbConnection.connect();
        insert("test1", "test2", "test.com", "tesssssttt");

    }


    // create database with DB Browser, all set to non-null field values and table titled 'allUsers'. wrote changes
// create new java project
// copy pasted database into project 'helloDatabase'
// create connection class
// import SQLite driver: project structure -> modules -> dependencies
// THIS ALL WORKS UP UNTIL HERE

// IT IS INPUTTING INTO THE TABLE
// here is what is happeneing. I create a table using the DB browser. I import the table into
// the project which creates a new version of the table it seems. when i want to
// open the table, i need to open the version existing in the project folder such as
// folder 'helloDatabase' which will be listed alongside SRC folder, but NOT in SRC folder
// this cannot be copied onto desktop or anything, it must be opened in DB browser from inside the project

    private static void insert(String firstName, String secondName, String email, String password){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try{
         String sql = "INSERT INTO users(firstName, secondName, email, password) VALUES(?,?,?,?)";
         ps = con.prepareStatement(sql); //requires catch. why?
         ps.setString(1, firstName);
         ps.setString(2, secondName);
         ps.setString(3, email);
         ps.setString(4, password);
         ps.execute();
         System.out.println("Data has been inserted!");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}