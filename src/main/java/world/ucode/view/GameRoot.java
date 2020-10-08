package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameRoot {
    private Parent root;
//    public ImageView duke;

    public void gameBuilder (Stage primaryStage) throws Exception {
//            Image IMAGE = new Image("duke-java-oracle.png");
        root = FXMLLoader.load(getClass().getResource("/game.fxml"));
        Scene scene = new Scene(root, 800, 450);
        primaryStage.setTitle("MyTamagochi");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
//        Image IMAGE = new Image("../../resources/duke-java-logo2.png");
//        duke.setImage(IMAGE);

    }
}
