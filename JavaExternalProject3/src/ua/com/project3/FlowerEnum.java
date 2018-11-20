package ua.com.project3;

public enum FlowerEnum {
    GREENHOUSE("greenhouse"),
    FLOWER("flower"),
    ID("id"),
    GROWINGTIPS("growingTips"),
    VISUALPARAMETERS("visualParameters"),
    ISGARDEN("isGarden"),
    NAME("name"),
    SOIL("soil"),
    ORIGIN("origin"),
    MULTIPLYING("multiplying"),
    TEMPERATURE("temperature"),
    LIGHTING("lighting"),
    WATERING("watering"),
    STEMCOLOR("stemColor"),
    AVERAGESIZE("averageSize"),
    LEAFCOLOR("leafColor");

    private String value;

    FlowerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
