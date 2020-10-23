package world.ucode.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;
import world.ucode.controller.ControllerGame;
import world.ucode.controller.ControllerMenu;
import world.ucode.view.GameRoot;

public class Increaser {
    public Timeline increaser = new Timeline();
    private int increasDuration = 500;
    private int count = 0;

    public void increasProgress(ProgressBar progresIndex, Timeline decreaser, String imageType, double value) throws Exception {
        GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                "IMAGES",  "Duke", imageType)).getString("IMAGE_NAME"),
                imageType);
        ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = '" + imageType + "'" +
                " where LOGIN = '" + ControllerMenu.login + "'");
        KeyFrame keyFrame = new KeyFrame(Duration.millis(increasDuration), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                    if (progresIndex.getProgress() < 1) {
//                        System.out.println("progresIndex1: " + progresIndex.getProgress());
                        progresIndex.setProgress(progresIndex.getProgress() + value);
                        if (progresIndex.getProgress() < 0.35) {
                            progresIndex.setStyle("-fx-accent: #ff3f3f;");
                        }
                        if (progresIndex.getProgress() > 0.35) {
                            progresIndex.setStyle("-fx-accent: lightgreen;");
                        }
                    }
                    if (progresIndex.getProgress() >= 1) {
                        try {
//                            System.out.println("fotoBefore: " + GameRoot.character.IMAGE.getUrl());
                            GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                    "IMAGES",  "Duke", "OK_IMAGE")).getString("IMAGE_NAME"),
                                    "OK_IMAGE");
//                            System.out.println("fotoAfter: " + GameRoot.character.IMAGE.getUrl());
                            count++;
                            System.out.println(count);
//                            System.out.println("progresIndex2: " + progresIndex.getProgress());
                            if (count > ControllerGame.count) {
                                count = 0;
//                                System.out.println("progresIndex3: " + progresIndex.getProgress());
//                                System.out.println(decreaser.getStatus());
//                                System.out.println(increaser.getStatus());
                                if (ControllerGame.thirstInc.increaser.getStatus().toString().equals("RUNNING") && !imageType.equals("THIRST_IMAGE")) {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                        "IMAGES",  "Duke", "THIRST_IMAGE")).getString("IMAGE_NAME"),
                                        "THIRST_IMAGE");
                                    ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'THIRST_IMAGE'" +
                                            " where LOGIN = '" + ControllerMenu.login + "'");
                                }
                                else if (ControllerGame.hungerInc.increaser.getStatus().toString().equals("RUNNING") && !imageType.equals("HUNGER_IMAGE")) {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                        "IMAGES",  "Duke", "HUNGER_IMAGE")).getString("IMAGE_NAME"),
                                        "HUNGER_IMAGE");
                                    ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'HUNGER_IMAGE'" +
                                            " where LOGIN = '" + ControllerMenu.login + "'");
                                }
                                else if (ControllerGame.happinessInc.increaser.getStatus().toString().equals("RUNNING") && !imageType.equals("HAPPINESS_IMAGE")) {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                        "IMAGES",  "Duke", "HAPPINESS_IMAGE")).getString("IMAGE_NAME"),
                                        "HAPPINESS_IMAGE");
                                    ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'HAPPINESS_IMAGE'" +
                                            " where LOGIN = '" + ControllerMenu.login + "'");
                                }
                                else if (ControllerGame.healthInc.increaser.getStatus().toString().equals("RUNNING") && !imageType.equals("HEALTH_IMAGE")) {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                        "IMAGES",  "Duke", "HEALTH_IMAGE")).getString("IMAGE_NAME"),
                                        "HEALTH_IMAGE");
                                    ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'HEALTH_IMAGE'" +
                                            " where LOGIN = '" + ControllerMenu.login + "'");
                                }
                                else if (ControllerGame.cleanlinessInc.increaser.getStatus().toString().equals("RUNNING") && !imageType.equals("CLEANLINESS_IMAGE")) {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                        "IMAGES",  "Duke", "CLEANLINESS_IMAGE")).getString("IMAGE_NAME"),
                                        "CLEANLINESS_IMAGE");
                                    ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'CLEANLINESS_IMAGE'" +
                                            " where LOGIN = '" + ControllerMenu.login + "'");
                                }
                                else {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                        "IMAGES",  "Duke", "MAIN_IMAGE")).getString("IMAGE_NAME"),
                                        "MAIN_IMAGE");
                                    ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'MAIN_IMAGE'" +
                                            " where LOGIN = '" + ControllerMenu.login + "'");
                                }
                                System.out.println("fotoAfter2: " + GameRoot.character.IMAGE.getUrl());
                                increaser.stop();
                                decreaser.play();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        );
        increaser.setCycleCount(Timeline.INDEFINITE);
        increaser.getKeyFrames().add(keyFrame);
        increaser.play();
    }
}
