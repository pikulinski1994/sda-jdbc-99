package com.sda.jdbc;

import com.mysql.cj.xdevapi.SelectStatement;

import java.sql.*;


public class Main3Statement {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema", "root", "Klubbingo1");
        Statement updateStatement = connection.createStatement();
        int amount = updateStatement.executeUpdate("UPDATE animal SET Name= 'Jasio' Where Id=2"); // Insert, Update, Delete
        System.out.println("ilość dotkniętych krotek" + amount);
        updateStatement.close();

        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT *FROM animal"); // Select
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println("Imie: " + name);

        }
        resultSet.close();

        Statement truncateStatement = connection.createStatement();
        boolean hasResult = truncateStatement.execute("TRUNCATE TABLE animal");
        System.out.println("Wynik metody execute: " + hasResult);
        truncateStatement.close();

        connection.close();
    }


}

