package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCOracleUpdateExample3 {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","john","abcd1234");
            Statement statement = connection.createStatement();
            int n= statement.executeUpdate("update ftab set sal=5000 where deptno=10");
            System.out.println(n+ " :Rows Updated ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
