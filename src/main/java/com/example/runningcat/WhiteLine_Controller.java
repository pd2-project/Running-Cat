package com.example.runningcat;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.Objects;

public class WhiteLine_Controller {

    public static double speedUp = 0;

    static void newWhileLinePosition(int x, int y, ImageView whiteLine_imageview){

        whiteLine_imageview.setLayoutX(x);
        whiteLine_imageview.setLayoutY(y);

    }

    static ImageView whiteLine_image_view(int x, int y, Image whiteLine_image) throws FileNotFoundException{

        ImageView whiteLine_imageview = new ImageView(whiteLine_image);

        newWhileLinePosition(x, y, whiteLine_imageview);
        whiteLine_imageview.setFitWidth(60);
        whiteLine_imageview.setFitHeight(60);
        whiteLine_imageview.setPreserveRatio(true);

        return whiteLine_imageview;

    }

    static void create_whiteLine(int x, int y, Pane root, Image whiteLine_image, ImageView[] whiteLine_array) throws FileNotFoundException{
        for(int i=0; i < whiteLine_array.length; i++){
            whiteLine_array[i] = WhiteLine_Controller.whiteLine_image_view(x, y, whiteLine_image);
            root.getChildren().add(whiteLine_array[i]);
            y +=120;
        }
    }

    static void checkWhiteLinePositionAndReuse(String mode, ImageView[] whiteLine_array){
        if(Objects.equals(mode, "easy_mode")){
            for(int i=0; i< whiteLine_array.length; i++){
                if(whiteLine_array[i].getLayoutY()>600){
                    WhiteLine_Controller.newWhileLinePosition(467, -120, whiteLine_array[i]);
                    WhiteLine_Controller.newWhileLinePosition(333, -120, whiteLine_array[i]);
                    speedUp += 0.014;
                }
            }
        }else{
            for(int i=0; i< whiteLine_array.length; i++){
                if(whiteLine_array[i].getLayoutY()>600){
                    WhiteLine_Controller.newWhileLinePosition(400, -120, whiteLine_array[i]);
                    speedUp += 0.014;
                }
            }
        }
    }

    static void drop_whiteLine(String mode, ImageView[] whiteLine_array) {
        for (int i = 0; i < whiteLine_array.length; i++) {
            if (Objects.equals(mode, "easy_mode"))
                whiteLine_array[i].setLayoutY(whiteLine_array[i].getLayoutY() + 4 + speedUp);
            else if (Objects.equals(mode, "medium_mode"))
                whiteLine_array[i].setLayoutY(whiteLine_array[i].getLayoutY() + 5 + speedUp);
            else if (Objects.equals(mode, "hard_mode"))
                whiteLine_array[i].setLayoutY(whiteLine_array[i].getLayoutY() + 6 + speedUp);
        }
    }
}
