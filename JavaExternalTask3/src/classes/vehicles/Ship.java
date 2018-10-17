package classes.vehicles;

import classes.Vehicle;
import interfaces.Swimable;

public class Ship extends Vehicle implements Swimable {

	private int countOfPassangers;
	private int port;

	public Ship(String name) {
		super(name);
		countOfPassangers = 0;
		port = 0;
	}

	public Ship countOfPassangers(int count) {
		this.countOfPassangers = count;
		return this;
	}

	public Ship newInstance() {
		Ship result = (Ship) super.newInstance();
		result.countOfPassangers(this.countOfPassangers);
		result.port(this.port);
		return result;
	}

	public Ship port(int port) {
		this.port = port;
		return this;
	}

	public int getCountOfPassangers() {
		return countOfPassangers;
	}

	public void setCountOfPassangers(int countOfPassangers) {
		this.countOfPassangers = countOfPassangers;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Ship [" + super.toString() + " countOfPassangers=" + countOfPassangers + ", port=" + port + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + countOfPassangers;
		result = prime * result + port;
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
		Ship other = (Ship) obj;
		if (countOfPassangers != other.countOfPassangers)
			return false;
		if (port != other.port)
			return false;
		return true;
	}

	@Override
	public void swim() {
		System.out.println("Ship with name " + getName() + " is swimming.");

	}
}
