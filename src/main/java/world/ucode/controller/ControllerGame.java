package world.ucode.controller;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.WindowEvent;
import world.ucode.Main;
import world.ucode.model.Decreaser;
import world.ucode.model.GameOver;
import world.ucode.model.Increaser;
import world.ucode.model.Sounds;
import world.ucode.view.GameRoot;
import world.ucode.view.Tmenu;

import java.net.URL;

public class ControllerGame {
    private double growth = ControllerMenu.datab.dbFinder("select GROWTH from USERS where LOGIN = '" +
            ControllerMenu.login + "'").getDouble("GROWTH");
    private MediaPlayer fonPlayer;
    private Sounds thankSnd = new Sounds("/thankSound.mp3");
    private Sounds helpSnd = new Sounds("/helpSound.mp3");
    private Sounds dethkSnd = new Sounds("/dethSound.mp3");
    private URL filePath;
    private int soundCount = 0;
    private long timeToGrowth = 3000;
    private Decreaser healthDec;
    private Decreaser hungerDec;
    private Decreaser thirstDec;
    private Decreaser happinessDec;
    private Decreaser cleanlinessDec;
    public TextField sadTextFd;
    public RadioButton soundButton;
    public Button gameOverNewGame;
    public Button gameOverExit;
    public static Increaser healthInc = new Increaser();
    public static Increaser hungerInc = new Increaser();
    public static Increaser thirstInc = new Increaser();
    public static Increaser happinessInc = new Increaser();
    public static Increaser cleanlinessInc = new Increaser();
    public ProgressBar healthIndex;
    public ProgressBar hungerIndex;
    public ProgressBar thirstIndex;
    public ProgressBar happinessIndex;
    public ProgressBar cleanlinessIndex;

    public ControllerGame() throws Exception {}

