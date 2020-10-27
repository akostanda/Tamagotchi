package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameButton {
    private Parent root;

    public void ngMenuBuilder (Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/newGameButton.fxml"));
        Scene scene = new Scene(root, 800, 450);
        primaryStage.setScene(scene);

    }
}
