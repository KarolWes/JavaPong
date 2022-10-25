package com.example.pong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class MainApplication extends Application {
    public static Random rand = new Random();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 650);
        Controller controller = fxmlLoader.getController();
        scene.setOnKeyPressed(controller.handleKeyPressed);
        scene.setOnKeyReleased(controller.handleKeyReleased);
        stage.setTitle("Pong!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}