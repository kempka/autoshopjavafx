package ru.java2017.autoshop.start;

/**
 * Created by UserBoot on 01.02.2017.
 */

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Duration;

import static ru.java2017.autoshop.objects.MyConstants.JÜRGEN;

public class Main extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        try {
            // Запускаем заставку
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/first.fxml"));
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT); // без обрамления
            stage.show();

            // заставка запустится на 3 секунды
            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(event -> {
                stage.close();
                showMainStage();
            });
            delay.play();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void showMainStage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.setTitle(JÜRGEN + " - Автомобильный магазин");
            stage.getIcons().add(new Image("images/ico.png"));

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}