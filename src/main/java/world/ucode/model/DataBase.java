package world.ucode.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    public static Connection dbConnection;
    public static Statement dbStatement;
//    public static ResultSet dbResult;

    public boolean dbCreation(String hero) {
        try {
//            growthRate
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:DB.s3db");
            dbStatement = dbConnection.createStatement();
            dbInsertUpdate("CREATE TABLE IF NOT EXISTS 'CHARACTERS'(" +
//                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME         VARCHAR(20)    PRIMARY KEY NOT NULL," +
                    "X            DOUBLE         NOT NULL," +
                    "Y            DOUBLE         NOT NULL);");
            dbInsertUpdate("CREATE TABLE IF NOT EXISTS 'IMAGES'(" +
//                    "ID  INTEGER  PRIMARY  KEY   AUTOINCREMENT," +
                    "CHARACTER_NAME VARCHAR(20)             NOT NULL," +
                    "IMAGE_TYPE     VARCHAR(20)             NOT NULL," +
                    "IMAGE_NAME     VARCHAR(20) PRIMARY KEY NOT NULL," +
                    "WIDTH          DOUBLE                  NOT NULL," +
                    "HEIGHT         DOUBLE                  NOT NULL);");
            dbInsertUpdate("CREATE TABLE IF NOT EXISTS 'USERS'(" +
//                    "ID  INTEGER  PRIMARY  KEY   AUTOINCREMENT," +
                    "LOGIN      VARCHAR(20)             NOT NULL," +
                    "IMAGE_TYPE VARCHAR(20)             NOT NULL," +
                    "IMAGE_NAME VARCHAR(20) PRIMARY KEY NOT NULL," +
                    "WIDTH      DOUBLE                  NOT NULL," +
                    "HEIGHT     DOUBLE                  NOT NULL);");
//      System.out.println(dbFinder("select IMAGE_NAME from IMAGES where CHARACTER_NAME = 'Duke' AND IMAGE_TYPE = 'MAIN_IMAGE'").getString("IMAGE_NAME"));
            if (hero.equals("Duke")) {
                double x = 298;
                double y = 308;
                String charCommand = "insert into CHARACTERS (NAME, X, Y)" +
                "values ('" + hero + "', '" + x + "', '" + y + "')";
                try{
                dbInsertUpdate(charCommand);
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'MAIN_IMAGE', 'duke-logo2.png', 69.11, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'OK_IMAGE', 'duke-logo3.png', 104.68, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'HEALTH_IMAGE', 'duke-therapy.png', 164.38, 146.56)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'HUNGER_IMAGE', 'duke-logo5.png', 112.68, 125.63)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'THIRST_IMAGE', 'duke-logo1.png', 100.5, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'HAPPINESS_IMAGE', 'duke-logo6.png', 81.82, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'CLEANLINESS_IMAGE', 'duke-cleaning1.png', 233.58, 142.38)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'DYING_IMAGE', 'duke-dying.png', 61.49, 92.13);");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'DEAD_IMAGE', 'duke-dead.png', 92.13, 92.13);");
                }
                catch(Exception e) {
                    System.out.println(123);
                }
            }
            return true;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void dbInsertUpdate(String query) throws Exception {
            dbStatement.execute(query);
    }

    public ResultSet dbFinder(String query) throws Exception {
            return dbStatement.executeQuery(query);
    }

    public String requestImage(String strName, String tabelName, String characName, String imageName) {
        return "select " + strName + " from " + tabelName + " where CHARACTER_NAME = '" + characName + "' AND IMAGE_TYPE = '" + imageName + "'";
    }

    public String requestCharacter(String strName, String tabelName, String characName) {
        return "select " + strName + " from " + tabelName + " where NAME = '" + characName + "'";
    }

    public void dbClose() {
        try {
            dbConnection.close();
            dbStatement.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
