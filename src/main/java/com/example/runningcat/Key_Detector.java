package com.example.runningcat;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

import static com.example.runningcat.Choose_difficulty.*;

public class Key_Detector {

    public static boolean catMovable = true;
    public static int angle = 0;
    public static int easyLayoutXLeftSide = 190;
    public static int easyLayoutXRightSide = 570;
    public static int mediumLayoutXLefttSide = 250;
    public static int mediumLayoutXRighttSide = 510;
    public static int hardLayoutXlefttSide = 282;
    public static int hardLayoutXRighttSide = 475;
    public static int leftSideComparingInt;
    public static int rightSideComparingInt;

    public static void KeyDetection(Scene scene, ImageView catImageView, String mode) {

        if(Objects.equals(mode, "easy_mode")){
            leftSideComparingInt = easyLayoutXLeftSide;
            rightSideComparingInt = easyLayoutXRightSide;
        } else if (Objects.equals(mode, "medium_mode")) {
            leftSideComparingInt = mediumLayoutXLefttSide;
            rightSideComparingInt = mediumLayoutXRighttSide;
        } else if (Objects.equals(mode, "hard_mode")) {
            leftSideComparingInt = hardLayoutXlefttSide;
            rightSideComparingInt = hardLayoutXRighttSide;
        }

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable && !game_over) {
                    angle = -10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() > leftSideComparingInt && catMovable) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 15);
                    }
                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable && !game_over) {
                    angle = 10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() < rightSideComparingInt && catMovable) {
                        catImageView.setLayoutX(catImageView.getLayoutX() + 15);
                    }
                }
                Pause_Controller.pause_key_pressed(event, timer, root); // 暫停偵測
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable && !game_over) {
                    angle = 0;
                    catImageView.setRotate(angle);
                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable && !game_over) {
                    angle = 0;
                    catImageView.setRotate(angle);
                }
            }
        });
    }

}
