module Dino.main {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
//    requires javafx.sql;
    requires javafx.fxml;
    exports world.ucode;
    opens javafx.base to world.ucode;

}