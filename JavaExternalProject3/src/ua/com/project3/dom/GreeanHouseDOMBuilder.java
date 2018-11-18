package ua.com.project3.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.com.project3.xmlgreenhouse.Flower;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GreeanHouseDOMBuilder {
    private Set<Flower> flowers;

    private DocumentBuilder docBuilder;

    public GreeanHouseDOMBuilder() {
        this.flowers = new HashSet<Flower>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void buildSetStudents(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList flowersList = root.getElementsByTagName("flower");
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Flower buildFlower(Element flowerElement) {
        Flower flower = new Flower();
        flower.setId(flowerElement.getAttribute("id"));
        Flower.IsGarden isGarden = Flower.IsGarden.valueOf(flowerElement.getAttribute("isGarden").toUpperCase());
        flower.setIsGarden(isGarden);
        flower.setName(getElementTextContent(flowerElement, "name"));
        Flower.Soil soil = Flower.Soil.valueOf(getElementTextContent(flowerElement, "soil").toUpperCase().replace("-","_"));
        flower.setSoil(soil);
        flower.setOrigin(getElementTextContent(flowerElement, "origin"));

        Flower.VisualParameters visualParameters = new Flower.VisualParameters();
        Element visualParametersElement = (Element) flowerElement.getElementsByTagName("visualParameters").item(0);
        visualParameters.setStemColor(getElementTextContent(visualParametersElement, "stemColor"));
        visualParameters.setLeafColor(getElementTextContent(visualParametersElement, "leafColor"));
        Double averageSize = Double.valueOf(getElementTextContent(visualParametersElement, "averageSize").trim());
        visualParameters.setAverageSize(averageSize);
        flower.setVisualParameters(visualParameters);
        Flower.GrowingTips growingTips = new Flower.GrowingTips();

        Element growingTipsElement = (Element) flowerElement.getElementsByTagName("growingTips").item(0);
        growingTips.setTemperature(getElementTextContent(growingTipsElement, "temperature"));
        growingTips.setLighting(getElementTextContent(growingTipsElement, "lighting"));
        Integer watering = Integer.valueOf(getElementTextContent(growingTipsElement, "watering"));
        growingTips.setWatering(watering);
        flower.setGrowingTips(growingTips);


        NodeList multiplyingElements = flowerElement.getElementsByTagName("multiplying");
        int size = multiplyingElements.getLength();
        EnumSet<Flower.Multiplying> multiplyings = EnumSet.noneOf(Flower.Multiplying.class);
        Flower.Multiplying mults;
       for(int i = 0; i < size; i++) {
            mults = Flower.Multiplying.valueOf(multiplyingElements.item(i).getTextContent().toUpperCase());
            multiplyings.add(mults);
        }
        flower.setMultyplyings(multiplyings);

        return flower;
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
