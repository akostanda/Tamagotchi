package world.ucode.controller;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import world.ucode.model.Decreaser;
import world.ucode.model.Increaser;
import world.ucode.view.GameRoot;

public class ControllerGame {
    private double growth = ControllerMenu.datab.dbFinder("select GROWTH from USERS where LOGIN = '" +
            ControllerMenu.login + "'").getDouble("GROWTH");
    public static int count = 0;
    private long timeToGrowth = 3000;
    private Decreaser healthDec;
    private Decreaser hungerDec;
    private Decreaser thirstDec;
    private Decreaser happinessDec;
    private Decreaser cleanlinessDec;
    public TextField sadTextFd;
//    public TextField hungerTextFd;
//    public TextField thirstTextFd;
//    public TextField cleanTextFd;
    public static Increaser healthInc = new Increaser();
    public static Increaser hungerInc = new Increaser();
    public static Increaser thirstInc = new Increaser();
    public static Increaser happinessInc = new Increaser();
    public static Increaser cleanlinessInc = new Increaser();
    public ProgressBar healthIndex;
    public ProgressBar hungerIndex;
    public ProgressBar thirstIndex;
    public ProgressBar happinessIndex;
    public ProgressBar cleanlinessIndex;

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
        GameRoot.gameScene.setOnKeyPressed(
                event -> {
                    KeyCode keyCode = event.getCode();
                    try {
                            if (keyCode.equals(keyCode.D) && GameRoot.character.getTranslateX() < 780 - ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH",
                                    "IMAGES",  "Duke", ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                                            "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getDouble("WIDTH") / growth) {
                            GameRoot.character.setTranslateX(GameRoot.character.getTranslateX() + 10);
                            if ((sadTextFd.getTranslateX() + 10) < 470)
                                sadTextFd.setTranslateX(sadTextFd.getTranslateX() + 10);
                            else
                                sadTextFd.setTranslateX(470);
                        }
                        else if (keyCode.equals(keyCode.A) && GameRoot.character.getTranslateX() > 10) {
                            GameRoot.character.setTranslateX(GameRoot.character.getTranslateX() - 10);
                            if ((sadTextFd.getTranslateX() - 10) > -170)
                                sadTextFd.setTranslateX(sadTextFd.getTranslateX() - 10);
                            else
                                sadTextFd.setTranslateX(-170);
                        }
                        else if (keyCode.equals(keyCode.W)  && GameRoot.character.getTranslateY() > 80) {
                            GameRoot.character.setTranslateY(GameRoot.character.getTranslateY() - 5);
                            if ((sadTextFd.getTranslateY() - 5) > 0)
                                sadTextFd.setTranslateY(sadTextFd.getTranslateY() - 5);
                            else
                                sadTextFd.setTranslateY(0);
                        }
                        else if (keyCode.equals(keyCode.Z) && GameRoot.character.getTranslateY() < 430 - ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT",
                                    "IMAGES",  "Duke", ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                                            "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getDouble("HEIGHT") / growth) {
                            GameRoot.character.setTranslateY(GameRoot.character.getTranslateY() + 5);
                            sadTextFd.setTranslateY(sadTextFd.getTranslateY() + 5);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
        healthDec = new Decreaser(healthIndex, 0.001);
        hungerDec = new Decreaser(hungerIndex, 0.01);
        thirstDec = new Decreaser(thirstIndex, 0.03);
        happinessDec = new Decreaser(happinessIndex, 0.005);
        cleanlinessDec = new Decreaser(cleanlinessIndex, 0.001);
    }

    private void texFdset(String message) throws Exception {
        double x = GameRoot.character.getTranslateX() - 100;
        double y = GameRoot.character.getTranslateY() - 100;
        sadTextFd.setText(message);
        if (x < -170)
            sadTextFd.setTranslateX(-170);
        else if (x < 470)
            sadTextFd.setTranslateX(x);
        else
            sadTextFd.setTranslateX(470);
        if (y > 0)
            sadTextFd.setTranslateY(y);
        else
            sadTextFd.setTranslateY(0);
        sadTextFd.setVisible(true);
        GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                "IMAGES",  "Duke", "UNHAPPY_IMAGE")).getString("IMAGE_NAME"),
                "UNHAPPY_IMAGE");
        ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'UNHAPPY_IMAGE'" +
                " where LOGIN = '" + ControllerMenu.login + "'");
    }

    public void toHeal(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.8 && hungerIndex.getProgress() > 0.8 && thirstIndex.getProgress() > 0.8 &&
                cleanlinessIndex.getProgress() > 0.8) {
            sadTextFd.setVisible(false);
            healthDec.decreaser.stop();
            healthInc.increasProgress(healthIndex, healthDec.decreaser, "HEALTH_IMAGE", 0.01);
        }
        else {
            texFdset("I can't get well, I'm sad!");
        }
    }

    public void toFeed(MouseEvent mouseEvent) throws Exception {
        count += 2;
        if (happinessIndex.getProgress() > 0.25) {
            sadTextFd.setVisible(false);
            hungerDec.decreaser.stop();
            if (System.currentTimeMillis() > (GameRoot.beginTime + timeToGrowth) && growth > 0.8) {
                timeToGrowth *= 2;
                if (growth > 0.8) {
                    growth -= 0.1;
//                    System.out.println(growth);
                    ControllerMenu.datab.dbInsertUpdate("update USERS set GROWTH = " + growth +
                            " where LOGIN = '" + ControllerMenu.login + "'");
                    GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                        ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                        GameRoot.character.getTranslateX(),
                        GameRoot.character.getTranslateY());
                }
            }
//      System.out.println("hungerInc.increaser.getStatus(): " + hungerInc.increaser.getStatus());
//            System.out.println("If RUNNING: " + hungerInc.increaser.getStatus().toString().equals("RUNNING"));
//            System.out.println("If STOPPED: " + hungerInc.increaser.getStatus().toString().equals("STOPPED"));
            if (hungerInc.increaser.getStatus().toString().equals("RUNNING")) {
                System.out.println("The process is running");
            }
//            else if (hungerInc.increaser.getStatus().toString().equals("STOPPED")) {
//                System.out.println("The process is stopped");
//                hungerInc.increaser.play();
//            }
            else {
                System.out.println("The process is new");
                hungerInc.increasProgress(hungerIndex, hungerDec.decreaser,"HUNGER_IMAGE", 0.1);
            }
        }
        else {
            texFdset("I can't eat, I'm sad!");
        }
    }

    public void toDrink(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.25) {
            sadTextFd.setVisible(false);
            thirstDec.decreaser.stop();
            thirstInc.increasProgress(thirstIndex, thirstDec.decreaser,"THIRST_IMAGE", 0.3);
        }
        else {
            texFdset("I can't drink, I'm sad!");
        }
    }

    public void toPlay(MouseEvent mouseEvent) throws Exception {
        sadTextFd.setVisible(false);
//        hungerTextFd.setVisible(false);
//        thirstTextFd.setVisible(false);
//        cleanTextFd.setVisible(false);
        happinessDec.decreaser.stop();
        happinessInc.increasProgress(happinessIndex, happinessDec.decreaser,"HAPPINESS_IMAGE", 0.05);
    }

    public void toClean(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.25) {
            sadTextFd.setVisible(false);
            cleanlinessDec.decreaser.stop();
            cleanlinessInc.increasProgress(cleanlinessIndex, cleanlinessDec.decreaser,"CLEANLINESS_IMAGE", 0.01);
        }
        else {
            texFdset("I can't clean up, I'm sad!");
        }
    }

    public  void update(long beginTime, long pastTime) throws Exception {
        if (healthIndex.getProgress() < 0.2) {
            GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                    "IMAGES",  "Duke", "DYING_IMAGE")).getString("IMAGE_NAME"),
                    "DYING_IMAGE");
            ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'DYING_IMAGE'" +
                    " where LOGIN = '" + ControllerMenu.login + "'");
        }

//    if (System.currentTimeMillis() > (beginTime + timeToGrowth) && growth > 0.8) {
//        timeToGrowth *= 2;
//        if (growth > 0.8) {
//            growth--;
//            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
//                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
//                    GameRoot.character.getTranslateX(),
//                    GameRoot.character.getTranslateY());
//        }
//    }

//    if (GameRoot.character.getTranslateX() > 680) {
//            growth = 1;
//            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
//                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
//                    GameRoot.character.getTranslateX(),
//                    GameRoot.character.getTranslateY());
//        }
//        else if (GameRoot.character.getTranslateX() < 80) {
//            growth = 0.8;
//            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
//                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
//                    GameRoot.character.getTranslateX(),
//                    GameRoot.character.getTranslateY());
//        }
//        else if (GameRoot.character.getTranslateY() < 60) {
//            growth = 1.6;
//            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
//                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
//                    GameRoot.character.getTranslateX(),
//                    GameRoot.character.getTranslateY());
//        }
//        else if (GameRoot.character.getTranslateY() > 380) {
//            growth = 1.2;
//            GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
//                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
//                    GameRoot.character.getTranslateX(),
//                    GameRoot.character.getTranslateY());
//        }
    }
}
