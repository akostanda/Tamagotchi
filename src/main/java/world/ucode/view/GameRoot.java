package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.controller.ControllerGame;
import world.ucode.model.DataBase;
import world.ucode.model.Hero;

public class GameRoot {
    private Pane root;
    public static Scene gameScene;

    public void gameBuilder (Stage primaryStage, String hero) throws Exception {
        DataBase datab = new DataBase();
        if (datab.dbCreation(hero)) {
            double n = 1.4;
            Hero character = new Hero("duke-logo1.png", 100.5 / n, 83.75 / n, 10, 200);
            Hero character2 = new Hero("duke-logo2.png", 69.11 / n, 83.75 / n, 110, 200);
            Hero character3 = new Hero("duke-logo3.png", 104.68 / n, 83.75 / n, 210, 200);
            Hero character4 = new Hero("duke-logo4.png", (122.275 * 1.3)/n, (83.75 * 1.3) / n, 310, 200/1.1);
            Hero character5 = new Hero("duke-logo5.png", (75.12 * 1.5) / n, (83.75 * 1.5) / n, 410, 200/1.2);
            Hero character6 = new Hero("duke-logo6.png", 81.82 / n, 83.75 / n, 510, 200);
            Hero character7 = new Hero("duke-therapy.png", (93.93 * 1.75) / n, (83.75 * 1.75) / n, 310, 200/1.2);
            Hero character8 = new Hero("duke-cleaning1.png", (137.4 * 1.7) / n, (83.75 * 1.7) / n, 410, 200/1);
            Hero character9 = new Hero("duke-dying.png", (55.9 * 1.1) / n, (83.75 * 1.1) / n, 10, 200);
            Hero character10 = new Hero("duke-dead.png", (83.75 * 1.1) / n, (83.75 * 1.1) / n, 110, 200);

            root = FXMLLoader.load(getClass().getResource("/dukeGame.fxml"));
            root.getChildren().addAll(character, character2, character4, character3, character5, character6, character7, character8, character9, character10);
            gameScene = new Scene(root, 800, 450);;
//            ControllerGame.onKeyPressed(character);

//            GameRoot.gameScene.setOnKeyPressed(
//                    event -> {
//                        System.out.println(character.getTranslateX());
//                        System.out.println(character.getTranslateY());
//                        System.out.println();
//                        if ((keyCode.equals(keyCode.D)))
//                            character.setTranslateX(character.getTranslateX() + 10);
//                        else if ((keyCode.equals(keyCode.LEFT)))
//                            character.setTranslateX(character.getTranslateX() - 10);
//                        else if ((keyCode.equals(keyCode.UP)))
//                            character.setTranslateY(character.getTranslateY() + 5);
//                        else if ((keyCode.equals(keyCode.DOWN)))
//                            character.setTranslateY(character.getTranslateY() - 5);
//                    });


            primaryStage.setTitle("MyTamagochi");
            primaryStage.setScene(gameScene);
//            primaryStage.setResizable(false);
//            primaryStage.centerOnScreen();
        }
//        Image IMAGE = new Image("../../resources/duke-java-logo2.png");
//        duke.setImage(IMAGE);

    }
}
