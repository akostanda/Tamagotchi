package world.ucode.view;

import world.ucode.controller.ControllerMenu;
import world.ucode.model.Hero;

public class NewGame {

    public Hero character;
    private double growth;

    public NewGame() throws Exception {
        growth = ControllerMenu.datab.dbFinder("select GROWTH from USERS where LOGIN = '" +
                ControllerMenu.login + "'").getDouble("GROWTH");
    }

    public void buildNG(String hero) throws Exception {
            character = new Hero(ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("IMAGE_NAME",
                        "IMAGES",  hero, "MAIN_IMAGE")).getString("IMAGE_NAME"),
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("WIDTH",
                        "IMAGES",  hero, "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestImage("HEIGHT",
                        "IMAGES",  hero, "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestCharacter("X",
                        "CHARACTERS",  hero)).getDouble("X"),
                    ControllerMenu.datab.dbFinder(ControllerMenu.datab.requestCharacter("Y",
                        "CHARACTERS",  hero)).getDouble("Y"));
    }
}
