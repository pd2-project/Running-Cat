package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;




public class Choose_difficulty {
    // 這邊是要判定生成不同大小的障礙物的class，println的地方之後改成傳送給障礙物大小那邊的信號

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void easy_mode(ActionEvent event) throws IOException {
        System.out.println("easy");
        Parent root = FXMLLoader.load(getClass().getResource("road-easy-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void medium_mode(ActionEvent event) throws IOException {
        System.out.println("medium");
        Parent root = FXMLLoader.load(getClass().getResource("road-medium-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void hard_mode(ActionEvent event) throws IOException {
        System.out.println("hard");
        Parent root = FXMLLoader.load(getClass().getResource("road-hard-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
