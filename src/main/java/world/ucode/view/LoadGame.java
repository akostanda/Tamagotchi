package world.ucode.view;

import world.ucode.controller.ControllerMenu;
import world.ucode.model.Hero;

public class LoadGame {
    public Hero character;
    private double growth;

    public LoadGame() throws Exception {
        growth = ControllerMenu.datab.dbFinder("select GROWTH from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("GROWTH");
    };

    public void buildLG(String hero) throws Exception {
//        if (datab.dbCreation(hero)) {
        try {
        character = new Hero(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                "IMAGES",  hero, ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                        "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getString("IMAGE_NAME"),
                ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH",
                        "IMAGES",  hero, ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                                "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getDouble("WIDTH") / growth,
                ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT",
                        "IMAGES",  hero, ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("IMAGE_TYPE",
                                "USERS",  ControllerMenu.login)).getString("IMAGE_TYPE"))).getDouble("HEIGHT") / growth,
                ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("X",
                        "USERS",  ControllerMenu.login)).getDouble("X"),
                ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestUsers("Y",
                        "USERS",  ControllerMenu.login)).getDouble("Y"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        (ControllerMenu.datab.dbFinder("select HEALTH from USERS where LOGIN = '" +
//                ControllerMenu.login + "'").getDouble("HEALTH"));
    }
}
