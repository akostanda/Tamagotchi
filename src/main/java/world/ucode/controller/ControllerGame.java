package world.ucode.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import world.ucode.Main;
import world.ucode.model.Hero;
import world.ucode.view.GameRoot;

public class ControllerGame {
    public ImageView duke;
//    static Hero character;

    public void onTouch() {
        Image IMAGE;
//        String str = duke.getImage().getUrl();
//        if (str.equals("file:/Users/akostanda/IdeaProjects/Tamagotchi/target/classes/duke-java-logo3.png\n"))
            IMAGE = new Image("duke-java-logo2.png");
//        else IMAGE = new Image("duke-java-logo3.png");
            duke.setImage(IMAGE);
        duke.setTranslateX(duke.getTranslateX() + 10);
        System.out.println(1);
    }

    public static void onKeyPressed(Hero character) {
//        this.character = character;
        System.out.println(character.getTranslateX());
        GameRoot.gameScene.setOnKeyPressed(
                event -> {
                    System.out.println(character.getTranslateX());
                    System.out.println(character.getTranslateY());
                    System.out.println();
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

//    public void onKeyPressed() {
////        this.character = character;
//        System.out.println(duke.getTranslateX());
//        GameRoot.gameScene.setOnKeyPressed(
//                event -> {
//                    System.out.println(duke.getTranslateX());
//                    System.out.println(duke.getTranslateY());
//                    System.out.println();
//                    KeyCode keyCode = event.getCode();
//                    if ((keyCode.equals(keyCode.RIGHT)))
//                        duke.setTranslateX(duke.getTranslateX() + 10);
//                    else if ((keyCode.equals(keyCode.LEFT)))
//                        duke.setTranslateX(duke.getTranslateX() - 10);
//                    else if ((keyCode.equals(keyCode.UP)))
//                        duke.setTranslateY(duke.getTranslateY() - 5);
//                    else if ((keyCode.equals(keyCode.DOWN)))
//                        duke.setTranslateY(duke.getTranslateY() + 5);
//                });
//    }

//    public void onClickLG(){
//        loadGame.setText("Thanks!");
//        newGame.setText("New Game");
//        settings.setText("Settings");
//
//    }


}
