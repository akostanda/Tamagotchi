package world.ucode.model;

import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class Sounds {
    private URL filePath;
    public MediaPlayer mediaPlayer;

    public Sounds(String mp3file) {
        filePath = Sounds.class.getResource(mp3file);
        Media hit = new Media(filePath.toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(Timeline.INDEFINITE);
    }
}
