package ua.com.project3.jaxb;

import ua.com.project3.xmlgreenhouse.Flower;
import ua.com.project3.xmlgreenhouse.GreenHouse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.EnumSet;


public class MarshalMain {

    static String  FILE_NAME_OUTPUT = "src" + File.separator + "ua" + File.separator + "com" + File.separator + "project3"+
            File.separator + "files" + File.separator + "output.xml";
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(GreenHouse.class);
            Marshaller m = null;
            m = context.createMarshaller();

            GreenHouse greenHouse = new GreenHouse();

                Flower.VisualParameters visualParameters = new Flower.VisualParameters("green","green", 1.5);
                Flower.IsGarden isGarden = Flower.IsGarden.YES;
                Flower.GrowingTips growingTips = new Flower.GrowingTips("20-22", "well lit", new Integer(700));
                Flower.Multiplying cutting = Flower.Multiplying.CUTTING;
                Flower.Multiplying seeds = Flower.Multiplying.SEEDS;
                EnumSet<Flower.Multiplying> mults = EnumSet.of(cutting,seeds);

                Flower flower = new Flower("1", isGarden,"Gibiscus", "Southeast_Asia", Flower.Soil.PODSOLIC,
                        visualParameters, growingTips, mults);

                Flower.VisualParameters visualParameters2 = new Flower.VisualParameters("green",
                        "light green", 2);
                Flower.IsGarden isGarden2 = Flower.IsGarden.NO;
                Flower.GrowingTips growingTips2 = new Flower.GrowingTips("18-20", "well lit", 500);
                Flower.Multiplying cutting2 = Flower.Multiplying.CUTTING;
                Flower.Multiplying seeds2 = Flower.Multiplying.SEEDS;
                Flower.Multiplying allLayouts = Flower.Multiplying.AIR_LAYOUTS;
                EnumSet<Flower.Multiplying> mults2 = EnumSet.of(cutting,seeds,allLayouts);

                Flower flower2 = new Flower("2",isGarden2, "Schefflera", "Tropics", Flower.Soil.SOD_PODSOLIC,
                        visualParameters, growingTips, mults);

               greenHouse.add(flower);
               greenHouse.add(flower2);
            m.marshal(greenHouse, new FileOutputStream(FILE_NAME_OUTPUT));
            m.marshal(greenHouse, System.out);
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}

  /*
    public class MarshalMain {
        public static void main(String[] args) {
            try {
                JAXBContext context = JAXBContext.newInstance(Students.class);
                Marshaller m = context.createMarshaller();
                Students st = new Students() { // анонимный класс
                    {
                        // добавление первого студента
                        Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
                        Student s = new Student("gochette", "Klimenko", "mmf", 2095306, addr);
                        this.add(s);
                        // добавление второго студента
                        addr = new Student.Address("BLR", "Polotesk", "Simeona P. 23");
                        s = new Student("ivette", "Teran", "mmf", 2345386, addr);
                        this.add(s);
                    }
                     };
m.marshal(st, new FileOutputStream("data/studs_marsh.xml"));
m.marshal(st, System.out); // копия на консоль
 System.out.println("XML-файл создан");

}
                    */

