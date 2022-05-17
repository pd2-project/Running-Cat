package com.example.runningcat;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Cones_Controller {
    // 設定三角錐的controller，主要負責展示在遊戲畫面上
    ImageView Cones_Appear(String mode) throws FileNotFoundException {
        Image cone_image = new Image(new FileInputStream("src/main/resources/com/example/runningcat/cones.png"));
        ImageView cone_imageView = new ImageView(cone_image);
        cone_imageView.setImage(cone_image);
        double randNum = 0;

        while (randNum < 190 || randNum > 570) {
            randNum = Math.random() * 1000;
        }
        System.out.println(randNum);
        // x = 190 剛剛好是車道的左邊, x = 570 是右邊(easy_mode)
        // 車道邊界X座標 - easy:190/570  medium:247/513  hard: 275/485
        cone_imageView.setX(485);
        cone_imageView.setY(-30.0);
        cone_imageView.setFitHeight(40);
        cone_imageView.setFitWidth(40);
        cone_imageView.setPreserveRatio(true);
        return cone_imageView;
    }

}
