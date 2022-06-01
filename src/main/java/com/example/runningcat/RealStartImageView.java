package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class RealStartImageView {

    public Pane root;
    public Text[] easy_history_score = new Text[]{new Text("第一名："), new Text("第二名："), new Text("第三名："), new Text("第四名："), new Text("第五名：")};
    public Text[] medium_history_score = new Text[]{new Text("第一名："), new Text("第二名："), new Text("第三名："), new Text("第四名："), new Text("第五名：")};
    public Text[] hard_history_score = new Text[]{new Text("第一名："), new Text("第二名："), new Text("第三名："), new Text("第四名："), new Text("第五名：")};
    public static int[] easy_score_array = new int[]{0, 0, 0, 0, 0};
    public static int[] medium_score_array = new int[]{0, 0, 0, 0, 0};
    public static int[] hard_score_array = new int[]{0, 0, 0, 0, 0};
    public static int history_score = 0;
    public static String history_mode;
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

    public void show_history(ActionEvent event) throws IOException {
        // System.out.println("hhh");

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("history_score.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        show_score_and_mode(easy_history_score, history_mode, easy_score_array, "easy");
        show_score_and_mode(medium_history_score, history_mode, medium_score_array, "medium");
        show_score_and_mode(hard_history_score, history_mode, hard_score_array, "hard");

    }
    public void show_score_and_mode(Text[] arr, String history_mode, int[] int_arr, String mode) {
        int x;
        if (history_score != 0 && Objects.equals(history_mode, "easy_mode")) {
            selection_sort(easy_score_array);
        } else if (history_score != 0 && Objects.equals(history_mode, "medium_mode")) {
            selection_sort(medium_score_array);
        } else if (history_score != 0 && Objects.equals(history_mode, "hard_mode")) {
            selection_sort(hard_score_array);
        }
        for (int i = 0; i < 5; i++) {
            arr[i].setText(arr[i].getText() + (int)(double) int_arr[i]);
            if (Objects.equals(mode, "easy")) {
                x = 100;
            } else if (Objects.equals(mode, "medium")) {
                x = 350;
            } else {
                x = 600;
            }
            arr[i].setLayoutX(x);
            arr[i].setLayoutY(180 + i * 50);
            arr[i].setFill(Color.BLACK);
            arr[i].setStyle("-fx-font: 25 arial;");
            root.getChildren().add(arr[i]);
        }
    }
    public void selection_sort(int[] arr){
        int[] tmp_arr = {0, 0, 0, 0, 0};
        boolean added = false;
        for (int i = 0; i < 5; i++) {
            if (history_score >= arr[i] && !added) {
                tmp_arr[i] = history_score;
                added = true;
                RealStartImageView.history_score = 0;
            } else if (added) {
                tmp_arr[i] = arr[i - 1];
            } else {
                tmp_arr[i] = arr[i];
            }
        }
        System.arraycopy(tmp_arr, 0, arr, 0, 5);
    }
}
