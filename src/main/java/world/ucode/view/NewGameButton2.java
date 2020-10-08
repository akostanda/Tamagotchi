package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameButton2 {
    private Parent root;
    public void ngMenuBuilder (Stage stage) throws Exception {
//            Image IMAGE = new Image("duke-java-oracle.png");
        root = FXMLLoader.load(getClass().getResource("/newGameButton.fxml"));
        Scene scene = new Scene(root, 290, 160);
//        stage.setTitle("MyTamagochi");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
//        stage.show();
//        Image IMAGE = new Image("../../resources/duke-java-logo2.png");
//        duke.setImage(IMAGE);

    }
}
