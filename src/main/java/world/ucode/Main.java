package world.ucode;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.view.Tmenu;

public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
//        try {
            primaryStage = stage;
            Tmenu menu = new Tmenu();
            menu.menuBuilder(primaryStage);
//            Image IMAGE = new Image("duke-java-oracle.png");
//        Parent root = FXMLLoader.load(getClass().getResource("/menu.fxml"));
//
//        Scene scene = new Scene(root, 800, 450);
//
//        stage.setTitle("MyTamagochi");
//        stage.setScene(scene);
//        ControllerMenu cont = new ControllerMenu();
//        cont.initialize();
            primaryStage.show();

//        } catch (IOException e){
//          e.printStackTrace();
//        }
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