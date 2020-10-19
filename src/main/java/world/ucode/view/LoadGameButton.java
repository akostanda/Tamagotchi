package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoadGameButton {
    //    private Stage stage;
    private Parent root;
//    public ImageView duke;

    public void lgMenuBuilder (Stage primaryStage) throws Exception {
//            Image IMAGE = new Image("duke-java-oracle.png");
        root = FXMLLoader.load(getClass().getResource("/loadGameButton.fxml"));
        Scene scene = new Scene(root, 800, 450);
//        stage.setTitle("MyTamagochi");
        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.centerOnScreen();
//        primaryStage.show();
//        Image IMAGE = new Image("../../resources/duke-java-logo2.png");
//        duke.setImage(IMAGE);

    }
}
