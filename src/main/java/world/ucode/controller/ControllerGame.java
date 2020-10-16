package world.ucode.controller;

import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import world.ucode.model.DataBase;
import world.ucode.model.Hero;
import world.ucode.view.GameRoot;

public class ControllerGame {
//    public ImageView duke;
//    static Hero character;
    public ProgressBar healthIndex;
    public ProgressBar hungerIndex;
    public ProgressBar thirstIndex;
    public ProgressBar happineIndex;
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


    public void initialize() {
        healthIndex.setProgress(0.6);
        hungerIndex.setProgress(0.6);
        thirstIndex.setProgress(0.6);
        happineIndex.setProgress(0.6);
        cleanlinessIndex.setProgress(0.6);
    }
    public static void onKeyPressed(Hero character) {
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

    public  void update(Hero character, DataBase datab) throws Exception {
        healthIndex.setProgress(healthIndex.getProgress() + 0.001);
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
