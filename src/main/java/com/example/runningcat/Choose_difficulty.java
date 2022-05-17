package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Choose_difficulty {
    // 這邊是要判定生成不同大小的障礙物的class，println的地方之後改成傳送給障礙物大小那邊的信號

    private Stage stage;
    private Scene scene;
    Cones_Controller cones_controller = new Cones_Controller();

    FXMLLoader loader = new FXMLLoader(getClass().getResource("road-easy-view.fxml"));

    public SetCatPos SP = new SetCatPos();

    CatMovement catMovement = loader.getController();


    public void easy_mode(ActionEvent event) throws IOException {
        System.out.println("easy");
        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("road-easy-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        root.getChildren().add(SP.catImageView());
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

        // 生成三角錐在視窗頂部的隨機位置

        root.getChildren().add(cones_controller.Cones_Appear("easy_mode"));
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
            }
        });
    }

    public void medium_mode(ActionEvent event) throws IOException {
        System.out.println("medium");
        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("road-medium-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        root.getChildren().add(cones_controller.Cones_Appear("medium_mode"));
        root.getChildren().add(SP.catImageView());
    }

    public void hard_mode(ActionEvent event) throws IOException {
        System.out.println("hard");
        Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("road-hard-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        root.getChildren().add(cones_controller.Cones_Appear("hard_mode"));
        root.getChildren().add(SP.catImageView());
    }


}
