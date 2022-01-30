package com.sda.jdbc;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4Statement {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema", "root", "Klubbingo1");
        Statement statement = connection.createStatement();

        statement.execute("Create TABLE if not exists user(id BIGINT NOT NULL AUTO_INCREMENT, "
                + "username VARCHAR(50) UNIQUE,"
                + "password VARCHAR(50), PRIMARY KEY (id))");
        statement.close();

        Statement insertStatement = connection.createStatement();
        insertStatement.executeUpdate("Insert Into user(username, password) Values ('Jan', 'password1");





        connection.close();


    }
}
