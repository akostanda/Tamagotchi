package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.model.Hero;

public class GameRoot {
    private Pane root;
    public static Scene gameScene;

    public void gameBuilder (Stage primaryStage) throws Exception {
        double n = 1.4;
        Hero character = new Hero("duke-java-logo1.png", 100.5 / n, 83.75 / n, 80, 200);
        Hero character2 = new Hero("duke-java-logo2.png", 69.11 / n, 83.75 / n, 200, 200);
        Hero character3 = new Hero("duke-java-logo3.png", 104.68 / n, 83.75 / n, 320, 200);
        Hero character4 = new Hero("duke-java-logo4.png", (122.275 * 1.3)/n, (83.75 * 1.3) / n, 440, 200/1.1);
        Hero character5 = new Hero("duke-java-logo5.png", (75.12 * 1.5) / n, (83.75 * 1.5) / n, 560, 200/1.2);
        Hero character6 = new Hero("duke-java-logo6.png", 81.82 / n, 83.75 / n, 680, 200);
        root = FXMLLoader.load(getClass().getResource("/dukeGame.fxml"));
        root.getChildren().addAll(character, character2, character3, character4, character5, character6);
        gameScene = new Scene(root, 800, 450);;
        primaryStage.setTitle("MyTamagochi");
        primaryStage.setScene(gameScene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
//        Image IMAGE = new Image("../../resources/duke-java-logo2.png");
//        duke.setImage(IMAGE);

    }
}
