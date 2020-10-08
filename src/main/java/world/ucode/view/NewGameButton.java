package world.ucode.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameButton {
    private Stage stage;
    private Parent root;
//    public ImageView duke;

    public void ngMenuBuilder (Stage primaryStage) throws Exception {
//            Image IMAGE = new Image("duke-java-oracle.png");
        root = FXMLLoader.load(getClass().getResource("/newGameButton.fxml"));
        Scene scene = new Scene(root, 288, 144);
//        stage.setTitle("MyTamagochi");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
//        Image IMAGE = new Image("../../resources/duke-java-logo2.png");
//        duke.setImage(IMAGE);

    }
}
