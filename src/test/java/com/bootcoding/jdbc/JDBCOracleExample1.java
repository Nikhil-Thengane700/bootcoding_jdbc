package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCOracleExample1 {
    public static void main(String[] args) {

        try {
            //load and register the driver
            Class.forName("oracle.jdbc.OracleDriver");

            //establish the connection
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","john","abcd1234");

            //  //create Statement object
            Statement statement = connection.createStatement();

            //execute the query
            int n=statement.executeUpdate("insert into ftab values(1144,'JOHN',6000,30)");
            System.out.println(n+" record inserted ");
            if(connection!=null){
                connection.close();
            }





        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
