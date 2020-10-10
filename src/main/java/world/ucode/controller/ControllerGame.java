package world.ucode.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import world.ucode.Main;
import world.ucode.view.GameRoot;

public class ControllerGame {
    public ImageView duke;

    public void onTouch() {
        Image IMAGE;
//        String str = duke.getImage().getUrl();
//        if (str.equals("file:/Users/akostanda/IdeaProjects/Tamagotchi/target/classes/duke-java-logo3.png\n"))
            IMAGE = new Image("duke-java-logo2.png");
//        else IMAGE = new Image("duke-java-logo3.png");
            duke.setImage(IMAGE);
        duke.setTranslateX(duke.getTranslateX() + 10);
    }

    public void onKeyPressed() {
        GameRoot.gameScene.setOnKeyPressed(
                event -> {
                    System.out.println(duke.getTranslateX());
                    System.out.println(duke.getTranslateY());
                    System.out.println();
                    KeyCode keyCode = event.getCode();
                    if ((keyCode.equals(keyCode.RIGHT)))
                        duke.setTranslateX(duke.getTranslateX() + 10);
                    else if ((keyCode.equals(keyCode.LEFT)))
                        duke.setTranslateX(duke.getTranslateX() - 10);
                    else if ((keyCode.equals(keyCode.UP)))
                        duke.setTranslateY(duke.getTranslateY() + 5);
                    else if ((keyCode.equals(keyCode.DOWN)))
                        duke.setTranslateY(duke.getTranslateY() - 5);
                });
        }

//    public void onClickLG(){
//        loadGame.setText("Thanks!");
//        newGame.setText("New Game");
//        settings.setText("Settings");
//
//    }


}