    public void initialize() throws Exception {
        healthIndex.setProgress(ControllerMenu.datab.dbFinder("select HEALTH from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("HEALTH"));
        hungerIndex.setProgress(ControllerMenu.datab.dbFinder("select HUNGER from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("HUNGER"));
        thirstIndex.setProgress(ControllerMenu.datab.dbFinder("select THIRST from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("THIRST"));
        happinessIndex.setProgress(ControllerMenu.datab.dbFinder("select HAPPINESS from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("HAPPINESS"));
        cleanlinessIndex.setProgress(ControllerMenu.datab.dbFinder("select CLEANLINESS from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("CLEANLINESS"));
    }

    public void onKeyPressed() {
        GameRoot.gameScene.setOnKeyPressed(
            event -> {
                KeyCode keyCode = event.getCode();
                try {
                    if (!gameOverNewGame.isVisible()) {
                        if (keyCode.equals(keyCode.D) && GameRoot.character.getTranslateX() < 780 - ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH",
                                "IMAGES",  "Duke", ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                                        "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getDouble("WIDTH") / growth) {
                            GameRoot.character.setTranslateX(GameRoot.character.getTranslateX() + 10);
                            if ((sadTextFd.getTranslateX() + 10) < 460)
                                sadTextFd.setTranslateX(sadTextFd.getTranslateX() + 10);
                            else
                                sadTextFd.setTranslateX(460);
                        }
                        else if (keyCode.equals(keyCode.A) && GameRoot.character.getTranslateX() > 10) {
                            GameRoot.character.setTranslateX(GameRoot.character.getTranslateX() - 10);
                            if ((sadTextFd.getTranslateX() - 10) > -170)
                                sadTextFd.setTranslateX(sadTextFd.getTranslateX() - 10);
                            else
                                sadTextFd.setTranslateX(-170);
                        }
                        else if (keyCode.equals(keyCode.W)  && GameRoot.character.getTranslateY() > 80) {
                            GameRoot.character.setTranslateY(GameRoot.character.getTranslateY() - 5);
                            if ((sadTextFd.getTranslateY() - 5) > 0)
                                sadTextFd.setTranslateY(sadTextFd.getTranslateY() - 5);
                            else
                                sadTextFd.setTranslateY(0);
                        }
                        else if (keyCode.equals(keyCode.Z) && GameRoot.character.getTranslateY() < 430 - ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT",
                                "IMAGES",  "Duke", ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                                        "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getDouble("HEIGHT") / growth) {
                            GameRoot.character.setTranslateY(GameRoot.character.getTranslateY() + 5);
                            sadTextFd.setTranslateY(sadTextFd.getTranslateY() + 5);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }

    private javafx.event.EventHandler<WindowEvent> closeEventHandler = new javafx.event.EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            try {
                ControllerMenu.datab.dbInsertUpdate("update USERS set GROWTH = " + growth + "," +
                        "X = " + GameRoot.character.getTranslateX() + "," +
                        "Y = " + GameRoot.character.getTranslateY() + "," +
                        "HEALTH = " + healthIndex.getProgress() + "," +
                        "HUNGER = " + hungerIndex.getProgress() + "," +
                        "THIRST = " + thirstIndex.getProgress() + "," +
                        "HAPPINESS = " + happinessIndex.getProgress() + "," +
                        "CLEANLINESS = " + cleanlinessIndex.getProgress() +
                        " where LOGIN = '" + ControllerMenu.login + "'");
                ControllerMenu.datab.dbClose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public javafx.event.EventHandler<WindowEvent> getCloseEventHandler(){
        return closeEventHandler;
    }

    public void indicatorsDecreaser() {
        healthDec = new Decreaser(healthIndex, 0.001);
        hungerDec = new Decreaser(hungerIndex, 0.01);
        thirstDec = new Decreaser(thirstIndex, 0.03);
        happinessDec = new Decreaser(happinessIndex, 0.005);
        cleanlinessDec = new Decreaser(cleanlinessIndex, 0.001);
    }

    private void texFdset(String message) throws Exception {
        double x = GameRoot.character.getTranslateX() - 100;
        double y = GameRoot.character.getTranslateY() - 100;
        sadTextFd.setText(message);
        if (x < -170)
            sadTextFd.setTranslateX(-170);
        else if (x < 460)
            sadTextFd.setTranslateX(x);
        else
            sadTextFd.setTranslateX(460);
        if (y > 0)
            sadTextFd.setTranslateY(y);
        else
            sadTextFd.setTranslateY(0);
        sadTextFd.setVisible(true);
        sadTextFd.toFront();
        if (!message.equals("I'm dying, please help!") && !message.equals("You're a sadist, I'm dead!")) {
            GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                    "IMAGES",  "Duke", "UNHAPPY_IMAGE")).getString("IMAGE_NAME"),
                    "UNHAPPY_IMAGE");
        }
        ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'UNHAPPY_IMAGE'" +
                " where LOGIN = '" + ControllerMenu.login + "'");
    }

    public void toHeal(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.8 && hungerIndex.getProgress() > 0.8 && thirstIndex.getProgress() > 0.8 &&
                cleanlinessIndex.getProgress() > 0.8 && !gameOverNewGame.isVisible()) {
            sadTextFd.setVisible(false);
            healthDec.decreaser.stop();
            healthInc.increasProgress(healthIndex, healthDec.decreaser, "HEALTH_IMAGE", 0.01);
        }
        else if (!gameOverNewGame.isVisible()) {
            texFdset("I can't get well, I'm sad!");
        }
    }

    public void toFeed(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.25 && !gameOverNewGame.isVisible()) {
            sadTextFd.setVisible(false);
            hungerDec.decreaser.stop();
            if (System.currentTimeMillis() > (GameRoot.beginTime + timeToGrowth) && growth > 0.5) {
                timeToGrowth *= 2;
                growth -= 0.1;
                ControllerMenu.datab.dbInsertUpdate("update USERS set GROWTH = " + growth +
                        " where LOGIN = '" + ControllerMenu.login + "'");
                GameRoot.character.resetImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH",
                        "IMAGES",  "Duke", "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                        ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT", "IMAGES",
                                "Duke", "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                        GameRoot.character.getTranslateX(),
                        GameRoot.character.getTranslateY());
            }
            if (hungerInc.increaser.getStatus().toString().equals("RUNNING")) {
            }
            else {
                hungerInc.increasProgress(hungerIndex, hungerDec.decreaser,"HUNGER_IMAGE", 0.1);
            }
        }
        else if (!gameOverNewGame.isVisible()) {
            texFdset("I can't eat, I'm sad!");
        }
    }

    public void toDrink(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.25 && !gameOverNewGame.isVisible()) {
            sadTextFd.setVisible(false);
            thirstDec.decreaser.stop();
            thirstInc.increasProgress(thirstIndex, thirstDec.decreaser,"THIRST_IMAGE", 0.3);
        }
        else if (!gameOverNewGame.isVisible()) {
            texFdset("I can't drink, I'm sad!");
        }
    }

    public void toPlay(MouseEvent mouseEvent) throws Exception {
        if (!gameOverNewGame.isVisible()) {
            sadTextFd.setVisible(false);
            happinessDec.decreaser.stop();
            happinessInc.increasProgress(happinessIndex, happinessDec.decreaser,"HAPPINESS_IMAGE", 0.05);
        }
    }

    public void toClean(MouseEvent mouseEvent) throws Exception {
        if (happinessIndex.getProgress() > 0.25 && !gameOverNewGame.isVisible()) {
            sadTextFd.setVisible(false);
            cleanlinessDec.decreaser.stop();
            cleanlinessInc.increasProgress(cleanlinessIndex, cleanlinessDec.decreaser,"CLEANLINESS_IMAGE", 0.01);
        }
        else if (!gameOverNewGame.isVisible()) {
            texFdset("I can't clean up, I'm sad!");
        }
    }

    public  void update(long beginTime, long pastTime) throws Exception {
        if (healthIndex.getProgress() < 0.2 && healthIndex.getProgress() > 0.1 && !healthInc.increaser.getStatus().toString().equals("RUNNING")) {
            GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                    "IMAGES",  "Duke", "DYING_IMAGE")).getString("IMAGE_NAME"),
                    "DYING_IMAGE");
            texFdset("I'm dying, please help!");
            ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'DYING_IMAGE'" +
                    " where LOGIN = '" + ControllerMenu.login + "'");
            if (soundButton.isSelected()) {
                fonPlayer.stop();
                 if (helpSnd.mediaPlayer.getStatus().toString().equals("READY") || dethkSnd.mediaPlayer.getStatus().toString().equals("STOPPED"))
                    helpSnd.mediaPlayer.play();
            }
        }
        else if (healthIndex.getProgress() <= 0.1 && !healthInc.increaser.getStatus().toString().equals("RUNNING")) {
            GameRoot.character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                    "IMAGES",  "Duke", "DEAD_IMAGE")).getString("IMAGE_NAME"),
                    "DEAD_IMAGE");
            GameOver endOfGame = new GameOver(gameOverNewGame, gameOverExit);
            endOfGame.gameOver(healthDec, hungerDec, thirstDec, happinessDec, cleanlinessDec, sadTextFd);
            texFdset("You're a sadist, I'm dead!");
            ControllerMenu.datab.dbInsertUpdate("update USERS set IMAGE_TYPE = 'DYING_IMAGE'" +
                    " where LOGIN = '" + ControllerMenu.login + "'");
            if (soundButton.isSelected()) {
                fonPlayer.stop();
                helpSnd.mediaPlayer.stop();
                if (dethkSnd.mediaPlayer.getStatus().toString().equals("READY") || dethkSnd.mediaPlayer.getStatus().toString().equals("STOPPED"))
                    dethkSnd.mediaPlayer.play();
            }
            ControllerMenu.datab.dbInsertUpdate("delete from USERS where LOGIN = '" + ControllerMenu.login + "'");
        }
        else {
            if (soundButton.isSelected()) {
                helpSnd.mediaPlayer.stop();
                dethkSnd.mediaPlayer.stop();
                fonPlayer.play();
            }
        }
    }

    public void onGameOverClickNG(ActionEvent actionEvent) throws Exception {
        dethkSnd.mediaPlayer.stop();
        Tmenu menu = new Tmenu();
        menu.menuBuilder(Main.primaryStage);
    }

    public void onGameOverClickEx(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onSoundClick(ActionEvent actionEvent) {
        if (soundButton.isSelected()) {
            if (!gameOverNewGame.isVisible()) {
                if (healthIndex.getProgress() < 0.3 && healthIndex.getProgress() > 0.1)
                    helpSnd.mediaPlayer.play();
                else {
                    if (soundCount % 2 == 0)
                        filePath = ControllerGame.class.getResource("/fonMuz1.mp3");
                    else
                        filePath = ControllerGame.class.getResource("/fonMuz2.mp3");
                    Media hit = new Media(filePath.toString());
                    fonPlayer = new MediaPlayer(hit);
        //            mediaPlayer.setAutoPlay(true);
                    fonPlayer.setCycleCount(Timeline.INDEFINITE);
                    fonPlayer.play();
                }
            }
            else if (healthIndex.getProgress() <= 0.1)
                dethkSnd.mediaPlayer.play();
            soundCount++;
        }
        else {
            fonPlayer.stop();
            helpSnd.mediaPlayer.stop();
            dethkSnd.mediaPlayer.stop();

        }
    }
}
