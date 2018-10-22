package classes.vehicles;

import java.util.GregorianCalendar;

import classes.Coordinates;
import classes.Vehicle;
import interfaces.Runable;

public class Car extends Vehicle implements Cloneable, Runable {
	public Car() {
		this("");
	}

	public Car(String name) {
		super(name);
	}

	public Car(String name, int price, int speed, GregorianCalendar yearOfLaunch, Coordinates coordinates) {
		super(name, price, speed, yearOfLaunch, coordinates);
	}

	public Car newInstance() {
		Car result = new Car(this.getName());
		result = (Car) super.newInstance();
		return result;
	}

	public Builder newBuilder() {
		return new Builder();
	}

	public static class Builder extends Vehicle.Builder {

		public Car build() {
			Car result = new Car();
			Vehicle vehicle = super.build();
			result.setName(vehicle.getName());
			result.setPrice(vehicle.getPrice());
			result.setSpeed(vehicle.getSpeed());
			result.setCoordinates(vehicle.getCoordinates());
			result.setYearOfLaunch(vehicle.getYearOfLaunch());
			return result;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [" + super.toString() + "]";
	}

	@Override
	public void run() {
		System.out.println("Car with name " + getName() + " is running.");

	}

}
