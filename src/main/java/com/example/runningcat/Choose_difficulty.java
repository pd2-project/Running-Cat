package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Choose_difficulty {
    // 這邊是要判定生成不同大小的障礙物的class，println的地方之後改成傳送給障礙物大小那邊的信號

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ImageView easyBG;
    private ImageView mediumBG;
    private ImageView hardBG;
    public void easy_mode(ActionEvent event) throws IOException {
        System.out.println("easy");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("road-easy-view.fxml")));
        Image myImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("easy1.jpg")));
        try {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            easyBG.setImage(myImage);
        } catch (Exception e) {
            System.out.println("這個在choose_difficulty時會有例外");
        }

    }

    public void medium_mode(ActionEvent event) throws IOException {
        System.out.println("medium");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("road-medium-view.fxml")));
        Image myImage = new Image(getClass().getResourceAsStream("medium1.jpg"));
        try {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            mediumBG.setImage(myImage);
        } catch (Exception e) {
            System.out.println("這個在choose_difficulty時會有例外");
        }
    }

    public void hard_mode(ActionEvent event) throws IOException {
        System.out.println("hard");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("road-hard-view.fxml")));
        Image myImage = new Image(getClass().getResourceAsStream("hard1.jpg"));
        try {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            hardBG.setImage(myImage);
        } catch (Exception e) {
            System.out.println("這個在choose_difficulty時會有例外");
        }
    }


}
