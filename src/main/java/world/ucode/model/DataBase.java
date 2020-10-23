package world.ucode.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    public boolean isConnected = false;
    public Connection dbConnection;
    public Statement dbStatement;
    public ResultSet dbResult;
//    public String hero;

    public DataBase() {
        try {
//            this.hero = hero;
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
                    "LOGIN          VARCHAR(20) NOT NULL," +
                    "CHARACTER_NAME VARCHAR(20) NOT NULL," +
                    "IMAGE_TYPE     VARCHAR(20) NOT NULL," +
                    "GROWTH         DOUBLE      NOT  NULL," +
                    "X              DOUBLE," +
                    "Y              DOUBLE," +
                    "HEALTH         DOUBLE NOT  NULL," +
                    "HUNGER         DOUBLE NOT  NULL," +
                    "THIRST         DOUBLE NOT  NULL," +
                    "HAPPINESS      DOUBLE NOT  NULL," +
                    "CLEANLINESS    DOUBLE NOT  NULL);");
            isConnected = true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void dbCreation(String hero) {
        try {
//      System.out.println(dbFinder("select IMAGE_NAME from IMAGES where CHARACTER_NAME = 'Duke' AND IMAGE_TYPE = 'MAIN_IMAGE'").getString("IMAGE_NAME"));
            if (hero.equals("Duke") && !dbChecker("select NAME from CHARACTERS", "Duke", "NAME")) {
                double x = 298;
                double y = 308;
//                String charCommand = "insert into CHARACTERS (NAME, X, Y)" +
//                                     "values ('" + hero + "', '" + x + "', '" + y + "')";
//                String charCommand2 = "insert into USERS (LOGIN, WIDTH, HEIGHT, X, Y)" +
//                        "values ('" + "hero" + "', '" + 69.11 + "', '" + 83.75 + "', '" + x + "', '" + y + "')";
//                System.out.println(dbFinder("select WIDTH from USERS where LOGIN = 'hero'").getDouble("WIDTH"));
                dbInsertUpdate("insert into CHARACTERS (NAME, X, Y)" +
                        "values ('" + hero + "', '" + x + "', '" + y + "')");
//                dbInsertUpdate(charCommand2);
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'MAIN_IMAGE', 'duke-logo2.png', 69.11, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'OK_IMAGE', 'duke-logo3.png', 104.68, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'HEALTH_IMAGE', 'duke-therapy.png', 197.26, 175.87)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'HUNGER_IMAGE', 'duke-logo5.png', 112.68, 125.63)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'THIRST_IMAGE', 'duke-logo1.png', 110.55, 92.13)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'HAPPINESS_IMAGE', 'duke-playing-gitar.png', 102.23, 92.13)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'UNHAPPY_IMAGE', 'duke-logo6.png', 81.82, 83.75)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'CLEANLINESS_IMAGE', 'duke-cleaning1.png', 233.58, 142.38)");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'DYING_IMAGE', 'duke-dying.png', 61.49, 92.13);");
                dbInsertUpdate("insert into IMAGES (CHARACTER_NAME, IMAGE_TYPE, IMAGE_NAME, WIDTH, HEIGHT) " +
                        "values ('" + hero + "', 'DEAD_IMAGE', 'duke-dead.png', 92.13, 92.13);");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void dbInsertUpdate(String query) throws Exception {
            dbStatement.execute(query);
    }

    public ResultSet dbFinder(String query) throws Exception {
            return dbStatement.executeQuery(query);
    }

    public boolean dbChecker(String query, String login, String columnName) throws Exception {
        dbResult = dbStatement.executeQuery(query);
//        System.out.println(dbResult.getString("LOGIN"));
        while(dbResult.next()) {
            if (login.equals(dbResult.getString(columnName)))
                return true;
        }
        return false;
    }

    public String requestImage(String strName, String tabelName, String characName, String imageName) {
        return "select " + strName + " from " + tabelName + " where CHARACTER_NAME = '" + characName + "' AND IMAGE_TYPE = '" + imageName + "'";
    }

    public String requestCharacter(String strName, String tabelName, String characName) {
        return "select " + strName + " from " + tabelName + " where NAME = '" + characName + "'";
    }

    public String requestUsers(String strName, String tabelName, String userName) {
        return "select " + strName + " from " + tabelName + " where LOGIN = '" + userName + "'";
    }

    public void dbClose() {
        try {
            dbResult.close();
            dbStatement.close();
            dbConnection.close();
            isConnected = false;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
