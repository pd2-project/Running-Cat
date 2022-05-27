package com.example.runningcat;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static com.example.runningcat.Scoreboard.score;
import static com.example.runningcat.Key_Detector.catMovable;

public class Choose_difficulty {

    private Stage stage;
    private Scene scene;
    public static Pane root;

    ImageView catImageView = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/cat.png")));
    Image cone_image = new Image(new FileInputStream("src/main/resources/com/example/runningcat/cones.png"));
    ImageView[] cones_array = new ImageView[4];
    Image whiteLine_image = new Image(new FileInputStream("src/main/resources/com/example/runningcat/whiteLine.JPG"));
    ImageView[] whiteLine_array = new ImageView[6];
    ImageView[] whiteLine_array_right = new ImageView[6];
    public static AnimationTimer timer;

    Text text_score = new Text("" + score); // 分數的textView
    ImageView score_board_textView = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/score_board_background.png")));
    ImageView pause_image_center = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/pause-center.png")));
    ImageView pause_image_corner = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/pause_image_corner.png")));
    ImageView start_image_corner = new ImageView(new Image(new FileInputStream("src/main/resources/com/example/runningcat/start_image_corner.png")));
    public Choose_difficulty() throws FileNotFoundException {} // 這個不能刪，因為要在建構時丟出FileNotFoundException

    private void create_view(ActionEvent event, String mode, String resource) throws IOException {
        // 這邊寫重複的扣
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource)));

        //生成車道線
        if(Objects.equals(mode, "easy_mode")){
            WhiteLine_Controller.create_whiteLine(467, -120, root, whiteLine_image, whiteLine_array);
            WhiteLine_Controller.create_whiteLine(333, -120, root, whiteLine_image, whiteLine_array_right);
        } else {
            WhiteLine_Controller.create_whiteLine(400, -120, root, whiteLine_image, whiteLine_array);
        }

        root.getChildren().add(Cat_Controller.cat_Image_View(catImageView));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // 生成三角錐
        Cones_Controller.create_cones(mode, root, cone_image, cones_array);

        // 顯示計分板
        Scoreboard.show_score(root, text_score, score_board_textView, mode);

        // 放暫停的圖案但不顯示
        Pause_Controller.create_pause_image(pause_image_center, start_image_corner, pause_image_corner, root, timer);
    }

    private void collisionDetect() {
        // 偵測碰撞的參數
        for (ImageView imageView : cones_array) {
            if (
                    imageView.getLayoutY() + 44 >= catImageView.getLayoutY()
                    && imageView.getLayoutY() <= catImageView.getLayoutY()
                    && imageView.getLayoutX() + 40 >= catImageView.getLayoutX()
                    && imageView.getLayoutX() - 17 <= catImageView.getLayoutX()
            ) {
                System.out.println("|||||||||||||||||");
                System.out.println("||  game over  ||");
                System.out.println("|||||||||||||||||");
                catMovable = false;
                timer.stop();
            }
        }
    }

    private void start_timer(String mode) {
        // 藉由幀數做邏輯判斷與動畫
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Cones_Controller.drop_cones(mode, cones_array);

                Cones_Controller.checkConesPositionAndReuse(mode, cones_array);
                WhiteLine_Controller.drop_whiteLine(mode, whiteLine_array);
                WhiteLine_Controller.checkWhiteLinePositionAndReuse(mode, whiteLine_array);
                if (mode.equals("easy_mode")) {
                    WhiteLine_Controller.checkWhiteLinePositionAndReuse(mode, whiteLine_array_right);
                    WhiteLine_Controller.drop_whiteLine(mode, whiteLine_array_right);
                }
                score++;
                Cones_Controller.checkConesPositionAndReuse(mode, cones_array); // 三角錐位置偵測並更新位置
                collisionDetect(); // 碰撞偵測
                Scoreboard.count(text_score); // 更新秒數

                // System.out.println("cat y: " + catImageView.getLayoutY());
                // System.out.println("cones y: " + cones_array[0].getLayoutY());
            }
        };
        timer.start();
    }


    public void easy_mode(ActionEvent event) throws IOException {
        String mode = "easy_mode";
        System.out.println(mode);
        create_view(event, mode, "road-easy-view.fxml");
        Key_Detector.KeyDetectionEasy(scene,catImageView);
        start_timer(mode);
        Mouse_Detector.pause_click(pause_image_center, start_image_corner, pause_image_corner, root, timer);
    }

    public void medium_mode(ActionEvent event) throws IOException {
        String mode = "medium_mode";
        System.out.println(mode);
        create_view(event, mode, "road-medium-view.fxml");
        Key_Detector.KeyDetectionMedium(scene,catImageView);
        start_timer(mode);
        Mouse_Detector.pause_click(pause_image_center, start_image_corner, pause_image_corner, root, timer);
    }

    public void hard_mode(ActionEvent event) throws IOException {
        String mode = "hard_mode";
        System.out.println(mode);
        create_view(event, mode, "road-hard-view.fxml");
        Key_Detector.KeyDetectionHard(scene,catImageView);
        start_timer(mode);
        Mouse_Detector.pause_click(pause_image_center, start_image_corner, pause_image_corner, root, timer);
    }
}