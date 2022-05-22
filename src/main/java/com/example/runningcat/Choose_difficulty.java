package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
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
        catImageView.setX(400);
        catImageView.setY(300);
        root.getChildren().add(catImageView);


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // 生成三角錐在視窗頂部的隨機位置


        root.getChildren().add(cones_controller.cones_appear_move(mode));

    }



    public void KeyDetection(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.A){
                    leftKey = true;
                    angle = -10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() > -200) {
                        catImageView.setLayoutX(catImageView.getLayoutX() - 2);
                        System.out.println("PPP");
                    }
                } else if (event.getCode() == KeyCode.D) {
                    rightKey = true;
                    angle = 10;
                    catImageView.setRotate(angle);
                    if(catImageView.getLayoutX() < 200){
                        catImageView.setLayoutX(catImageView.getLayoutX() + 2);
                        System.out.println("TTT");
                    }
                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.A){
                    leftKey = false;
                    angle = 0;
                    catImageView.setRotate(angle);
                    System.out.println("DADA");
                } else if (event.getCode() == KeyCode.D) {
                    rightKey = false;
                    angle = 0;
                    catImageView.setRotate(angle);
                    System.out.println("ADAD");
                }

            }
        });
    }
    public void moveCat(){

        if(leftKey == true){
            if(angle == 0){
                angle -= 5;
                System.out.println("AAA");
            }
            catImageView.setRotate(angle);

        }

    }

    public void easy_mode(ActionEvent event) throws IOException {

        System.out.println("easy");
        create_view(event, "easy_mode", "road-easy-view.fxml");
        KeyDetection();
        moveCat();
    }

    public void medium_mode(ActionEvent event) throws IOException {

        System.out.println("medium");
        create_view(event, "medium_mode", "road-medium-view.fxml");

    }

    public void hard_mode(ActionEvent event) throws IOException {

        System.out.println("hard");
        create_view(event, "hard_mode", "road-hard-view.fxml");

    }


}