package ua.com.project3.sax;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
public class SAXDemo {
    public static String XML_FILE = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3"
            + File.separator + "xmlFlower" + File.separator + "greenhouse.xml";

    public static void main(String[ ] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            GreenHouseHandler handler = new GreenHouseHandler();
            reader.setContentHandler(handler);
            reader.parse(XML_FILE);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}
