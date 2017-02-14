package ru.java2017.autoshop.jdbc;

import java.sql.*;

import static ru.java2017.autoshop.objects.MyConstants.LOGIN;
import static ru.java2017.autoshop.objects.MyConstants.PASSWORD;
import static ru.java2017.autoshop.objects.MyConstants.URLDB;

/**
 * Created by UserBoot on 11.02.2017.
 */
public class BaseConnect {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public BaseConnect() throws SQLException {
        setConnection(DriverManager.getConnection(URLDB, LOGIN, PASSWORD));
        setStatement(connection.createStatement());
    }

    public BaseConnect(String query) throws SQLException {
        setConnection(DriverManager.getConnection(URLDB, LOGIN, PASSWORD));
        setStatement(connection.createStatement());
        setResultSet(statement.executeQuery(query));
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
