package world.ucode.view;

import javafx.animation.AnimationTimer;
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
        DataBase datab = new DataBase();
            Hero character;
            Scene scene;

    public void gameBuilder (Stage primaryStage, String hero) throws Exception {
            AnimationTimer timer;
        if (datab.dbCreation(hero)) {
            double n = 1.4;
            character = new Hero(datab.dbFinder(datab.requestImage("IMAGE_NAME", "IMAGES",  hero, "MAIN_IMAGE")).getString("IMAGE_NAME"),
                    datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  hero, "MAIN_IMAGE")).getDouble("WIDTH") / n,
                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  hero, "MAIN_IMAGE")).getDouble("HEIGHT") / n,
                    298,
                    308);
//            Hero character2 = new Hero("duke-logo2.png", 69.11 / n, 83.75 / n, 110, 200);
//            Hero character3 = new Hero("duke-logo3.png", 104.68 / n, 83.75 / n, 210, 200);
//            Hero character4 = new Hero("duke-logo4.png", (122.275 * 1.3)/n, (83.75 * 1.3) / n, 310, 200/1.1);
//            Hero character5 = new Hero("duke-logo5.png", (75.12 * 1.5) / n, (83.75 * 1.5) / n, 410, 200/1.2);
//            Hero character6 = new Hero("duke-logo6.png", 81.82 / n, 83.75 / n, 510, 200);
//            Hero character7 = new Hero("duke-therapy.png", (93.93 * 1.75) / n, (83.75 * 1.75) / n, 310, 200/1.2);
//            Hero character8 = new Hero("duke-cleaning1.png", (137.4 * 1.7) / n, (83.75 * 1.7) / n, 410, 200/1);
//            Hero character9 = new Hero("duke-dying.png", (55.9 * 1.1) / n, (83.75 * 1.1) / n, 10, 200);
//            Hero character10 = new Hero("duke-dead.png", (83.75 * 1.1) / n, (83.75 * 1.1) / n, 110, 200);

            root = FXMLLoader.load(getClass().getResource("/dukeGame.fxml"));
            root.getChildren().addAll(character);
            gameScene = new Scene(root, 800, 450);;
            primaryStage.setTitle("MyTamagochi");
            primaryStage.setScene(gameScene);
            ControllerGame.onKeyPressed(character);
                timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        try {
                            update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
        }
    }
    public void update() throws Exception {
        if (character.getTranslateX() > 680) {
            character.resetImage(datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 1,
                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 1,
                    character.getTranslateX(),
                    character.getTranslateY());
        }
        else if (character.getTranslateX() < 80) {
            character.resetImage(datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 1.6,
                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 1.6,
                    character.getTranslateX(),
                    character.getTranslateY());
        }
        else if (character.getTranslateY() < 60) {
            character.resetImage(datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 0.8,
                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 0.8,
                    character.getTranslateX(),
                    character.getTranslateY());
        }
        else if (character.getTranslateY() > 380) {
            character.resetImage(datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 1.05,
                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 1.05,
                    character.getTranslateX(),
                    character.getTranslateY());
        }
    }
}