package cat_move;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static javafx.application.Application.launch;

public class SetCatPos {

    public static void main(String[] args) {
        launch(args);
    }

    public void start () {
        Image image = new Image("cat.png");
        ImageView iv = new ImageView(image);

        iv.setX(400);
        iv.setY(100);
    }
}
