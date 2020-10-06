package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Controller {

//    public ImageView background4;
    public Button newGame;
    public Button loadGame;
    public Button settings;

    public void onClickNG(){
        String buf = newGame.getText();
        String buf2 = "New Game";
//        Boolean buf3 = (buf.equals(buf2));
//        buf3 ? newGame.setText("Thanks!") : newGame.setText("New Game");
        newGame.setText(newGame.getText().equals("New Game") ? "Thanks!" : "New Game");

//        String res = newGame.getText().equals("New Game") ?  : "False";
        loadGame.setText("Load Game");
        settings.setText("Settings");
    }
    public void onClickLG(){
        loadGame.setText("Thanks!");
        newGame.setText("New Game");
        settings.setText("Settings");

    }
    public void onClickSt(){
        settings.setText("Thanks!");
        newGame.setText("New Game");
        loadGame.setText("Load Game");
    }
}


//public class Controller {
//    @FXML
//    public Button NewGame;
//
//    @FXML
//    public void initialize(){
//        NewGame.setOnMouseClicked(e -> {
//            NewGame.setText("Thanks!");
//        });
//    }
//}
