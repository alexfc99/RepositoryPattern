package org.example;

import java.sql.SQLException;

public class ArmaService {
    static java.sql.Connection connection;

    public static java.sql.Connection getConnection(){
        String host = "jdbc:sqlite:/media/alu10472056/T7/1 CFSJ/DSObjects/src/main/resources/DSObjects";
        if (connection == null) {
            try {
                connection = java.sql.DriverManager.getConnection(host);
            }catch (SQLException sql){
                System.out.println(sql.getMessage());
                System.exit(0);
            }
        }
        return connection;
    }
}
