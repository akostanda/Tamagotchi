package world.ucode.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    public static Connection dbConnection;
    public static Statement bdStatement;

    public boolean dbCreation(String hero) {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:DB.s3db");
            dbInsertUpdate("CREATE TABLE IF NOT EXISTS 'CHARACTERS'(" +
//                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME         VARCHAR(20)    PRIMARY KEY NOT NULL," +
                    "WIDTH        DOUBLE         NOT NULL," +
                    "HEIGHT       DOUBLE         NOT NULL," +
                    "X            DOUBLE         NOT NULL," +
                    "Y            DOUBLE         NOT NULL);");
            if (hero.equals("Duke")) {
                double n = 1.4;
                double width = 100.5 / n;
                double height = 83.75 / n;
                double x = 298;
                double y = 308;
                String command = "insert into CHARACTERS (NAME, WIDTH, HEIGHT, X, Y)" +
                "values ('" + hero + "', '" + width + "', '" + height + "', '" + x + "', '" + y + "')";
                dbInsertUpdate(command);
            }
            dbInsertUpdate("CREATE TABLE IF NOT EXISTS 'IMAGES'(" +
                    "ID  INTEGER  PRIMARY  KEY   AUTOINCREMENT," +
                    "CHARACTER_NAME    VARCHAR(20)    NOT NULL," +
                    "MAIN_IMAGE        VARCHAR(50)    NOT NULL," +
                    "OK_IMAGE          VARCHAR(50)    NOT NULL," +
                    "HEALTH_IMAGE      VARCHAR(50)    NOT NULL," +
                    "HUNGER_IMAGE      VARCHAR(50)    NOT NULL," +
                    "THIRST_IMAGE      VARCHAR(50)    NOT NULL," +
                    "HAPPINESS_IMAGE   VARCHAR(50)    NOT NULL," +
                    "CLEANLINESS_IMAGE VARCHAR(50)    NOT NULL," +
                    "DYING_IMAGE       VARCHAR(50)    NOT NULL," +
                    "DEAD_IMAGE        VARCHAR(50)    NOT NULL);");
            return true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void dbInsertUpdate(String s, String hero, double width, double height, double x, double y) {
    }

    public void dbInsertUpdate(String query) {
        try {
            bdStatement = dbConnection.createStatement();
            bdStatement.execute(query);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void dbClose() {
        try {
            dbConnection.close();
            bdStatement.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
