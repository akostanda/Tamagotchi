package world.ucode.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import world.ucode.Main;

import java.util.Deque;
import java.util.LinkedList;

public class Character extends Pane {
    static Deque<Image> images = new LinkedList<Image>();
    private Image IMAGE;
    private ImageView imageView;

    Character (String imageUral, double width, double height, double x, double y) {
        IMAGE = new Image(imageUral);
        imageView = new ImageView(IMAGE);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.getChildren().add(imageView);
    }
}
