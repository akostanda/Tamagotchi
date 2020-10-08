package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import world.ucode.Main;
import world.ucode.view.GameRoot;
import world.ucode.view.NewGameButton;


public class ControllerMenu {

//    public ImageView background4;
    public Button newGame;
    public Button loadGame;
    public Button settings;

    public void onClickNG() throws Exception {
//        GameRoot game = new GameRoot();
//        game.gameBuilder(Main.primaryStage);
        NewGameButton ngMenu = new NewGameButton();
        ngMenu.ngMenuBuilder(Main.primaryStage);
//        ngMenu.ngMenuBuilder();
//        newGame.setText(newGame.getText().equals("New Game") ? "Thanks!" : "New Game");
//        loadGame.setText("Load Game");
//        settings.setText("Settings");
    }
    public void onClickLG(){
        loadGame.setText("Thanks!");
        newGame.setText("New Game");
        settings.setText("Settings");

    }
    public void onClickEx(){
        System.exit(0);
    }
    public void newLogin(){
        System.exit(0);
    }
    public void onClicSt(){
        System.exit(0);
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
