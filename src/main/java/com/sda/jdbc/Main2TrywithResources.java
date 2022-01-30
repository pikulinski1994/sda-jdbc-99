package com.sda.jdbc;

import java.sql.*;

public class Main2TrywithResources {

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/jdbc_schema", "root", "Klubbingo1"


                        );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * From animal");
        ) {
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.printf("id: %s, Name:%s, Age:%s\n", id, name, age);
            }
        } catch (SQLException e) {
            System.out.println("Coś poszło nie tak:" + e.getMessage());
        }


    }
}
