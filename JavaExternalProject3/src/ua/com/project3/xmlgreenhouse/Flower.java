package ua.com.project3.xmlgreenhouse;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.EnumSet;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flower", propOrder = {
        "name",
        "soil",
        "origin",
        "visualParameters",
        "growingTips",
        "multiplyings"
})
public class Flower {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)

    @XmlElement(required = true)
    private String name;

    @XmlType(name = "soil")
    @XmlEnum
    public static enum Soil {
        @XmlEnumValue("Podsolic")
        PODSOLIC,
        @XmlEnumValue("Sod-podsolic")
        SOD_PODSOLIC,
        @XmlEnumValue("Unpaved")
        UNPAVED;

        public String value() {
            return name();
        }

        public static Soil fromValue(String v) {
            return valueOf(v);
        }
    }

    @XmlElement(name = "soil")
    private Soil soil;
    @XmlElement(required = true)
    private String origin;

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "visualParameters", propOrder = {"stemColor", "leafColor", "averageSize"})
    public static class VisualParameters {
        @XmlElement(name = "stemColor")
        private String stemColor;
        @XmlElement(name = "leafColor")
        private String leafColor;
        @XmlElement(name = "averageSize")
        private double averageSize;

        public VisualParameters() {
            super();
        }

        public VisualParameters(String stemColor, String leafColor, double averageSize) {
            this.averageSize = averageSize;
            this.leafColor = leafColor;
            this.stemColor = stemColor;
        }

        public String getStemColor() {
            return stemColor;
        }

        public void setStemColor(String stemColor) {
            this.stemColor = stemColor;
        }

        public String getLeafColor() {
            return leafColor;
        }

        public void setLeafColor(String leafColor) {
            this.leafColor = leafColor;
        }

        public double getAverageSize() {
            return averageSize;
        }

        public void setAverageSize(double averageSize) {
            this.averageSize = averageSize;
        }

        @Override
        public String toString() {
            return "VisualParameters{" +
                    "stemColor='" + stemColor + '\'' +
                    ", leafColor='" + leafColor + '\'' +
                    ", averageSize='" + averageSize + '\'' +
                    '}';
        }
    }

    @XmlElement(name = "visualParameters", required = true)
    private VisualParameters visualParameters = new VisualParameters();

    @XmlRootElement
    @XmlType(name = "growingTips", propOrder = {"temperature", "lighting", "watering"})
    public static class GrowingTips {
        private String temperature;
        private String lighting;
        private Integer watering;

        public GrowingTips() {
            super();
        }

        public GrowingTips(String temperature, String lighting, Integer watering) {
            super();
            this.lighting = lighting;
            this.temperature = temperature;
            this.watering = watering;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getLighting() {
            return lighting;
        }

        public void setLighting(String lighting) {
            this.lighting = lighting;
        }

        public Integer getWatering() {
            return watering;
        }

        public void setWatering(Integer watering) {
            this.watering = watering;
        }

        @Override
        public String toString() {
            return "GrowingTips{" +
                    "temperature=" + temperature +
                    ", lighting='" + lighting + '\'' +
                    ", watering=" + watering +
                    '}';
        }

        public String getTemprature() {
            return null;
        }
    }

    @XmlElement(name = "growingTips", required = true)
    private GrowingTips growingTips = new GrowingTips();


    @XmlElementWrapper(name = "multiplyings")
    @XmlElement(name = "multiplying")
    private EnumSet<Multiplying> multiplyings = EnumSet.noneOf(Multiplying.class);

    @XmlType
    @XmlEnum(String.class)
    @XmlAccessorType(XmlAccessType.FIELD)
    public static enum Multiplying {
        @XmlEnumValue("Cutting")
        CUTTING,
        @XmlEnumValue("Seeds")
        SEEDS,
        @XmlEnumValue("Air layouts")
        AIR_LAYOUTS,
        @XmlEnumValue("Leafs")
        LEAFS;

        public String value() {
            return name();
        }

        public static Multiplying fromValue(String v) {
            return valueOf(v);
        }
    }

    @XmlType
    @XmlEnum(String.class)
    public static enum IsGarden {
        @XmlEnumValue("yes")
        YES,
        @XmlEnumValue("no")
        NO;
    }

    @XmlID
    @XmlAttribute(name = "id", required = true)
    private String id;
    @XmlAttribute(name = "isGarden")
    private IsGarden isGarden;

    public Flower() {
    }

    public Flower(String id, IsGarden isGarden, String name, String origin, Soil soil, VisualParameters visualParameters,
                  GrowingTips growingTips, EnumSet<Multiplying> multiplyings) {
        this.id = id;
        this.isGarden = isGarden;
        this.name = name;
        this.origin = origin;
        this.soil = soil;
        this.growingTips = growingTips;
        this.visualParameters = visualParameters;
        this.multiplyings = multiplyings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public VisualParameters getVisualParameters() {
        if(visualParameters == null){
            visualParameters = new VisualParameters();
        }
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public GrowingTips getGrowingTips() {
        if(growingTips == null){
            this.growingTips = new GrowingTips();
        }
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public EnumSet<Multiplying> getMultiplyingsplying() {
        if(multiplyings == null){
            multiplyings = EnumSet.noneOf(Multiplying.class);
        }
        return multiplyings;
    }

    public void setMultyplyings(EnumSet<Multiplying> multyplyings) {
        this.multiplyings = EnumSet.copyOf(multyplyings);
    }

    public IsGarden getIsGarden() {
        return isGarden;
    }

    public void setIsGarden(IsGarden isGarden) {
        this.isGarden = isGarden;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", soil=" + soil +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters +
                ", growingTips=" + growingTips +
                ", multyplying=" + multiplyings +
                ", id=" + id +
                ", isGarden=" + isGarden +
                '}';
    }
}
