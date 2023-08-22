package com.bootcoding.jdbc;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCOracleSelectExample5 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<Employee> employeeList = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "john", "abcd1234");
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from ftab");
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmpno(rs.getInt(1));
                employee.setEname(rs.getString(2));
                employee.setSal(rs.getInt(3));
                employee.setDeptno(rs.getInt(4));
                employeeList.add(employee);

            }
            for (Employee employee1 : employeeList) {
                System.out.println(employee1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }}
