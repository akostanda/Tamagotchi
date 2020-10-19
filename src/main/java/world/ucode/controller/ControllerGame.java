package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import world.ucode.model.Hero;
import world.ucode.view.GameRoot;

public class ControllerGame {
//    public ImageView duke;
//    static Hero character;
    private double growth = 1.4;
    public ProgressBar healthIndex;
    public ProgressBar hungerIndex;
    public ProgressBar thirstIndex;
    public ProgressBar happinessIndex;
    public ProgressBar cleanlinessIndex;

    public ControllerGame() throws Exception {
    }

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
        healthIndex.setProgress(ControllerMenu.datab.dbFinder("select HEALTH from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("HEALTH"));
        hungerIndex.setProgress(ControllerMenu.datab.dbFinder("select HUNGER from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("HUNGER"));
        thirstIndex.setProgress(ControllerMenu.datab.dbFinder("select THIRST from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("THIRST"));
        happinessIndex.setProgress(ControllerMenu.datab.dbFinder("select HAPPINESS from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("HAPPINESS"));
        cleanlinessIndex.setProgress(ControllerMenu.datab.dbFinder("select CLEANLINESS from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("CLEANLINESS"));
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
                ControllerMenu.datab.dbInsertUpdate("update USERS set GROWTH = " + growth + "," +
                        "X = " + GameRoot.character.getTranslateX() + "," +
                        "Y = " + GameRoot.character.getTranslateY() + "," +
                        "HEALTH = " + healthIndex.getProgress() + "," +
                        "HUNGER = " + hungerIndex.getProgress() + "," +
                        "THIRST = " + thirstIndex.getProgress() + "," +
                        "HAPPINESS = " + happinessIndex.getProgress() + "," +
                        "CLEANLINESS = " + cleanlinessIndex.getProgress() +
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

//    public  void toHeal(ActionEvent actionEvent) {
////        double tMoment = System.currentTimeMillis();
////        double n = tMoment + 30;
////        while (tMoment < n) {
////            healthIndex.setProgress(healthIndex.getProgress() + 0.01);
////            tMoment++;
////
////        }
//
//    }
    public void toHeal(MouseEvent mouseEvent) {
        double tMoment = System.currentTimeMillis();
        double n = tMoment + 3000;
        while (System.currentTimeMillis() < n) {
            healthIndex.setProgress(healthIndex.getProgress() + 0.001);
//            tMoment++;

       }
    }

    public void toFeed(ActionEvent actionEvent) {
    }

    public void toDrink(ActionEvent actionEvent) {
    }

    public void toPlay(ActionEvent actionEvent) {
    }

    public void toClean(ActionEvent actionEvent) {
    }

    public  void update() throws Exception {
    //        System.out.println(ControllerMenu.datab.dbFinder("select HEALTH from USERS where LOGIN
    // = '" +
    //                ControllerMenu.login + "'").getDouble("HEALTH"));
//    System.out.println(System.currentTimeMillis());
        if (healthIndex.getProgress() < 1)

        if (GameRoot.character.getTranslateX() > 680) {
            growth = 1;
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
        else if (GameRoot.character.getTranslateX() < 80) {
            growth = 0.8;
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
        else if (GameRoot.character.getTranslateY() < 60) {
            growth = 1.6;
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
        else if (GameRoot.character.getTranslateY() > 380) {
            growth = 1.2;
            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                    GameRoot.character.getTranslateX(),
                    GameRoot.character.getTranslateY());
        }
    }

}
