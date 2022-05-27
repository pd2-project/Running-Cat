package com.example.runningcat;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


public class Pause_Controller {
    public static boolean pause_active = false;

    public static void create_pause_image (ImageView imageView, Pane root) {
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setLayoutX(400);
        imageView.setLayoutY(300);
        // root.getChildren().add(imageView);
    }
    public static void pause_key_detect(KeyEvent event, AnimationTimer timer, ImageView imageView, Pane root) {
        if ((event.getCode() == KeyCode.P || event.getCode() == KeyCode.ESCAPE)) {
            //pause_active = true;
            System.out.println(root.getChildren().contains(imageView));
            root.getChildren().add(imageView);
            timer.stop();
        }
        if ((event.getCode() == KeyCode.P || event.getCode() == KeyCode.ESCAPE) && root.getChildren().contains(imageView)) {
            //pause_active = false;
            root.getChildren().remove(imageView);
            //timer.start();
        }
    }
}
