package classes.vehicles;

import classes.Vehicle;

public class Car extends Vehicle implements Cloneable, Runnable {

	public Car(String name) {
		super(name);
	}

	public Car newInstance() {
		Car result = new Car(this.getName());
		result = (Car) super.newInstance();
		return result;
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
