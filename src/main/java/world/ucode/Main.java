package world.ucode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Image IMAGE = new Image("duke-java-oracle.png");
        Parent root = FXMLLoader.load(getClass().getResource("/tamagochi.fxml"));

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("MyTamagochi");
        stage.setScene(scene);
        stage.show();
        }catch (IOException e){
      System.out.println("hghg");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//public class Main extends Application {
//    public static void main(String[] args)  {
//        launch(args);
//    }
//    @Override
//    public void start(Stage primaryStage) {
//        Image IMAGE = new Image("duke-java-oracle.png");
//        ImageView imageView = new ImageView(IMAGE);
//        imageView.setFitHeight(500);
//        imageView.setFitWidth(500);
//        Pane root = new Pane();
//        root.getChildren().add(imageView);
//        Scene scene = new Scene(root, 800, 600);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        System.out.println("GTYU");
//    }
//}