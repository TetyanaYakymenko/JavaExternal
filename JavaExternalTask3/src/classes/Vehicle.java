package classes;

import java.util.Date;

public class Vehicle {

	private String name;
	private int price;
	private int speed;
	private int yearOfLaunch;
	private Coordinates coordinates;

	public Vehicle(String name) {
		this(name, 0, 0, 2000, new Coordinates());
	}

	public Vehicle(String name, int price) {
		this(name, price, 0, 2000, new Coordinates());
	}

	public Vehicle(String name, int price, int speed) {
		this(name, price, speed, 2000, new Coordinates());
	}

	public Vehicle(String name, int price, int speed, int yearOfLaunch) {
		this(name, price, speed, yearOfLaunch, new Coordinates());
	}

	public Vehicle(String name, int price, int speed, int yearOfLaunch, Coordinates coordinates) {
		super();
		this.name = name;
		this.price = price;
		this.speed = speed;
		this.yearOfLaunch = yearOfLaunch;
		this.coordinates = coordinates;
	}

	public Vehicle price(int price) {
		setPrice(price);
		return this;
	}

	public Vehicle speed(int speed) {
		setSpeed(speed);
		return this;
	}

	public Vehicle yearOfLaunch(int date) {
		setYearOfLaunch(date);
		return this;
	}

	public Vehicle coordinates(Coordinates coordinates) {
		setCoordinates(coordinates);
		return this;
	}

	public Vehicle newInstance() {
		Vehicle result = new Vehicle(this.getName());
		result.setPrice(this.price);
		result.setSpeed(this.speed);
		result.setCoordinates(this.getCoordinates().newInstance());
		result.setYearOfLaunch(2000);
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

	public int getYearOfLaunch() {
		return yearOfLaunch;
	}

	public void setYearOfLaunch(int yearOfaLaunch) {
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
		result = prime * result + yearOfLaunch;
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
		return "Vehicle [name=" + name + ", price=" + price + ", speed=" + speed + ", yearOfLaunch=" + yearOfLaunch
				+ ", coordinates=" + coordinates + "]";
	}

}
