package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
    public Button exit;
    public TextField newGameLogin;
    public CheckBox dukeSet;
    public CheckBox simbaSet;

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
    public void newLogin() throws Exception {
//    System.out.println(onDukeSt());
        if (onDukeSt() ) {
            GameRoot game = new GameRoot();
            game.gameBuilder(Main.primaryStage, "Duke");
            //newGameLogin.getText();

        }
    }

    public boolean onDukeSt() {
        if (dukeSet.isSelected()) {
            simbaSet.setSelected(false);
            return true;
        }
        else
            return false;
    }

    public boolean onSimbaSt(){
        if (simbaSet.isSelected()) {
            dukeSet.setSelected(false);
            return true;
        }
        else
            return false;
    }

    public void onClickLG(){
        loadGame.setText("Thanks!");
        newGame.setText("New Game");
        exit.setText("Settings");

    }

    public void onClickEx(){
        System.exit(0);
    }


}


//public class ControllerMenu {
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
