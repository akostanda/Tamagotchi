package world.ucode.controller;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import world.ucode.Main;
import world.ucode.model.DataBase;
import world.ucode.view.GameRoot;
import world.ucode.view.NewGame;
import world.ucode.view.NewGameButton;


public class ControllerMenu {

//    public ImageView background4;
    public Button newGame;
    public Button loadGame;
    public Button exit;
    public TextField newGameLogin;
    public CheckBox dukeSet;
    public CheckBox simbaSet;
    private DataBase datab = new DataBase();

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
//        System.out.println(datab.dbChecker(newGameLogin.getText()));
        if (onDukeSt() && datab.dbCreation("Duke")) {
            if (newGameLogin.getText().equals("")) {
        System.out.println("please input a name");
            }
//            else if (datab.dbChecker(newGameLogin.getText())) {
//                System.out.println("there is an user wich such login");
//            }
            else {
                NewGame ng = new NewGame();
                ng.buildNG("Duke", datab);
                GameRoot game = new GameRoot();
                game.gameBuilder(Main.primaryStage, "/dukeGame.fxml", ng.character);
                datab.dbInsertUpdate("insert into USERS (LOGIN) values ('" + newGameLogin.getText() + "')");
//                System.out.println(newGameLogin.getText());
            }

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
