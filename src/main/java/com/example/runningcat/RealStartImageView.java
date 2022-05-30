package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class RealStartImageView {

    public Pane root;
    private Stage stage;
    private Scene scene;
    public static ImageView go_back_button;

    public void game_start(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-character.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        go_back_button = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/go_back.png")));
        go_back_button.setFitWidth(50);
        go_back_button.setFitHeight(60);
        go_back_button.setLayoutX(20);
        go_back_button.setLayoutY(20);
        go_back_button.setOnMouseClicked((MouseEvent e) -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("real-start-view.fxml")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        });
        root.getChildren().add(go_back_button);
    }

    public void game_rules(ActionEvent event) throws IOException {
        String WORDS =
                """
                        遊戲規則如下：
                        
                        - 使用左右方向鍵或者A/D來控制貓咪左右移動
                        
                        - 中途可以用esc按鍵或P鍵來暫停
                        
                        - 共有三種難度可以選擇，貓咪會隨時間越跑越快
                        
                        - 碰到三角錐你就等著被安妮亞嘲諷^^
                                                            """;
        Label label = new Label(WORDS);
        HBox hbox = new HBox();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-rules.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        label.setWrapText(true);
        label.setFont(new Font("Arial", 26));
        label.setPrefWidth(900);
        label.setPrefHeight(600);
        hbox.setSpacing(10);
        hbox.setLayoutX(40);
        hbox.setLayoutY(-100);
        hbox.getChildren().add((label));
        root.getChildren().add(hbox);
        stage.show();



    }

    public void game_rules_go_back(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("real-start-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
