package com.example.runningcat;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Cat_Controller {

    static ImageView cat_Image_View (Image catImage){

        ImageView catImageView = new ImageView(catImage);
        catImageView.setFitWidth(40);
        catImageView.setFitHeight(80);
        catImageView.setLayoutX(386);
        catImageView.setLayoutY(450);

        return catImageView;

    }


}
