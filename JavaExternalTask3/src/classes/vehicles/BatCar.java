package classes.vehicles;

import classes.Coordinates;
import interfaces.Flyable;
import interfaces.Swimable;

public class BatCar extends Car implements Runnable, Swimable, Flyable {
	private static BatCar instance;
	
	private BatCar(String name) {
		super(name);
	}
	public  static BatCar getInstance() {
		if( instance == null) {
			instance = new BatCar("Bat car");
			instance.price(80000).speed(400).yearOfLaunch(2001).coordinates(new Coordinates(1, 15));
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
