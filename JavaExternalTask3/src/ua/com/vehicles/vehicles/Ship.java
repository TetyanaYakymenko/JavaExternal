package ua.com.vehicles.vehicles;

import ua.com.vehicles.Vehicle;
import ua.com.vehicles.interfaces.Swimable;

public class Ship extends Vehicle implements Swimable {

	private static final long serialVersionUID = 1L;
	private int countOfPassengers;
	private int port;

	public Ship() {
		super("");
	}

	public Ship(String name) {
		super(name);
		countOfPassengers = 0;
		port = 0;
	}

	public Ship countOfPassengers(int count) {
		this.countOfPassengers = count;
		return this;
	}

	public Builder newBuilder() {
		return new Builder();
	}

	public static class Builder extends Vehicle.Builder {
		private int countOfPassengers;
		private int port;

		public Builder() {
			super();
		}

		public Builder setCountOfPassengers(int countOfPassengers) {
			this.countOfPassengers = countOfPassengers;
			return this;
		}

		public Builder setPort(int port) {
			this.port = port;
			return this;

		}

		public Ship build() {
			Ship result = new Ship();

			Vehicle vehicle = super.build();
			result.setName(vehicle.getName());
			result.setPrice(vehicle.getPrice());
			result.setSpeed(vehicle.getSpeed());
			result.setCoordinates(vehicle.getCoordinates());
			result.setYearOfLaunch(vehicle.getYearOfLaunch());
			result.setCountOfPassengers(this.countOfPassengers);
			result.setPort(this.port);

			return result;
		}
	}

	public Ship newInstance() {
		Ship result = (Ship) super.newInstance();
		result.countOfPassengers(this.countOfPassengers);
		result.port(this.port);
		return result;
	}

	public Ship port(int port) {
		this.port = port;
		return this;
	}

	public int getCountOfPassengers() {
		return countOfPassengers;
	}

	public void setCountOfPassengers(int countOfPassengers) {
		this.countOfPassengers = countOfPassengers;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Ship [" + super.toString() + " countOfPassengers=" + countOfPassengers + ", port=" + port + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + countOfPassengers;
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
		if (countOfPassengers != other.countOfPassengers)
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
