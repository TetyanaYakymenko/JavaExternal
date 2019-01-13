package ua.com.finalProject.persistence.entities;

import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class Conference extends Entity {

    private String name;
    private GregorianCalendar date;
    private String place;

    public Conference() {
        super();
    }

    public Conference(int id, String name, GregorianCalendar date, String place) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        Conference other = (Conference) o;
        if (name == null) {
            if (other.getName() != null)
                return false;
        } else if (!name.equals(other.getName()))
            return false;
        if (date == null) {
            if (other.getDate() != null)
                return false;
        } else if (!date.equals(other.getDate()))
            return false;
        if (place == null) {
            if (other.getPlace() != null)
                return false;
        } else if (!place.equals(other.getPlace())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
        return result;
    }


@Override
    public String toString() {
    /*Stream.Builder<String> builder = Stream.builder().;
    Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();*/
        final StringBuffer sb = new StringBuffer("Conferece[");
        sb.append("id=").append(id).append("\n");
        sb.append("name=").append(name).append("\n");
        sb.append("date=").append(date).append("\n");
        sb.append("place='").append(place).append("\n");
        sb.append("]");
        return sb.toString();
    }
}
