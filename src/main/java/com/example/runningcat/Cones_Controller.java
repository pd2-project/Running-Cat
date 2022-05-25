package com.example.runningcat;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;


// 設定三角錐的controller，主要負責展示在遊戲畫面上
public class Cones_Controller {

    static void newConesPosition(String mode, ImageView cone_imageView) {

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
            while (randNum < 275 || randNum > 465) {
                randNum = Math.random() * 1000;
            }
        }
        cone_imageView.setLayoutX(randNum);
        cone_imageView.setLayoutY(-40.0 - (Math.random() * 1000));
    }


    static ImageView cones_image_view(String mode, Image cone_image) throws FileNotFoundException {

        ImageView cone_imageView = new ImageView(cone_image);

        newConesPosition(mode, cone_imageView);
        // cones size
        cone_imageView.setFitWidth(60);
        cone_imageView.setFitHeight(60);

        return cone_imageView;
    }

    static void create_cones(String mode, Pane root, Image cone_image, ImageView[] cones_array) throws FileNotFoundException {
        for (int i = 0; i < cones_array.length; i++) {
            cones_array[i] = Cones_Controller.cones_image_view(mode, cone_image);
            root.getChildren().add(cones_array[i]);
        }
    }

    static void checkConesPositionAndReuse(String mode, ImageView[] cones_array) {
        for (ImageView imageView : cones_array) {
            if (imageView.getLayoutY() > 580) {
                Cones_Controller.newConesPosition(mode, imageView);
                speedUp += 0.05;
            }
        }
    }

    public static double speedUp = 0;
    static void drop_cones(String mode, ImageView[] cones_array) {
        for (ImageView imageView : cones_array) {
            if (Objects.equals(mode, "easy_mode"))
                imageView.setLayoutY(imageView.getLayoutY() + 4 + speedUp);
            else if (Objects.equals(mode, "medium_mode"))
                imageView.setLayoutY(imageView.getLayoutY() + 5 + speedUp);
            else if (Objects.equals(mode, "hard_mode"))
                imageView.setLayoutY(imageView.getLayoutY() + 6 + speedUp);
        }
    }

}
