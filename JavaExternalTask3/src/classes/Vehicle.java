package classes;

import java.util.Date;

public class Vehicle {

	private String name;
	private int price;
	private int speed;
	private Date yearOfLunch;
	private Coordinates coordinates;

	public Vehicle(String name) {
		this(name, 0, 0, new Date(), new Coordinates());
	}

	public Vehicle(String name, int price) {
		this(name, price, 0, new Date(), new Coordinates());
	}

	public Vehicle(String name, int price, int speed) {
		this(name, price, speed, new Date(), new Coordinates());
	}

	public Vehicle(String name, int price, int speed, Date yearOfLunch) {
		this(name, price, speed, yearOfLunch, new Coordinates());
	}

	public Vehicle(String name, int price, int speed, Date yearOfLunch, Coordinates coordinates) {
		super();
		this.name = name;
		this.price = price;
		this.speed = speed;
		this.yearOfLunch = yearOfLunch;
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

	public Vehicle yearOfLunch(Date date) {
		setYearOfLunch(date);
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
		Date newYearOfLunch = (Date) this.yearOfLunch.clone();
		result.setYearOfLunch(newYearOfLunch);
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

	public Date getYearOfLunch() {
		return yearOfLunch;
	}

	public void setYearOfLunch(Date yearOfLunch) {
		this.yearOfLunch = yearOfLunch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + speed;
		result = prime * result + ((yearOfLunch == null) ? 0 : yearOfLunch.hashCode());
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
		if (yearOfLunch == null) {
			if (other.yearOfLunch != null)
				return false;
		} else if (!yearOfLunch.equals(other.yearOfLunch))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", price=" + price + ", speed=" + speed + ", yearOfLunch=" + yearOfLunch
				+ ", coordinates=" + coordinates + "]";
	}

}
