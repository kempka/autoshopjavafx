package ru.java2017.autoshop.jdbc;

import javax.swing.*;
import java.sql.*;

import static ru.java2017.autoshop.objects.MyConstants.*;

/**
 * Created by UserBoot on 08.02.2017.
 */
public class UpdateTable {

    public UpdateTable(String query) {
        try {
            BaseConnect baseConnect = new BaseConnect();
            Statement statement = baseConnect.getStatement();
            statement.executeUpdate(query);
            statement.close();
            if (statement.isClosed()) {
                JOptionPane.showMessageDialog(null, "Данные внесены в БД!", JÜRGEN, JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage(), JÜRGEN + " - Ашипка, ёпт!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }
}
