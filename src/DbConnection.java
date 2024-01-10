import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // connection class represents a connection to a data source in java database connectivity (JDBC)

    // JDBC is the java API that manages connecting to a database, issuing queries and commands and
    // handling result sets obtained from the database. Contains interfaces and classes

    //JDBC driver implements the JDBC interfaces and classes for a particular DBMS vendor

    // jAR file is a file formate (Java ARchive). must add sqlite JAR

    // error occuring with org.sqlite.JDBC.... same code from identical project except new DB
    // no overlap of project/DB so why same code not connecting?


    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // the 'org.' part is the registered name of the JDBC driver
            // .forName returns class object for given string name
            // this is not actually assigned to a pointer though, so it return an object but doesn't do anything with it?
            con = DriverManager.getConnection("jdbc:sqlite:HelloDatabase2.db"); // sets connection to the copied DB I titled
            System.out.println("connected!");
        } catch (ClassNotFoundException | SQLException e) { // | SQLException needed for DriverManager.getConnection error. why?
            // class not found exception would occur if say i mistyped org.sqlite.JDBC such that it couldn't find a class associated
            // with the typo. would throw exception and state the type.
            //SQLException relates to database access errors
            System.out.printf(e + "");
        }

        return con;
    }

}