package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Window extends Pane  {
    int y = 0;
    Image IMAGE = new Image("duke-java-logo1.png");
    ImageView imageView = new ImageView(IMAGE);
}
