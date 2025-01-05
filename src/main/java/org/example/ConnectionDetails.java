package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {

   // public static final String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/truckmgt";
    public static final String PASSWORD="dipak12345";
    public static final String USERNAME="root";

    //ek method bana lo getConnection naam ka jo obviously Connection ka object return karta as we know
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

}
