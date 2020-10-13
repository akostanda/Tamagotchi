package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tmenu {
        private Parent root;

        public void menuBuilder (Stage primaryStage) throws Exception {
//            Image IMAGE = new Image("duke-java-oracle.png");
            root = FXMLLoader.load(getClass().getResource("/menu.fxml"));
            Scene scene = new Scene(root, 800, 450);
            primaryStage.setTitle("MyTamagochi");
            primaryStage.setScene(scene);
//            primaryStage.setResizable(false);
//            primaryStage.centerOnScreen();
        }
}
