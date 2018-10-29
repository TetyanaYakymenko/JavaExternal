package ua.com.vehicles.vehicles;

import java.util.GregorianCalendar;

import ua.com.vehicles.Coordinates;
import ua.com.vehicles.Vehicle;
import ua.com.vehicles.interfaces.Moveable;

public class Car extends Vehicle implements Cloneable, Moveable {
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
			//result.setYearOfLaunch(vehicle.getYearOfLaunch());
			return  new Car();//\\\result;
		}
	}

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
