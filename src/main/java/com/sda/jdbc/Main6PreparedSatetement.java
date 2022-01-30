package com.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main6PreparedSatetement {

    public static void main(String[] args) throws SQLException {
        List<String> names = List.of("Jan", "Ala", "Mikołąj", "Kasia");
        List<String> passwords = List.of("password1", "password2", "password3", "password4");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema", "root", "Klubbingo1");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(username, password) values (?,?)");
        for (int i=0; i<= names.size(); i++) {
            preparedStatement.setString(1,names.get(i));
            preparedStatement.setString(2,passwords.get(i));
            preparedStatement.executeUpdate();

        }


        preparedStatement.close();
        connection.close();
    }
}
