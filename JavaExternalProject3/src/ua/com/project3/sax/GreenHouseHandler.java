package ua.com.project3.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import ua.com.project3.FlowerEnum;
import ua.com.project3.xmlgreenhouse.Flower;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GreenHouseHandler extends DefaultHandler {

    private Set<Flower> flowers;
    private Flower currentFlower = null;
    private FlowerEnum currentEnum = null;
    private EnumSet<FlowerEnum> withText;

    public GreenHouseHandler() {
        flowers = new HashSet<Flower>();
        withText = EnumSet.range(FlowerEnum.NAME, FlowerEnum.LEAFCOLOR);
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (FlowerEnum.FLOWER.getValue().equals(localName)) {
            currentFlower = new Flower();
            currentFlower.setId(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                currentFlower.setIsGarden(Flower.IsGarden.valueOf(attrs.getValue(1).toUpperCase()));
            }
        } else {
            FlowerEnum temp = FlowerEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (FlowerEnum.FLOWER.getValue().equals(localName)) {
            flowers.add(currentFlower);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {

                case NAME:
                    currentFlower.setName(s);
                    break;
                case ORIGIN:
                    currentFlower.setOrigin(s);
                    break;
                case SOIL:
                    currentFlower.setSoil(Flower.Soil.valueOf(s.toUpperCase().replace("-", "_")));
                    break;
                case STEMCOLOR:
                    currentFlower.getVisualParameters().setStemColor(s);
                    break;
                case LEAFCOLOR:
                    currentFlower.getVisualParameters().setLeafColor(s);
                    break;
                case AVERAGESIZE:
                    currentFlower.getVisualParameters().setAverageSize(Double.valueOf(s));
                    break;
                case TEMPERATURE:
                    currentFlower.getGrowingTips().setTemperature(s);
                    break;
                case LIGHTING:
                    currentFlower.getGrowingTips().setLighting(s);
                    break;
                case WATERING:
                    currentFlower.getGrowingTips().setWatering(Integer.valueOf(s));
                    break;
                case MULTIPLYING:
                    currentFlower.getMultiplyingsplying().add(Flower.Multiplying.valueOf(s.toUpperCase()));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

}
