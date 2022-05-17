package com.example.runningcat;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SetCatPos {
    ImageView catImageView() throws FileNotFoundException {
        Image cat = new Image(new FileInputStream("src/main/resources/com/example/runningcat/cat.png"));
        ImageView IV = new ImageView(cat);

        IV.setX(300);
        IV.setY(300);
        IV.setFitHeight(100);
        IV.setFitWidth(100);
        IV.setPreserveRatio(true);

        return IV;
    }
}
