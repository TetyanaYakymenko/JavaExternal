package ua.com.project3.sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import ua.com.project3.xmlgreenhouse.Flower;

import java.io.IOException;
import java.util.Set;

public class GreenHouseSAXBuilder {
    private Set<Flower> flowers;
    private GreenHouseHandler greenHouseHandler;
    private XMLReader reader;

    public GreenHouseSAXBuilder() {
        greenHouseHandler = new GreenHouseHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void buildSetFlowers(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        flowers = greenHouseHandler.getFlowers();
    }

}
