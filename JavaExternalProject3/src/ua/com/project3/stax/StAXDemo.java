package ua.com.project3.stax;

import java.io.File;

public class StAXDemo {

    public static String XML_FILE = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3"
            + File.separator + "xmlFlower" + File.separator + "greenhouse.xml";

    public static void main(String[] args) {
        GreenHouseStAXBuilder stAXBuilder = new GreenHouseStAXBuilder();
        stAXBuilder.buildSetFlowers(XML_FILE);
        System.out.println(stAXBuilder.getFlowers());
    }
}
