package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPrepareInsertExample {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps=null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","john","abcd1234");

            ps=connection.prepareStatement("INSERT INTO ftab values(?,?,?,?)");
            ps.setInt(1,1155);
            ps.setString(2,"JOHN");
            ps.setInt(3,5000);
            ps.setInt(4,30);

            int insert =ps.executeUpdate();
            if(insert ==1){
                System.out.println("Successfully Inserted!");
            }else{
                System.err.println("Failed tp Insert Record ");
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
