package com.example.runningcat;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CatMovement {



    public CatMovement() throws FileNotFoundException {
        Image cat = new Image(new FileInputStream("src/main/resources/com/example/runningcat/cat.png"));
    }

    public void moveUp(){
        System.out.println("MOVIN' UP");
    }

    public void moveDown(){
        System.out.println("MOVIN' Down");
    }

    public void moveLeft(){
        System.out.println("MOVIN' Left");
    }

    public void moveRight(){
        System.out.println("MOVIN' RIGHT");
    }
}
