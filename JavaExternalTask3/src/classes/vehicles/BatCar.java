package classes.vehicles;

import java.util.Calendar;
import java.util.GregorianCalendar;

import classes.Coordinates;
import classes.Vehicle;
import classes.vehicles.Car.Builder;
import interfaces.Flyable;
import interfaces.Swimable;

public class BatCar extends Car implements Runnable, Swimable, Flyable {
	private static BatCar instance;

	private BatCar(String name, int price, int speed, GregorianCalendar yearOfLaunch, Coordinates coordinates) {
		super(name, price, speed, yearOfLaunch, coordinates);

	}

	public static BatCar getInstance() {
		if (instance == null) {
			GregorianCalendar tmp = new GregorianCalendar();
			tmp.set(Calendar.YEAR, 2001);
			instance = new BatCar("Bat car", 80000, 400, tmp, new Coordinates(1, 15));
		}
		return instance;
	}

	@Override
	public String toString() {
		return "BatCar [" + super.toString() + "]";
	}

	@Override
	public void run() {
		System.out.println("BatCar with name " + getName() + " is running");

	}

	@Override
	public void fly() {
		System.out.println("BatCar with name " + getName() + " is flying");

	}

	@Override
	public void swim() {
		System.out.println("BatCar with name " + getName() + " is swimming");

	}

}
