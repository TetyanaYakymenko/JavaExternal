package ua.com.project1;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ua.com.project1.enums.FlowerColors;

public class Flower extends Component {
	private GregorianCalendar dayOfCut;
	private int length;
	private FlowerColors color;

	public Flower(String name, GregorianCalendar dayOfCut, BigDecimal price, FlowerColors color, int length) {
		super(name, price);
		this.setName(name);
		this.setDayOfCut(dayOfCut);
		this.setPrice(price);
		this.setColor(color);
		this.setLength(length);
	}

	public GregorianCalendar getDayOfCut() {
		return dayOfCut;
	}

	public void setDayOfCut(GregorianCalendar dayOfCut) {
		if (dayOfCut == null) {
			throw new NullPointerException("Day of cutting the flower cannot be null.");
		}
		this.dayOfCut = dayOfCut;
	}

	public int getLength() {

		return length;
	}

	public void setLength(int lenght) {
		if (lenght <= 0) {
			throw new IllegalArgumentException("Leng of flower must be greater than 0.");
		}
		this.length = lenght;
	}

	public FlowerColors getColor() {

		return color;
	}

	public void setColor(FlowerColors color) {
		if (color == null) {
			throw new NullPointerException("Color of Flower cannot be null value.");
		}
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((dayOfCut == null) ? 0 : dayOfCut.hashCode());
		result = prime * result + length;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (color != other.color)
			return false;
		if (dayOfCut == null) {
			if (other.dayOfCut != null)
				return false;
		} else if (!dayOfCut.equals(other.dayOfCut))
			return false;
		if (length != other.length)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flower [name=" + name + ", dayOfCut=" + dayOfCut.get(Calendar.DAY_OF_MONTH) + "/"
				+ dayOfCut.get(Calendar.MONTH) + "/" + dayOfCut.get(Calendar.YEAR) + ", lenght=" + length + ", price=" + price
				+ ", color=" + color + "]";
	}

}
