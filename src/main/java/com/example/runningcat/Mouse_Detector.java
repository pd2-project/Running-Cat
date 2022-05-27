package com.example.runningcat;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import static com.example.runningcat.Key_Detector.catMovable;
import static com.example.runningcat.Pause_Controller.pause_active;

public class Mouse_Detector {
    public static void pause_click(ImageView center, ImageView start, ImageView pause,Pane root, AnimationTimer timer){
        center.setOnMouseClicked((MouseEvent e) -> {
            if (pause_active) {
                root.getChildren().remove(center);
                root.getChildren().remove(start);
                root.getChildren().add(pause);
                timer.start();
                pause_active = false;
                catMovable = true;
            }
            System.out.println("center clicked!");

        });
        start.setOnMouseClicked((MouseEvent e) -> {
            if (pause_active) {
                root.getChildren().remove(center);
                root.getChildren().remove(start);
                root.getChildren().add(pause);
                timer.start();
                pause_active = false;
                catMovable = true;
            }
            // System.out.println("center clicked!");

        });
        pause.setOnMouseClicked((MouseEvent e) -> {
            if (!pause_active) {
                root.getChildren().add(center);
                root.getChildren().add(start);
                root.getChildren().remove(pause);
                timer.stop();
                pause_active = true;
                catMovable = false;
            }
            // System.out.println("center clicked!");
        });
    }

}
