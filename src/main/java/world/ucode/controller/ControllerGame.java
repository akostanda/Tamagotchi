package world.ucode.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import world.ucode.model.Increaser;
import world.ucode.view.GameRoot;

public class ControllerGame {
//    public ImageView duke;
//    static Hero character;
public double health;
public static boolean trigger = false;
    private double growth = 1.4;
    private int decreasDuration = 300;
    private int increasDuration = 500;
    private int count = 0;
    public ProgressBar healthIndex;
    public ProgressBar hungerIndex;
    public ProgressBar thirstIndex;
    public ProgressBar happinessIndex;
    public ProgressBar cleanlinessIndex;
    private Timeline decreaser;
    private Timeline increaser;
//    Hero character;

    public ControllerGame() throws Exception {}

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

    public void onKeyPressed() {
//        this.character = character;
        GameRoot.gameScene.setOnKeyPressed(
                event -> {
                    KeyCode keyCode = event.getCode();
                    if (keyCode.equals(keyCode.D) && GameRoot.character.getTranslateX() < 740)
                        GameRoot.character.setTranslateX(GameRoot.character.getTranslateX() + 5);
                    else if (keyCode.equals(keyCode.A) && GameRoot.character.getTranslateX() > 10)
                        GameRoot.character.setTranslateX(GameRoot.character.getTranslateX() - 10);
                    else if (keyCode.equals(keyCode.W)  && GameRoot.character.getTranslateY() > 50)
                        GameRoot.character.setTranslateY(GameRoot.character.getTranslateY() - 5);
                    else if (keyCode.equals(keyCode.Z) && GameRoot.character.getTranslateY() < 385)
                        GameRoot.character.setTranslateY(GameRoot.character.getTranslateY() + 5);
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

    public void indicatorsDecreaser() {
        decreaser = new Timeline(
                new KeyFrame(Duration.millis(decreasDuration), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        if (healthIndex.getProgress() > 0.001) {
                            healthIndex.setProgress(healthIndex.getProgress() - 0.001);
                            System.out.println(healthIndex.getProgress());
                            if (healthIndex.getProgress() < 0.35) {
                                healthIndex.setStyle("-fx-accent: #ff3f3f;");
                           }
                        }
                        if (hungerIndex.getProgress() > 0.01) {
                            hungerIndex.setProgress(hungerIndex.getProgress() - 0.01);
//                            System.out.println(hungerIndex.getProgress());
                            if (hungerIndex.getProgress() < 0.35) {
                                hungerIndex.setStyle("-fx-accent: #ff3f3f;");
                            }
                        }
                        if (thirstIndex.getProgress() > 0.03) {
                            thirstIndex.setProgress(thirstIndex.getProgress() - 0.03);
//                            System.out.println(thirstIndex.getProgress());
                            if (thirstIndex.getProgress() < 0.35) {
                                thirstIndex.setStyle("-fx-accent: #ff3f3f;");
                            }
                        }
                        if (happinessIndex.getProgress() > 0.005) {
                            happinessIndex.setProgress(happinessIndex.getProgress() - 0.005);
//                            System.out.println(happinessIndex.getProgress());
                            if (happinessIndex.getProgress() < 0.35) {
                                happinessIndex.setStyle("-fx-accent: #ff3f3f;");
                            }
                        }
                        if (cleanlinessIndex.getProgress() > 0.001) {
                            cleanlinessIndex.setProgress(cleanlinessIndex.getProgress() - 0.001);
//                            System.out.println(cleanlinessIndex.getProgress());
                            if (cleanlinessIndex.getProgress() < 0.35) {
                                cleanlinessIndex.setStyle("-fx-accent: #ff3f3f;");
                            }
                        }
                    }
                })
        );
        decreaser.setCycleCount(Timeline.INDEFINITE);
        decreaser.play();
    }

    public void toHeal(MouseEvent mouseEvent) throws Exception {
        trigger = true;
        Increaser health = new Increaser();
        health.increasProgress(healthIndex, "HEALTH_IMAGE", 0.01);
//        trigger = false;
    }

    public void toFeed(MouseEvent mouseEvent) throws Exception {
        Increaser hunger = new Increaser();
        hunger.increasProgress(hungerIndex, "HUNGER_IMAGE", 0.1);

    }

    public void toDrink(MouseEvent mouseEvent) {
    }

    public void toPlay(MouseEvent mouseEvent) {
    }

    public void toClean(MouseEvent mouseEvent) {
    }

    public  void update(long beginTime, long pastTime) throws Exception {
//        long pastTime2 = pastTime;
//
//        if (System.currentTimeMillis() > (beginTime + pastTime2) && healthIndex.getProgress() > 0.1) {
//            System.out.println("beginTime = " + beginTime);
//            System.out.println("pastTime2 = " + pastTime2);
//            System.out.println(System.currentTimeMillis() + " = " + (beginTime + pastTime2));
//            healthIndex.setProgress(healthIndex.getProgress() - 0.001);
//            pastTime2 = pastTime2 * 2;
//            return;
//        }
    //        System.out.println(ControllerMenu.datab.dbFinder("select HEALTH from USERS where LOGIN
    // = '" +
    //                ControllerMenu.login + "'").getDouble("HEALTH"));
    //    System.out.println(System.currentTimeMillis());
    //        if (healthIndex.getProgress() < 1)
    //            healthIndex.setProgress(healthIndex.getProgress() + 0.001);
//    System.out.println(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
//            "IMAGES",  "Duke", "THIRST_IMAGE")).getString("IMAGE_NAME"));
//    System.out.println(health);
//        health++;
//        if (health % 100 == 0) {
//            character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
//                    "IMAGES",  "Duke", "THIRST_IMAGE")).getString("IMAGE_NAME"));
//        }

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
