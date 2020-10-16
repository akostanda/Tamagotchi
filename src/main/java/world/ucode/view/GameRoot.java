package world.ucode.view;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.controller.ControllerGame;
import world.ucode.model.DataBase;
import world.ucode.model.Hero;

public class GameRoot {
    private Pane root;
    public static Scene gameScene;
    private DataBase datab = new DataBase();
    private Hero character;
    double growth = 1.4;
    private ProgressBar healthIndex;
    private ProgressBar hungerIndex;
    private ProgressBar thirstIndex;
    private ProgressBar happineIndex;
    private ProgressBar cleanlinessIndex;

    public void gameBuilder (Stage primaryStage, String hero) throws Exception {
        if (datab.dbCreation(hero)) {
            character = new Hero(datab.dbFinder(datab.requestImage("IMAGE_NAME", "IMAGES",  hero, "MAIN_IMAGE")).getString("IMAGE_NAME"),
                    datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  hero, "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                    datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  hero, "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                    datab.dbFinder(datab.requestCharacter("X", "CHARACTERS",  hero)).getDouble("X"),
                    datab.dbFinder(datab.requestCharacter("Y", "CHARACTERS",  hero)).getDouble("Y"));
        }
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/dukeGame.fxml"));
        root = loader.load(getClass().getResourceAsStream("/dukeGame.fxml"));
//        gameRoot = loader.load(getClass().getResourceAsStream("/gamePlay.fxml"));
//        gameRoot.getChildren().add(borutoChar);
//        gameScene = new Scene(gameRoot, 800, 600);
//        Main.CtrlGame = loader.getController();
//        CtrlGame.update();
//        mainStage.setScene(gameScene);
//        mainStage.show();







//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/dukeGame.fxml"));
//        root = loader.getRoot();
//        root = FXMLLoader.load(getClass().getResource("/dukeGame.fxml"));
        root.getChildren().addAll(character);
        ControllerGame ctrlGame = loader.getController();
//        xxx.healthIndex.setProgress(1);

//        root = loader.load(getClass().getResource("/dukeGame.fxml"));

//                = new ControllerGame();
//        xxx.initialize();
//        ProgBars progBars = new ProgBars();
//        root.getChildren().addAll(character);
        gameScene = new Scene(root, 800, 450);;
        primaryStage.setTitle("MyTamagochi");
        primaryStage.setScene(gameScene);
        ControllerGame.onKeyPressed(character);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    ctrlGame.update(character, datab);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

}