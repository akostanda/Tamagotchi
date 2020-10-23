package world.ucode.controller;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import world.ucode.Main;
import world.ucode.model.DataBase;
import world.ucode.view.GameRoot;
import world.ucode.view.LoadGame;
import world.ucode.view.NewGame;
import world.ucode.view.NewGameButton;
import world.ucode.view.LoadGameButton;


public class ControllerMenu {
//    public ImageView background4;
    public static String login;
//    public Button newGame;
//    public Button loadGame;
    public Button exit;
    public TextField newGameLogin;
    public TextField loadGameLogin;
    public CheckBox dukeSet;
    public CheckBox simbaSet;
    public static DataBase datab = new DataBase();

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
        if (onDukeSt() && datab.isConnected) {
            datab.dbCreation("Duke");
            login = newGameLogin.getText();
            if (login.equals("") || login.equals("please input a name")) {
                newGameLogin.setText("Please input a name");
                newGameLogin.selectAll();
            }
            else if (datab.dbChecker("select LOGIN from USERS", login, "LOGIN") || login.equals("Such user already exists")) {
                newGameLogin.setText("Such user already exists");
                newGameLogin.selectAll();
            }
            else {
                datab.dbInsertUpdate("insert into USERS (LOGIN, CHARACTER_NAME, IMAGE_TYPE, GROWTH, HEALTH, HUNGER, THIRST, HAPPINESS, CLEANLINESS) " +
                        "values ('" + login + "', 'Duke', 'MAIN_IMAGE', '" + 1.4 + "', '" + 0.6 + "', '" + 0.6 + "', '" + 0.6 + "', '" + 0.6 + "', '" + 0.6 + "')");
                NewGame ng = new NewGame();
                ng.buildNG("Duke");
                GameRoot game = new GameRoot(ng.character);
                game.gameBuilder(Main.primaryStage, "/dukeGame.fxml");
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

    public void onClickLG() throws Exception {
        LoadGameButton lgMenu = new LoadGameButton();
        lgMenu.lgMenuBuilder(Main.primaryStage);

    }

    public void yourLogin() throws Exception {
        login = loadGameLogin.getText();
        if (!datab.dbChecker("select LOGIN from USERS", login, "LOGIN")) {
            loadGameLogin.setText("This user is not exists");
        }
        else {
            LoadGame lg = new LoadGame();
            lg.buildLG("Duke");
            GameRoot game = new GameRoot(lg.character);
            game.gameBuilder(Main.primaryStage, "/dukeGame.fxml");
            loadGameLogin.selectAll();
        }
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
