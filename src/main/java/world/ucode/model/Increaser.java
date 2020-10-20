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
    private Timeline increaser;
    private int increasDuration = 500;
    private int count = 0;

    public void increasProgress(ProgressBar progresIndex, String imageType, double value) throws Exception {
        GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                "IMAGES",  "Duke", imageType)).getString("IMAGE_NAME"),
                imageType);
        increaser = new Timeline(
            new KeyFrame(Duration.millis(increasDuration), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent t) {
                    if (progresIndex.getProgress() < 1) {
                        progresIndex.setProgress(progresIndex.getProgress() + value);
                        System.out.println(progresIndex.getProgress());
                        if (progresIndex.getProgress() < 0.35) {
                            progresIndex.setStyle("-fx-accent: #ff3f3f;");
                        }
                        if (progresIndex.getProgress() > 0.35) {
                            progresIndex.setStyle("-fx-accent: lightgreen;");
                        }
                    }
                    if (progresIndex.getProgress() >= 1) {
                        try {
                            GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                    "IMAGES",  "Duke", "OK_IMAGE")).getString("IMAGE_NAME"),
                                    "OK_IMAGE");
                            count++;
                            System.out.println("count = " + count);
                            if (count > 2) {
                                increaser.stop();
                                if (ControllerGame.trigger) {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                            "IMAGES",  "Duke", "HEALTH_IMAGE")).getString("IMAGE_NAME"),
                                            "HEALTH_IMAGE");
                                }
                                else {
                                    GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                                            "IMAGES",  "Duke", "MAIN_IMAGE")).getString("IMAGE_NAME"),
                                            "MAIN_IMAGE");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            })
        );
        increaser.setCycleCount(Timeline.INDEFINITE);
        increaser.play();
    }
}
