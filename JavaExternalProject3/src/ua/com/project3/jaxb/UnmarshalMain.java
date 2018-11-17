package ua.com.project3.jaxb;
import ua.com.project3.xmlgreenhouse.GreenHouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshalMain {
    static String FILE_NAME_INPUT = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3"+
            File.separator + "xmlFlower" + File.separator + "greenhouse.xml";
        public static void main(String[ ] args) {
            try {
                JAXBContext jc = JAXBContext.newInstance(GreenHouse.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader(FILE_NAME_INPUT);
               GreenHouse greenHouse = (GreenHouse) u.unmarshal(reader);
                System.out.println(greenHouse);
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
