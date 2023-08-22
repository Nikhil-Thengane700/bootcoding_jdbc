package com.bootcoding.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCOracleCallableExample1 {
    public static void main(String[] args) {
        Connection connection=null;
        CallableStatement stmt=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","john","abcd1234");
            stmt=connection.prepareCall("{call ap00point(?,?,?,?)}");
            stmt.setInt(1,1188);
            stmt.setString(2,"Manish");
            stmt.setInt(3,2700);
            stmt.setInt(4,10);
            boolean status= stmt.execute();
            System.out.println(status+"Operation Success");
            int n=0;

            if(n>0){

            }
            else if(n<0
            ){}
    } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();}
            finally{
                if(connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    }}
