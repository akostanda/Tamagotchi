package world.ucode.view;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.controller.ControllerGame;
import world.ucode.model.Hero;

public class GameRoot {
    private Pane root;
    public static Scene gameScene;
//    public static DataBase datab = new DataBase();
    public static Hero character;
    double growth = 1.4;

    public GameRoot(Hero character) {
        this.character = character;
    }
    public void gameBuilder (Stage primaryStage, String fileFxml) throws Exception {
//        if (datab.dbCreation(hero)) {
//            character = new Hero(datab.dbFinder(datab.requestImage("IMAGE_NAME", "IMAGES",  hero, "MAIN_IMAGE")).getString("IMAGE_NAME"),
//                    datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  hero, "MAIN_IMAGE")).getDouble("WIDTH") / growth,
//                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  hero, "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
//                    datab.dbFinder(datab.requestCharacter("X", "CHARACTERS",  hero)).getDouble("X"),
//                    datab.dbFinder(datab.requestCharacter("Y", "CHARACTERS",  hero)).getDouble("Y"));
//        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fileFxml));
        root = loader.load(getClass().getResourceAsStream(fileFxml));
        root.getChildren().addAll(character);
        ControllerGame ctrlGame = loader.getController();
        gameScene = new Scene(root, 800, 450);;
        primaryStage.setTitle("MyTamagochi");
        primaryStage.setScene(gameScene);
        ctrlGame.onKeyPressed(character);
        primaryStage.setOnCloseRequest(ctrlGame.getCloseEventHandler());
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    ctrlGame.update();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

}