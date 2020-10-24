package world.ucode.model;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import world.ucode.controller.ControllerGame;
import world.ucode.view.GameRoot;

public class GameOver {
    private Button gameOverNewGame;
    private Button gameOverExit;
    public GameOver(Button gameOverNewGame, Button gameOverExit) {
        this.gameOverNewGame = gameOverNewGame;
        this.gameOverExit = gameOverExit;
    }

    public void gameOver(Decreaser healthDec, Decreaser hungerDec, Decreaser thirstDec, Decreaser happinessDec,
                         Decreaser cleanlinessDec, TextField sadTextFd) {
        healthDec.decreaser.stop();
        hungerDec.decreaser.stop();
        thirstDec.decreaser.stop();
        happinessDec.decreaser.stop();
        cleanlinessDec.decreaser.stop();
        ControllerGame.healthInc.increaser.stop();
        ControllerGame.hungerInc.increaser.stop();
        ControllerGame.thirstInc.increaser.stop();
        ControllerGame.happinessInc.increaser.stop();
        ControllerGame.cleanlinessInc.increaser.stop();
        GameRoot.timer.stop();
        gameOverNewGame.setVisible(true);
        gameOverNewGame.toFront();
        gameOverExit.setVisible(true);
        gameOverExit.toFront();
    }
}
