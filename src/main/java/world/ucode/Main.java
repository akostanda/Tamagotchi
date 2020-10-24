package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.view.Tmenu;

import java.io.IOException;

public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            primaryStage = stage;
            Tmenu menu = new Tmenu();
            menu.menuBuilder(primaryStage);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.show();

        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}