package com.example.runningcat;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Key_Detector {

    public static boolean catMovable = true;
    public static int angle = 0;

    public static void KeyDetectionEasy(Scene scene, ImageView catImageView) {



        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable) {

                    angle = -10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() > 190 && catMovable) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 15);
                    }

                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable) {

                    angle = 10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() < 570 && catMovable) {
                        catImageView.setLayoutX(catImageView.getLayoutX() + 15);
                    }

                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable) {

                    angle = 0;
                    catImageView.setRotate(angle);

                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable) {

                    angle = 0;
                    catImageView.setRotate(angle);

                }

            }
        });
    }

    public static void KeyDetectionMedium(Scene scene, ImageView catImageView) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable) {

                    angle = -10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() > 250) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 12);
                    }

                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable) {

                    angle = 10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() < 510) {
                        catImageView.setLayoutX(catImageView.getLayoutX() + 12);
                    }

                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.A && catMovable) {

                    angle = 0;
                    catImageView.setRotate(angle);

                } else if (event.getCode() == KeyCode.D && catMovable) {

                    angle = 0;
                    catImageView.setRotate(angle);

                }

            }
        });
    }

    public static void KeyDetectionHard(Scene scene, ImageView catImageView) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable) {

                    angle = -10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() > 282) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 8);
                    }

                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable) {

                    angle = 10;
                    catImageView.setRotate(angle);
                    if (catImageView.getLayoutX() < 475) {
                        catImageView.setLayoutX(catImageView.getLayoutX() + 8);
                    }

                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if ((event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) && catMovable) {

                    angle = 0;
                    catImageView.setRotate(angle);

                } else if ((event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) && catMovable) {

                    angle = 0;
                    catImageView.setRotate(angle);

                }

            }
        });
    }
}
