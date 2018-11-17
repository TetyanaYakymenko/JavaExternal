package ua.com.project3.xmlgreenhouse;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class GreenHouse {

    @XmlElement(name = "flower")
    private List<Flower> flowersList = new ArrayList<Flower>();

    public GreenHouse() {
        super();
    }


    public void setFlowersList(ArrayList<Flower> flowers) {
        this.flowersList = flowers;
    }

    public boolean add(Flower flower) {
        return flowersList.add(flower);
    }

    @Override
    public String toString() {
        return "GreenHouse{" +
                "flowers=" + flowersList +
                '}';
    }
}
