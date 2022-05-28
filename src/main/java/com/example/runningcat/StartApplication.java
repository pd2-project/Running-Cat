package com.example.runningcat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("real-start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Running Cat 進擊的貓娘!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println("start");
    }

    public static void main(String[] args) {
        launch();
    }
}