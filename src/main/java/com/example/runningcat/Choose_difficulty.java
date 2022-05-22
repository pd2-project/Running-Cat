package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
public class Choose_difficulty {

    // 車道邊界X座標 - easy: 190/570, medium: 247/513, hard: 275/485
    public final static int EASY_Width_RIGHT = 570;
    public final static int EASY_Width_LEFT = 190;
    public final static int MEDIUM_Width_RIGHT = 513;
    public final static int MEDIUM_Width_LEFT = 247;
    public final static int HARD_Width_RIGHT = 485;
    public final static int HARD_Width_LEFT = 275;

    // 這邊是要判定生成不同大小的障礙物的class，println的地方之後改成傳送給障礙物大小那邊的信號
    private Stage stage;
    private Scene scene;
    public Pane root;

    public boolean leftKey;
    public boolean rightKey;
    public int angle = 0;


    Cones_Controller cones_controller = new Cones_Controller();
    Image catImage;

    {
        try {
            catImage = new Image(new FileInputStream("src/main/resources/com/example/runningcat/cat.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    ImageView catImageView = new ImageView(catImage);


    public void create_view(ActionEvent event, String mode, String resource) throws IOException {

        // 這邊寫重複的扣
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource)));


        catImageView.setFitWidth(40);
        catImageView.setFitHeight(80);
        catImageView.setX(386);
        catImageView.setY(450);
        root.getChildren().add(catImageView);


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // 生成三角錐在視窗頂部的隨機位置


        root.getChildren().add(cones_controller.cones_appear_move(mode));

    }


    public void KeyDetectionEasy(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.A){

                    angle = -10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() > -190) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 15);
                    }

                } else if (event.getCode() == KeyCode.D) {

                    angle = 10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() < 175){
                        catImageView.setLayoutX(catImageView.getLayoutX() + 15);
                    }

                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.A){

                    angle = 0;
                    catImageView.setRotate(angle);

                } else if (event.getCode() == KeyCode.D) {

                    angle = 0;
                    catImageView.setRotate(angle);

                }

            }
        });
    }
    public void KeyDetectionMedium(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.A){

                    angle = -10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() > -130) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 12);
                    }

                } else if (event.getCode() == KeyCode.D) {

                    angle = 10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() < 110){
                        catImageView.setLayoutX(catImageView.getLayoutX() + 12);
                    }

                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.A){

                    angle = 0;
                    catImageView.setRotate(angle);

                } else if (event.getCode() == KeyCode.D) {

                    angle = 0;
                    catImageView.setRotate(angle);

                }

            }
        });
    }
    public void KeyDetectionHard(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.A){

                    angle = -10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() > -100) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 8);
                    }

                } else if (event.getCode() == KeyCode.D) {

                    angle = 10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() < 88){
                        catImageView.setLayoutX(catImageView.getLayoutX() + 8);
                    }

                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.A){

                    angle = 0;
                    catImageView.setRotate(angle);

                } else if (event.getCode() == KeyCode.D) {

                    angle = 0;
                    catImageView.setRotate(angle);

                }

            }
        });
    }


    public void easy_mode(ActionEvent event) throws IOException {

        System.out.println("easy");
        create_view(event, "easy_mode", "road-easy-view.fxml");
        KeyDetectionEasy();

    }

    public void medium_mode(ActionEvent event) throws IOException {

        System.out.println("medium");
        create_view(event, "medium_mode", "road-medium-view.fxml");
        KeyDetectionMedium();

    }
    public void hard_mode(ActionEvent event) throws IOException {

        System.out.println("hard");
        create_view(event, "hard_mode", "road-hard-view.fxml");
        KeyDetectionHard();
    }
}