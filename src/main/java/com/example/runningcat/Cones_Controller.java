package com.example.runningcat;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
// 設定三角錐的controller，主要負責展示在遊戲畫面上
public class Cones_Controller {


    ImageView cones_appear_move(String mode) throws FileNotFoundException {
        Image cone_image = new Image(new FileInputStream("src/main/resources/com/example/runningcat/cones.png"));
        ImageView cone_imageView = new ImageView(cone_image);
        cone_imageView.setImage(cone_image);
        double randNum = 0;

        // 車道邊界X座標 - easy: 190/570, medium: 247/513, hard: 275/485
        // 根據難度隨機分配位置
        // 越往下越正
        if (Objects.equals(mode, "easy_mode")) {
            while (randNum < 190 || randNum > 550) {
                randNum = Math.random() * 1000;
            }
        } else if (Objects.equals(mode, "medium_mode")) {
            while (randNum < 247 || randNum > 493) {
                randNum = Math.random() * 1000;
            }
        } else if (Objects.equals(mode, "hard_mode")) {
            while (randNum < 27 || randNum > 465) {
                randNum = Math.random() * 1000;
            }
        }

        //圖片出現位置
        cone_imageView.setX(randNum);
        cone_imageView.setY(-40.0);
        cone_imageView.setFitHeight(60);
        cone_imageView.setFitWidth(60);

        // 動畫部分
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(10));
        transition.setToY(700);
        transition.setNode(cone_imageView);
        transition.play();

        // cone_imageView.setla

        return cone_imageView;
    }
}
