package com.example.runningcat;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import static com.example.runningcat.Key_Detector.catMovable;


public class Pause_Controller {
    public static boolean pause_active = false;
    static ImageView pauseImageView;
    static ImageView start_corner_view;
    static ImageView pause_corner_view;


    public static void create_pause_image(ImageView pause_button_center, ImageView start_corner, ImageView pause_corner, Pane root) {
        pause_button_center.setFitWidth(100);
        pause_button_center.setFitHeight(100);
        pause_button_center.setLayoutX(356);
        pause_button_center.setLayoutY(250);
        pauseImageView = pause_button_center;

        start_corner.setLayoutX(700);
        start_corner.setLayoutY(500);
        start_corner.setFitHeight(70);
        start_corner.setFitWidth(80);
        start_corner_view = start_corner;

        pause_corner.setLayoutX(700);
        pause_corner.setLayoutY(500);
        pause_corner.setFitHeight(70);
        pause_corner.setFitWidth(80);
        root.getChildren().add(pause_corner);
        pause_corner_view = pause_corner;
    }

    public static void pause_key_pressed(KeyEvent event, AnimationTimer timer, Pane root) {
        if ((event.getCode() == KeyCode.P || event.getCode() == KeyCode.ESCAPE) && !pause_active) {
            pause_active = true;
            catMovable = false;
            // System.out.println(root.getChildren().contains(pauseImageView));
            root.getChildren().add(pauseImageView);
            root.getChildren().add(start_corner_view);
            root.getChildren().remove(pause_corner_view);
            timer.stop();
        } else if (event.getCode() == KeyCode.P || event.getCode() == KeyCode.ESCAPE) {
            pause_active = false;
            catMovable = true;
            // System.out.println(root.getChildren().contains(pauseImageView));
            root.getChildren().remove(pauseImageView);
            root.getChildren().remove(start_corner_view);
            root.getChildren().add(pause_corner_view);
            timer.start();
        }
    }
}
