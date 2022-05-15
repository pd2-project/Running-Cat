package cat_move;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CatMove {
    Image image = new Image("cat.png");
    ImageView iv = new ImageView(image);

    public double x = 400 , y = 100;
    public void moveRight() {
        if (x > 0) {
            iv.setX(x += 50);
        } else if (x == 800) {//800這裡要改成鄭紹麒設定的邊界
            //碰到右邊邊界
        }
    }

    public void moveLeft() {
        if (x > 0) {
            iv.setX(x -= 50);
        } else if (x == 0) {//0這裡要改成鄭紹麒設定的邊界
            //碰到左邊邊界
        }
    }

    public void moveTop() {
        if (y > 0) {
            iv.setX(y += 50);
        } else if (y == 400) {//400這裡要改成鄭紹麒設定的邊界
            //碰道上面邊界
        }
    }

    public void moveDown() {
        if (y > 0) {
            iv.setX(y += 50);
        } else if (y == 0) {//0這裡要改成鄭紹麒設定的邊界
            //碰道下面邊界
        }
    }
}
