package ru.java2017.autoshop.interfaces.impls;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import ru.java2017.autoshop.jdbc.BaseConnect;

import java.sql.*;
import java.util.*;

import static ru.java2017.autoshop.objects.MyConstants.LOGIN;
import static ru.java2017.autoshop.objects.MyConstants.PASSWORD;
import static ru.java2017.autoshop.objects.MyConstants.URLDB;

/**
 * Created by UserBoot on 05.02.2017.
 */
public class Zapolnitel {
    private ObservableList<ObservableList> data = FXCollections.observableArrayList();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private List<TableColumn> columnArr = new ArrayList<>();
    private int rowsCount = 0;
    private BaseConnect baseConnect;

    public Zapolnitel(String query) throws SQLException {
        baseConnect = new BaseConnect(query);
        connection = baseConnect.getConnection();
        statement = baseConnect.getStatement();
    }

    public List<TableColumn> columns() throws SQLException {
        resultSet = baseConnect.getResultSet();
        for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
            final int j = i;

            // переименование колонок
            String columnRename = resultSet.getMetaData().getColumnName(i + 1);
            switch (columnRename) {
                case "id_car":
                    columnRename = "ID";
                    break;
                case "id_car_type":
                    columnRename = "Тип";
                    break;
                case "id_model":
                    columnRename = "Модель";
                    break;
                case "id_transmission":
                    columnRename = "КПП";
                    break;
                case "id_privod":
                    columnRename = "Привод";
                    break;
                case "capasity":
                    columnRename = "Объём двигателя";
                    break;
                case "id_brand":
                    columnRename = "Бренд";
                    break;
                case "price":
                    columnRename = "Цена";
                    break;
                case "id_condition":
                    columnRename = "Состояние";
                    break;
                case "id_color":
                    columnRename = "Цвет";
                    break;
                case "issue_year":
                    columnRename = "Год выпуска";
                    break;
                case "description":
                    columnRename = "Описание";
                    break;
            }

            TableColumn col = new TableColumn(columnRename);
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty((String) param.getValue().get(j));
                }
            });
            columnArr.add(col);
        }
        return columnArr;
    }

    public ObservableList<ObservableList> rows() throws SQLException {
        resultSet = baseConnect.getResultSet();
        LargeNumbersFormat lnf = new LargeNumbersFormat();
        while (resultSet.next()) {
            rowsCount++;
            ObservableList<Object> row = FXCollections.observableArrayList();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                if (i == 8) row.add(lnf.spaceBetween(resultSet.getString(i)));
                else row.add(resultSet.getString(i));
            }
            data.add(row);
        }
        return data;
    }

    public List<Map> combing(String query2) throws SQLException {
        List<Map> list = new ArrayList<>();
        baseConnect.setResultSet(statement.executeQuery(query2));
        resultSet = baseConnect.getResultSet();
        while (resultSet.next()) {
            Map<Integer, String> comboZap = new HashMap<>();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                comboZap.put(i, resultSet.getString(i));
            }
            list.add(comboZap);
        }
        return list;
    }

    public void finalisation() throws SQLException {
        if (connection != null) {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

    public ObservableList<String> comboCircle(List<Map> forCombo) throws SQLException {
        ObservableList<String> name = FXCollections.observableArrayList();
        List<Map> list = new ArrayList<>();
        list.addAll(forCombo);
        for (int i = 0; i < list.size(); i++) {
            name.add((String) list.get(i).get(2));
        }
        return name;
    }

    public Object idFromCombo(List<Map> combo, String s) {
        Object key = 0;
        for (int i = 0; i < combo.size(); i++) {
            if (s.equals(combo.get(i).get(2))) {
                key = combo.get(i).get(1);
            }
        }
        return key;
    }

    public int getRowsCount() {
        return rowsCount;
    }
}
