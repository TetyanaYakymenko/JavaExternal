package ua.com.vehicles;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Vehicle  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int price;
	private int speed;
	private GregorianCalendar yearOfLaunch;
	private Coordinates coordinates;

	public Vehicle() {
		this("");
	}

	public Vehicle(String name) {
		this(name, 0, 0, new GregorianCalendar(), new Coordinates());
	}

	public Vehicle(String name, int price) {
		this(name, price, 0, new GregorianCalendar(), new Coordinates());
	}

	public Vehicle(String name, int price, int speed) {
		this(name, price, speed, new GregorianCalendar(), new Coordinates());
	}

	public Vehicle(String name, int price, int speed, GregorianCalendar yearOfLaunch) {
		this(name, price, speed, yearOfLaunch, new Coordinates());
	}

	public Vehicle(String name, int price, int speed, GregorianCalendar yearOfLaunch, Coordinates coordinates) {
		super();
		this.name = name;
		this.price = price;
		this.speed = speed;
		this.yearOfLaunch = yearOfLaunch;
		this.coordinates = coordinates;
	}

	public Builder newBuilder() {
		return new Builder();
	}

	public static class Builder {

		private String name;
		private int price;
		private int speed;
		private GregorianCalendar yearOfLaunch;
		private Coordinates coordinates;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}

		public Builder setSpeed(int speed) {
			this.speed = speed;
			return this;
		}

		public Builder setYearOfLaunch(GregorianCalendar year) {
			GregorianCalendar temp = new GregorianCalendar();
			temp.setTimeInMillis(year.getTimeInMillis());
			this.yearOfLaunch = temp;
			return this;

		}

		public Builder setCoordinates(int x, int y) {
			if (coordinates == null)
				this.coordinates = new Coordinates();
			this.coordinates.setX(x);
			this.coordinates.setY(y);
			return this;

		}

		public Vehicle build() {
			return new Vehicle(this.name, this.price, this.speed, this.yearOfLaunch, this.coordinates);
		}
	}

	public Vehicle speed(int speed) {
		setSpeed(speed);
		return this;
	}

	public Vehicle newInstance() {
		Vehicle result = new Vehicle(this.getName());
		result.setPrice(this.price);
		result.setSpeed(this.speed);
		result.setCoordinates(this.getCoordinates().newInstance());
		result.setYearOfLaunch(new GregorianCalendar());
		return result;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public GregorianCalendar getYearOfLaunch() {
		return yearOfLaunch;
	}
	

	public void setYearOfLaunch(GregorianCalendar yearOfLaunch) {
		this.yearOfLaunch = yearOfLaunch;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + speed;
		result = prime * result + ((yearOfLaunch == null) ? 0 : yearOfLaunch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (speed != other.speed)
			return false;
		if (yearOfLaunch != other.yearOfLaunch)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", price=" + price + ", speed=" + speed + ", yearOfLaunch=" + yearOfLaunch.get(Calendar.YEAR)
				+ ", coordinates=" + coordinates + "]";
	}

}
