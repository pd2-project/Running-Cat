package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Cat_choose {

    public static String catImageURL;
    public static String FXMLURL = "choose-character.fxml";
    public Pane root;
    public Stage stage;
    public Scene scene;
    public static ImageView go_back_button;
    public void showGoBackButton() throws IOException{
        FXMLURL = "choose-character.fxml";
        go_back_button = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/go_back.png")));
        go_back_button.setFitWidth(50);
        go_back_button.setFitHeight(60);
        go_back_button.setLayoutX(20);
        go_back_button.setLayoutY(20);
        go_back_button.setOnMouseClicked((MouseEvent e) -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(FXMLURL)));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
            if(FXMLURL == "choose-character.fxml"){
                FXMLURL = "real-start-view.fxml";
                root.getChildren().add(go_back_button);
            }else {
                root.getChildren().remove(go_back_button);
            }
        });
        root.getChildren().add(go_back_button);
    }

    public void fat_cat(ActionEvent event) throws IOException {
        catImageURL = "src/main/resources/com/example/runningcat/fat-cat.png";
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        showGoBackButton();
    }

    public void medium_cat(ActionEvent event) throws IOException {
        catImageURL = "src/main/resources/com/example/runningcat/medium-cat.png";
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        showGoBackButton();
    }

    public void thin_cat(ActionEvent event) throws IOException {
        catImageURL = "src/main/resources/com/example/runningcat/thin-cat.png";
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start-view.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        showGoBackButton();
    }
}
