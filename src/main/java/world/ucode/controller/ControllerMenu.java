package world.ucode.controller;

import javafx.event.ActionEvent;
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
    public static String login;
    public Button exit;
    public TextField newGameLogin;
    public TextField loadGameLogin;
    public CheckBox dukeSet;
    public CheckBox simbaSet;
    public CheckBox someSet;
    public static DataBase datab = new DataBase();

    public void onClickNG() throws Exception {
        NewGameButton ngMenu = new NewGameButton();
        ngMenu.ngMenuBuilder(Main.primaryStage);
    }
    public void newLogin() throws Exception {
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
                datab.dbInsertUpdate("insert into USERS (LOGIN, CHARACTER_NAME, IMAGE_TYPE, GROWTH, X, Y, HEALTH," +
                        "HUNGER, THIRST, HAPPINESS, CLEANLINESS) " +
                        "values ('" + login + "', 'Duke', 'MAIN_IMAGE', '" + 1.4 + "', '" + 298 + "', '" + 308 + "', '" +
                         0.6 + "', '" + 0.6 + "', '" + 0.6 + "', '" + 0.6 + "', '" + 0.6 + "')");
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
            someSet.setSelected(false);
            return true;
        }
        else
            return false;
    }

    public boolean onSimbaSt(){
        if (simbaSet.isSelected()) {
            dukeSet.setSelected(false);
            someSet.setSelected(false);
            return true;
        }
        else
            return false;
    }

    public boolean onSomeSet(ActionEvent actionEvent) {
        if (someSet.isSelected()) {
            dukeSet.setSelected(false);
            simbaSet.setSelected(false);
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

