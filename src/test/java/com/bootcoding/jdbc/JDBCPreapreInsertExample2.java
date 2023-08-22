package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class JDBCPreapreInsertExample2 {
    public static void main(String[] args) {

        Connection connection=null;
        PreparedStatement ps=null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            for(int i = 101; i < 10000 ; i++) {
                connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","john","abcd1234");

                ps = connection.prepareStatement("INSERT INTO ftab values(?,?,?,?)");
                ps.setInt(1, 1200 + i);
                ps.setString(2, getName());
                ps.setInt(3, 3000 + (i));
                ps.setInt(4, 30);
                int insert = ps.executeUpdate();
                if (insert == 1) {
                    System.out.println("Successfully Inserted, id = " + (1200+i));
                } else {
                    System.err.println("Failed to Insert Record ");
                }
//            int n=statement.executeUpdate("insert into ftab values(1144,'RAJU',3000,30)");
//            System.out.println(n+" :Rows Inserted ");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static String[] names =
            {"Ramesh", "Suresh", "Jayesh", "Ganesh",
                    "Mahesh", "Rajesh", "Mitesh", "Dinesh",
                    "Pooja", "Priya", "Pinky",
                    "Manisha", "Usha", "Asha", "Diksha", "Nisha"};

    public static String getName() {
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }

}



