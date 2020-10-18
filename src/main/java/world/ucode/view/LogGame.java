package world.ucode.view;

import world.ucode.model.DataBase;
import world.ucode.model.Hero;

public class LogGame {
    public Hero character;
    double growth = 1.4;

    public void buildNG(String hero, DataBase datab) throws Exception {
//        if (datab.dbCreation(hero)) {
        character = new Hero(datab.dbFinder(datab.requestImage("IMAGE_NAME", "IMAGES",  hero,
                "MAIN_IMAGE")).getString("IMAGE_NAME"),
                datab.dbFinder(datab.requestImage("WIDTH", "IMAGES",  hero,
                        "MAIN_IMAGE")).getDouble("WIDTH") / growth,
                datab.dbFinder(datab.requestImage("HEIGHT", "IMAGES",  hero,
                        "MAIN_IMAGE")).getDouble("HEIGHT") / growth,
                datab.dbFinder(datab.requestCharacter("X", "CHARACTERS",  hero)).getDouble("X"),
                datab.dbFinder(datab.requestCharacter("Y", "CHARACTERS",  hero)).getDouble("Y"));
//        }
    }
}
