package com.example.runningcat;

//import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Objects;


public class Scoreboard {

    public static double score = 0;

    public static void show_score (Pane root, Text text_score, ImageView background, String mode) {
        if (Objects.equals(mode, "easy_mode")) {
            background.setLayoutX(600);
            background.setLayoutY(30);
            background.setFitHeight(200);
            background.setFitWidth(200);
            text_score.setLayoutX(650);
            text_score.setLayoutY(160);
        } else if (Objects.equals(mode, "medium_mode")) {
            background.setLayoutX(580);
            background.setLayoutY(30);
            background.setFitHeight(200);
            background.setFitWidth(200);
            text_score.setLayoutX(630);
            text_score.setLayoutY(160);
        } else if (Objects.equals(mode, "hard_mode")) {
            background.setLayoutX(560);
            background.setLayoutY(30);
            background.setFitHeight(200);
            background.setFitWidth(200);
            text_score.setLayoutX(610);
            text_score.setLayoutY(160);
        }

        text_score.setFill(Color.BLACK);
        text_score.setStyle("-fx-font: 25 arial;");
        root.getChildren().add(background);
        root.getChildren().add(text_score);
    }
    public static void count (Text text_score) {
        text_score.setText("秒數: " + (int)score/60);
        score++;
        System.out.println(score);
    }
}