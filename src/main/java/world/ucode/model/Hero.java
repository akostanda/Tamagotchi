package world.ucode.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import world.ucode.controller.ControllerMenu;

import java.util.Deque;
import java.util.LinkedList;

public class Hero extends Pane {
    static Deque<Image> images = new LinkedList<Image>();
    private Image IMAGE;
    private ImageView imageView;

    public Hero(String imageUral, double width, double height, double x, double y) {
        IMAGE = new Image(imageUral);
//    System.out.println(IMAGE.getWidth());
//    System.out.println(IMAGE.getHeight());
//    System.out.println();

        imageView = new ImageView(IMAGE);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.getChildren().add(imageView);
    }
    public void resetImage(double width, double height, double x, double y) {
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        this.setTranslateX(x);
        this.setTranslateY(y);
//        this.getChildren().add(imageView);

    }

    public void changeImage(String imageUral, String imageType) throws Exception {
        double growth = ControllerMenu.datab.dbFinder("select GROWTH from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("GROWTH");
        this.getChildren().remove(imageView);
        IMAGE = new Image(imageUral);
        imageView = new ImageView(IMAGE);
        imageView.setFitWidth(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH",
                "IMAGES",  "Duke", imageType)).getDouble("WIDTH") / growth);
        imageView.setFitHeight(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT",
                "IMAGES",  "Duke", imageType)).getDouble("HEIGHT") / growth);
//        this.setTranslateX(x);
//        this.setTranslateY(y);
        this.getChildren().add(imageView);
    }
}
