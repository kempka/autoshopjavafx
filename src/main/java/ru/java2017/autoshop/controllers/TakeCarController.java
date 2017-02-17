package ru.java2017.autoshop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.java2017.autoshop.interfaces.impls.CompleteTheTable;
import ru.java2017.autoshop.jdbc.UpdateTable;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.java2017.autoshop.objects.MyConstants.JÜRGEN;
import static ru.java2017.autoshop.objects.MyRequests.query_All_Car;
import static ru.java2017.autoshop.objects.MyRequests.query_Join1_Car;

/**
 * Created by UserBoot on 30.01.2017.
 */
public class TakeCarController {

    @FXML
    private Label labelTakeCar;
    @FXML
    private Label labelCar;
    @FXML
    private ComboBox comboMarkAuto;
    @FXML
    private Label labelTypeCar;
    @FXML
    private ComboBox comboTypeCar;
    @FXML
    private Label labelModelCar;
    @FXML
    private ComboBox comboModelCar;
    @FXML
    private Label labelColorCar;
    @FXML
    private ComboBox comboColorCar;
    @FXML
    private Label labelKPP;
    @FXML
    private ComboBox comboCPP;
    @FXML
    private Label labelConditCar;
    @FXML
    private ComboBox comboConditCar;
    @FXML
    private Label labelDriveCar;
    @FXML
    private ComboBox comboDriveCar;
    @FXML
    private Label labelVCar;
    @FXML
    private TextField textVCar;
    @FXML
    private Button buttonTakeCar;
    @FXML
    private Button buttonReviewTable;
    @FXML
    private Label labelCount;
    @FXML
    private Label labelNumber;
    @FXML
    private TableView tableTakeCar;
    @FXML
    private Button buttonExit;
    @FXML
    private TextField textDescript;
    @FXML
    private TextField textYear;
    @FXML
    private TextField textPrice;

    private ObservableList<ObservableList> data = FXCollections.observableArrayList();
    private List<TableColumn> columnArrayList = new ArrayList<>();
    private String query = query_Join1_Car;
    private CompleteTheTable completeTheTable = new CompleteTheTable(query);

    private List<Map> combMA = new ArrayList<>();
    private List<Map> combTC = new ArrayList<>();
    private List<Map> combMC = new ArrayList<>();
    private List<Map> combCC = new ArrayList<>();
    private List<Map> combCP = new ArrayList<>();
    private List<Map> combCoC = new ArrayList<>();
    private List<Map> combDC = new ArrayList<>();

    public TakeCarController() throws SQLException {
    }

    @FXML
    public void initialize() throws SQLException {

        System.out.println(query_Join1_Car);
        // вывод колонок
        getColumns();

        // вывод значений ячеек
        data.addAll(completeTheTable.rows());
        tableTakeCar.setItems(data);

        labelCount.setText(labelCount.getText());
        labelNumber.setText(String.valueOf((data.size())));

        combMA.addAll(completeTheTable.combing("SELECT id, name_en FROM spr_brand"));
        comboMarkAuto.setItems(completeTheTable.comboCircle(combMA));
        comboMarkAuto.getSelectionModel().select("UAZ");

        combTC.addAll(completeTheTable.combing("SELECT id, name_ru FROM spr_cartype"));
        comboTypeCar.setItems(completeTheTable.comboCircle(combTC));
        comboTypeCar.getSelectionModel().select(2);

        combMC.addAll(completeTheTable.combing("SELECT id, name_ru FROM spr_model"));
        comboModelCar.setItems(completeTheTable.comboCircle(combMC));
        comboModelCar.getSelectionModel().select(11);

        combCC.addAll(completeTheTable.combing("SELECT id, name_ru FROM spr_color"));
        comboColorCar.setItems(completeTheTable.comboCircle(combCC));

        combCP.addAll(completeTheTable.combing("SELECT id, name_ru FROM spr_transmission"));
        comboCPP.setItems(completeTheTable.comboCircle(combCP));
        comboCPP.getSelectionModel().select(0);

        combCoC.addAll(completeTheTable.combing("SELECT id, name_ru FROM spr_condition"));
        comboConditCar.setItems(completeTheTable.comboCircle(combCoC));
        comboConditCar.getSelectionModel().select(0);

        combDC.addAll(completeTheTable.combing("SELECT id, name_ru FROM spr_privod"));
        comboDriveCar.setItems(completeTheTable.comboCircle(combDC));

        completeTheTable.finalisation();
    }

