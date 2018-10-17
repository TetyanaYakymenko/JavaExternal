package classes.vehicles;

import classes.Vehicle;
import interfaces.Flyable;

public class Plane extends Vehicle implements Flyable {
	private int countOfPassangers;

	public Plane(String name) {
		super(name);
		countOfPassangers = 0;

	}

	public Plane countOfPassangers(int countOfPassangers) {
		this.countOfPassangers = countOfPassangers;
		return this;
	}

	public Plane newInstance() {
		Plane result = (Plane) super.newInstance();

		return result.countOfPassangers(this.countOfPassangers);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + countOfPassangers;
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
		Plane other = (Plane) obj;
		if (countOfPassangers != other.countOfPassangers)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plane [ " + super.toString() + " countOfPassangers=" + countOfPassangers + "]";
	}

	@Override
	public void fly() {
		System.out.println("Plane with name " + getName() + " is flying.");

	}

}
