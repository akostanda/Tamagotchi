package world.ucode.model;

public class Decreaser {



//    public void decreasProgress(MouseEvent mouseEvent) throws Exception {
//        //        double tMoment = System.currentTimeMillis();

//        character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
//                "IMAGES",  "Duke", "HEALTH_IMAGE")).getString("IMAGE_NAME"),
//                "HEALTH_IMAGE");
//        decreaser.stop();
//        increaser = new Timeline(
//                new KeyFrame(Duration.millis(increasDuration), new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent t) {
//                        if (healthIndex.getProgress() < 1) {
//                            healthIndex.setProgress(healthIndex.getProgress() + 0.01);
//                            System.out.println(healthIndex.getProgress());
//                            if (healthIndex.getProgress() < 0.35) {
//                                healthIndex.setStyle("-fx-accent: #ff3f3f;");
//                            }
//                            if (healthIndex.getProgress() > 0.35) {
//                                healthIndex.setStyle("-fx-accent: lightgreen;");
//                            }
//                        }
//                        if (healthIndex.getProgress() >= 1) {
//                            try {
//                                character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
//                                        "IMAGES",  "Duke", "OK_IMAGE")).getString("IMAGE_NAME"),
//                                        "OK_IMAGE");
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            count++;
//                            System.out.println("count = " + count);
//                            if (count > 10) {
//                                increaser.stop();
//                                try {
//                                    character.changeImage(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
//                                            "IMAGES",  "Duke", "MAIN_IMAGE")).getString("IMAGE_NAME"),
//                                            "MAIN_IMAGE");
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                                count = 0;
//                                decreaser.play();
//                            }
//                        }
//                    }
//                })
//        );
//        increaser.setCycleCount(Timeline.INDEFINITE);
//        increaser.play();
//    }
}
