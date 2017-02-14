package ru.java2017.autoshop.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.java2017.autoshop.interfaces.IBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ru.java2017.autoshop.objects.MyConstants.*;

/**
 * Created by UserBoot on 31.01.2017.
 */
public class MainWindowController implements Initializable {
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn10;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btn1.setText(b1);
        btn2.setText(b2);
        btn3.setText(b3);
        btn4.setText(b4);
        btn5.setText(b5);
        btn6.setText(b6);
        btn7.setText(b7);
        btn8.setText(b8);
        btn9.setText(b9);
        btn10.setText(b10);
    }

    public void showTakeCar(javafx.event.ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/takeCar.fxml"));
            stage.setTitle(JÜRGEN + " - " + b1);
            stage.getIcons().add(new Image("images/ico.png"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
