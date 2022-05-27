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

    public static void create_pause_image(ImageView imageView, Pane root) {
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setLayoutX(356);
        imageView.setLayoutY(250);
        pauseImageView = imageView;
        // root.getChildren().add(imageView);
    }

    public static void pause_key_pressed(KeyEvent event, AnimationTimer timer, Pane root) {
        if ((event.getCode() == KeyCode.P || event.getCode() == KeyCode.ESCAPE) && !pause_active) {
            pause_active = true;
            catMovable = false;
            System.out.println(root.getChildren().contains(pauseImageView));
            root.getChildren().add(pauseImageView);
            timer.stop();
        } else if (event.getCode() == KeyCode.P || event.getCode() == KeyCode.ESCAPE) {
            pause_active = false;
            catMovable = true;
            System.out.println(root.getChildren().contains(pauseImageView));
            root.getChildren().remove(pauseImageView);
            timer.start();
        }
    }
}
