package ua.com.project3.jaxb;

import org.xml.sax.SAXException;
import ua.com.project3.xmlgreenhouse.GreenHouse;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class UnmarshalMain {
    static String FILE_INPUT_XML = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3" +
            File.separator + "xmlFlower" + File.separator + "greenhouse.xml";
    static String FILE_XSD = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3" +
            File.separator + "xmlFlower" + File.separator + "greenhouse.xsd";

    public static void main(String[] args) {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(GreenHouse.class);
            Unmarshaller um = jc.createUnmarshaller();

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(FILE_XSD);
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            GreenHouse st =
                    (GreenHouse) um.unmarshal(new File(FILE_INPUT_XML));
            System.out.println(st);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}
