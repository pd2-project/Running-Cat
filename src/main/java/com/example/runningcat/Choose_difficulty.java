package com.example.runningcat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Choose_difficulty {

    // 這邊是要判定生成不同大小的障礙物的class，println的地方之後改成傳送給障礙物大小那邊的信號
    private Stage stage;
    private Scene scene;
    public Pane root;
    Cones_Controller cones_controller = new Cones_Controller();
    //FXMLLoader loader = new FXMLLoader(getClass().getResource("road-easy-view.fxml"));
    public SetCatPos SP = new SetCatPos();
    //CatMovement catMovement = loader.getController(); // 還沒打完

    public void create_view(ActionEvent event, String mode, String resource) throws IOException {
        // 這邊寫重複的扣
        System.out.print("he");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // 生成三角錐在視窗頂部的隨機位置
        root.getChildren().add(cones_controller.cones_appear_move(mode));
        root.getChildren().add(SP.catImageView());
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
            }
        });
    }

    public void easy_mode(ActionEvent event) throws IOException {
        System.out.println("easy");
        create_view(event, "easy_mode", "road-easy-view.fxml");
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