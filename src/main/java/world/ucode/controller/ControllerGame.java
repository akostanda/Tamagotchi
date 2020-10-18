package world.ucode.controller;

import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.stage.WindowEvent;
import world.ucode.model.Hero;
import world.ucode.view.GameRoot;

public class ControllerGame {
//    public ImageView duke;
//    static Hero character;
    public ProgressBar healthIndex;
    public ProgressBar hungerIndex;
    public ProgressBar thirstIndex;
    public ProgressBar happinessIndex;
    public ProgressBar cleanlinessIndex;

//    public void onTouch() {
//        Image IMAGE;
////        String str = duke.getImage().getUrl();
////        if (str.equals("file:/Users/akostanda/IdeaProjects/Tamagotchi/target/classes/duke-java-logo3.png\n"))
//            IMAGE = new Image("duke-java-logo2.png");
////        else IMAGE = new Image("duke-java-logo3.png");
//            duke.setImage(IMAGE);
//        duke.setTranslateX(duke.getTranslateX() + 10);
//        System.out.println(1);
//    }


    public void initialize() throws Exception {
//        healthIndex.setProgress(ControllerMenu.datab.dbFinder("select HEALTH from USERS where LOGIN = '" +
//                ControllerMenu.login + "'").getDouble("HEIGHT"));
        hungerIndex.setProgress(0.6);
        thirstIndex.setProgress(0.6);
        happinessIndex.setProgress(0.6);
        cleanlinessIndex.setProgress(0.6);
    }
    public void onKeyPressed(Hero character) {
        GameRoot.gameScene.setOnKeyPressed(
                event -> {
                    KeyCode keyCode = event.getCode();
                    if (keyCode.equals(keyCode.RIGHT) && character.getTranslateX() < 740)
                        character.setTranslateX(character.getTranslateX() + 5);
                    else if (keyCode.equals(keyCode.LEFT) && character.getTranslateX() > 10)
                        character.setTranslateX(character.getTranslateX() - 10);
                    else if (keyCode.equals(keyCode.UP)  && character.getTranslateY() > 50)
                        character.setTranslateY(character.getTranslateY() - 5);
                    else if (keyCode.equals(keyCode.DOWN) && character.getTranslateY() < 385)
                        character.setTranslateY(character.getTranslateY() + 5);
                });
    }

    private javafx.event.EventHandler<WindowEvent> closeEventHandler = new javafx.event.EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            try {
                ControllerMenu.datab.dbInsertUpdate("update USERS set WIDTH = " + GameRoot.character.getWidth() + "," +
                        "HEIGHT = " + GameRoot.character.getHeight() + "," +
                        "X = " + GameRoot.character.getTranslateX() + "," +
                        "Y = " + GameRoot.character.getTranslateY() +
                        " where LOGIN = '" + ControllerMenu.login + "'");
//                ControllerMenu.datab.dbClose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public javafx.event.EventHandler<WindowEvent> getCloseEventHandler(){
        return closeEventHandler;
    }

    public  void update() throws Exception {
        healthIndex.setProgress(healthIndex.getProgress() + 0.001);
        if (GameRoot.character.getTranslateX() > 680) {
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 1,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 1,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
        else if (GameRoot.character.getTranslateX() < 80) {
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 1.6,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 1.6,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
        else if (GameRoot.character.getTranslateY() < 60) {
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 0.8,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 0.8,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
        else if (GameRoot.character.getTranslateY() > 380) {
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / 1.05,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / 1.05,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
    }

}
