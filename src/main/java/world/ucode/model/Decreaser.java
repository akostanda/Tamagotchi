package world.ucode.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class Decreaser {
    public Timeline decreaser;
    private int decreasDuration = 300;

    public Decreaser(ProgressBar progresIndex, double value) {
        decreaser = new Timeline(
                new KeyFrame(Duration.millis(decreasDuration), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        if (progresIndex.getProgress() > value) {
                            progresIndex.setProgress(progresIndex.getProgress() - value);
//                            System.out.println(healthIndex.getProgress());
                            if (progresIndex.getProgress() < 0.35) {
                                progresIndex.setStyle("-fx-accent: #ff3f3f;");
                            }
                        }
                    }
                })
        );
        decreaser.setCycleCount(Timeline.INDEFINITE);
        decreaser.play();
    }
}
