package com.sda.jdbc;

import java.sql.*;

public class Mian5Statement {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema", "root", "Klubbingo1");
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT age FROM animal where name=?");
        preparedStatement.setString(1,"Benio");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            System.out.println("Age: " + age);

        }
       resultSet.close();
        preparedStatement.close();
        connection.close();


    }
}
