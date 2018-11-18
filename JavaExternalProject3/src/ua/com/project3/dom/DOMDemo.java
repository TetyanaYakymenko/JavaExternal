package ua.com.project3.dom;

import org.w3c.dom.DOMException;

import java.io.File;
import java.io.FileNotFoundException;

public class DOMDemo {
    public static String XML_FILE = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3"
            + File.separator + "xmlFlower" + File.separator + "greenhouse.xml";

    public static void main(String[ ] args) {
        try {
            GreeanHouseDOMBuilder domBuilder = new GreeanHouseDOMBuilder();
            domBuilder.buildSetStudents(XML_FILE);
            System.out.println(domBuilder.getFlowers());
        } catch (DOMException e) {
            System.err.print("ошибка DOM парсера " + e);
        }
    }
}
