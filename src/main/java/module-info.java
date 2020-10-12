module Tamagotchi.main {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;
    exports world.ucode;
    exports world.ucode.controller;
//    opens javafx.base to world.ucode;

}