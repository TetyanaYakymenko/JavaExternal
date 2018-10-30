package ua.com.vehicles.vehicles;

import ua.com.vehicles.Vehicle;
import ua.com.vehicles.interfaces.Flyable;

public class Plane extends Vehicle implements Flyable {
	
	private static final long serialVersionUID = 1L;
	private int countOfPassengers;
	private int hightOfFlying;

	public Plane() {
		super("");
		countOfPassengers = 0;

	}

	public Plane(String name) {
		super(name);
		countOfPassengers = 0;

	}

	public Plane(String name, int hightOfFlying) {
		super(name);
		countOfPassengers = hightOfFlying;

	}

	public Builder newBuilder() {
		return new Builder();
	}

	public static class Builder extends Vehicle.Builder {
		private int countOfPassengers;
		private int hightOfFlying;

		public Builder() {
			super();
		}

		public Builder setCountOfPassengers(int countOfPassengers) {
			this.countOfPassengers = countOfPassengers;
			return this;
		}

		public Builder setHightOfFlying(int hightOfFlying) {
			this.hightOfFlying = hightOfFlying;
			return this;

		}

		public Plane build() {
			Plane result = new Plane();
			Vehicle vehicle = super.build();
			result.setName(vehicle.getName());
			result.setPrice(vehicle.getPrice());
			result.setSpeed(vehicle.getSpeed());
			result.setCoordinates(vehicle.getCoordinates());
			result.setYearOfLaunch(vehicle.getYearOfLaunch());
			result.setCountOfPassengers(this.countOfPassengers);
			result.setHightOfFlying(this.hightOfFlying);

			return result;
		}

	}

	public Plane countOfPassangers(int countOfPassangers) {
		this.countOfPassengers = countOfPassangers;
		return this;
	}

	public Plane newInstance() {
		Plane result = (Plane) super.newInstance();

		return result.countOfPassangers(this.countOfPassengers);
	}

	public Plane hightOfFlying(int hightOfFlying) {
		this.hightOfFlying = hightOfFlying;
		return this;
	}

	public int getCountOfPassengers() {
		return countOfPassengers;
	}

	public void setCountOfPassengers(int countOfPassengers) {
		this.countOfPassengers = countOfPassengers;
	}

	public int getHightOfFlying() {
		return hightOfFlying;
	}

	public void setHightOfFlying(int hightOfFlying) {
		this.hightOfFlying = hightOfFlying;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + countOfPassengers;
		result = prime * result + hightOfFlying;
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
		if (countOfPassengers != other.countOfPassengers)
			return false;
		if (hightOfFlying != other.hightOfFlying)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plane [ " + super.toString() + " countOfPassengers=" + countOfPassengers + " hightOfFlying="
				+ hightOfFlying + "]";
	}

	@Override
	public void fly() {
		System.out.println("Plane with name " + getName() + " is flying.");

	}

}
