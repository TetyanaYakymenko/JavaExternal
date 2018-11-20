package ua.com.project3.stax;

import ua.com.project3.FlowerEnum;
import ua.com.project3.xmlgreenhouse.Flower;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GreenHouseStAXBuilder {
    private HashSet<Flower> flowers = new HashSet<Flower>();
    private XMLInputFactory inputFactory;

    public GreenHouseStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void buildSetFlowers(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.FLOWER) {
                        Flower flower = buildFlower(reader);
                        flowers.add(flower);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Flower buildFlower(XMLStreamReader reader) throws XMLStreamException {
        Flower flower = new Flower();
        flower.setId(reader.getAttributeValue(null, FlowerEnum.ID.getValue()));
        String isGardenName = reader.getAttributeValue(null, FlowerEnum.ISGARDEN.getValue());
        flower.setIsGarden(Flower.IsGarden.valueOf(isGardenName.toUpperCase()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            flower.setName(getXMLText(reader));
                            break;
                        case ORIGIN:
                            flower.setOrigin(getXMLText(reader));
                            break;
                        case SOIL:
                            String soilName = getXMLText(reader).replace("-", "_");
                            flower.setSoil(Flower.Soil.valueOf(soilName.toUpperCase()));
                            break;
                        case VISUALPARAMETERS:
                            flower.setVisualParameters(buildVisualParameters(reader));
                            break;
                        case GROWINGTIPS:
                            flower.setGrowingTips(buildGrowingTips(reader));
                            break;
                        case MULTIPLYING:
                            String Multname = getXMLText(reader);
                            Flower.Multiplying multiplyingName = Flower.Multiplying.valueOf(Multname.toUpperCase());
                            flower.getMultiplyingsplying().add(multiplyingName);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.FLOWER) {
                        return flower;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Flower");
    }

    private Flower.VisualParameters buildVisualParameters(XMLStreamReader reader) throws XMLStreamException {
        Flower.VisualParameters visualParameters = new Flower.VisualParameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case STEMCOLOR:
                            visualParameters.setStemColor(getXMLText(reader));
                            break;
                        case LEAFCOLOR:
                            visualParameters.setLeafColor(getXMLText(reader));
                            break;
                        case AVERAGESIZE:
                            visualParameters.setAverageSize(Double.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.VISUALPARAMETERS) {
                        return visualParameters;
                    }
                    break;
            }

        }

        throw new XMLStreamException("Unknown element in tag VisualParamenters");

    }

    private Flower.GrowingTips buildGrowingTips(XMLStreamReader reader) throws XMLStreamException {
        Flower.GrowingTips growingTips = new Flower.GrowingTips();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case TEMPERATURE:
                            growingTips.setTemperature(getXMLText(reader));
                            break;
                        case LIGHTING:
                            growingTips.setLighting(getXMLText(reader));
                            break;
                        case WATERING:
                            growingTips.setWatering(Integer.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.GROWINGTIPS) {
                        return growingTips;
                    }
                    break;
            }

        }

        throw new XMLStreamException("Unknown element in tag GrowingTips");

    }

}
