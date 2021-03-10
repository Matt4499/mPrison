package me.Matt4499.mPrison.implementations;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class mSQL {

    public static Connection connection;

    public static void init() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/feedback?user=sqluser&password=sqluserpw");
    }
    
}