    @FXML
    public void onClickMethod() {
        try {
            String s = comboMarkAuto.getSelectionModel().getSelectedItem().toString();
            int id_mark = Integer.valueOf((String) completeTheTable.idFromCombo(combMA, s));
            s = comboTypeCar.getSelectionModel().getSelectedItem().toString();
            int id_type = Integer.valueOf((String) completeTheTable.idFromCombo(combTC, s));
            s = comboModelCar.getSelectionModel().getSelectedItem().toString();
            int id_model = Integer.valueOf((String) completeTheTable.idFromCombo(combMC, s));
            s = comboColorCar.getSelectionModel().getSelectedItem().toString();
            int id_color = Integer.valueOf((String) completeTheTable.idFromCombo(combCC, s));
            s = comboCPP.getSelectionModel().getSelectedItem().toString();
            int id_cpp = Integer.valueOf((String) completeTheTable.idFromCombo(combCP, s));
            s = comboConditCar.getSelectionModel().getSelectedItem().toString();
            int id_cond = Integer.valueOf((String) completeTheTable.idFromCombo(combCoC, s));
            s = comboDriveCar.getSelectionModel().getSelectedItem().toString();
            int id_drive = Integer.valueOf((String) completeTheTable.idFromCombo(combDC, s));

            double capacity = Double.parseDouble(textVCar.getText());
            String description = textDescript.getText();
            int year = Integer.parseInt(textYear.getText());
            int price = Integer.parseInt(textPrice.getText());

            if (capacity < 1 || capacity > 4) {
                JOptionPane.showMessageDialog(null, "Ошибка:\nВ поле\"Объем двигателя\"\nвведено не корректное значение!\n", JÜRGEN + " - Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
            if (year < 1990 || year > 2020)
                JOptionPane.showMessageDialog(null, "Ошибка:\nВ поле\"Год выпуска\"\nвведено не корректное значение!\n", JÜRGEN + " - Ошибка!", JOptionPane.ERROR_MESSAGE);
            if (price < 10000)
                JOptionPane.showMessageDialog(null, "Ошибка:\nВ поле\"Год выпуска\"\nвведено не корректное значение!\n", JÜRGEN + " - Ошибка!", JOptionPane.ERROR_MESSAGE);
            else {
                String query = "INSERT INTO `autoshop`.`car` " +
                        "(`id_car_type`, `id_model`, `id_transmission`, `id_privod`, `capasity`, `id_brand`, `price`, `id_condition`, `id_color`, `issue_year`, `description`) " +
                        "VALUES ('" + id_type + "', '" + id_model + "', '" + id_cpp + "', '" + id_drive + "', '" + capacity + "', '" + id_mark + "', '" + price + "', '" + id_cond + "', '" + id_color + "', '" + year + "', '" + description + "');";

                new UpdateTable(query);
            }
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Ошибка:\nОдно из значений - не указано!\n" + npe.getMessage(), JÜRGEN + " - Ошибка!", JOptionPane.ERROR_MESSAGE);
            npe.printStackTrace();
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Ошибка:\nВведено не корректное значение\n" + nfe.getMessage(), JÜRGEN + " - Ошибка!", JOptionPane.ERROR_MESSAGE);
            nfe.printStackTrace();
        }
    }

    public void clickReview(ActionEvent actionEvent) throws SQLException {
        CompleteTheTable zap2 = new CompleteTheTable(query);
        data.removeAll(data);
        data.addAll(zap2.rows());
        tableTakeCar.refresh();
        int ds = data.size();
        labelNumber.setText(String.valueOf((data.size())));
    }

    public void clickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }

    public void getColumns() throws SQLException {

        // вывод названий колонок
        columnArrayList.addAll(completeTheTable.columns());
        for (TableColumn list : columnArrayList) {
            tableTakeCar.getColumns().add(list);
        }
    }
}