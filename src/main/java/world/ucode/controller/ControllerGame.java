package world.ucode.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerGame {
    public ImageView duke;

    public void onTouch() {
        Image IMAGE;
//        String str = duke.getImage().getUrl();
//        if (str.equals("file:/Users/akostanda/IdeaProjects/Tamagotchi/target/classes/duke-java-logo3.png\n"))
            IMAGE = new Image("duke-java-logo2.png");
//        else IMAGE = new Image("duke-java-logo3.png");
            duke.setImage(IMAGE);
    }

//    public void onClickLG(){
//        loadGame.setText("Thanks!");
//        newGame.setText("New Game");
//        settings.setText("Settings");
//
//    }


}
