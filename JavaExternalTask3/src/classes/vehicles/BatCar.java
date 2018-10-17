package classes.vehicles;

import classes.Vehicle;
import interfaces.Flyable;
import interfaces.Swimable;

public class BatCar extends Car implements Runnable, Swimable, Flyable {

	public BatCar(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("BatCar with name " + getName() + " is running");

	}

}
