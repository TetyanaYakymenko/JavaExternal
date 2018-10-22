package classes.vehicles;

import classes.Vehicle;
import interfaces.Flyable;

public class Plane extends Vehicle implements Flyable {
	private int countOfPassangers;
	private int hightOfFlying;

	public Plane() {
		super("");
		countOfPassangers = 0;

	}

	public Plane(String name) {
		super(name);
		countOfPassangers = 0;

	}

	public Plane(String name, int hightOfFlying) {
		super(name);
		countOfPassangers = hightOfFlying;

	}

	public Builder newBuilder() {
		return new Builder();
	}

	public static class Builder extends Vehicle.Builder {
		private int countOfPassangers;
		private int hightOfFlying;

		public Builder() {
			super();
		}

		public Builder setCountOfPassangers(int countOfPassangers) {
			this.countOfPassangers = countOfPassangers;
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
			result.setCountOfPassangers(this.countOfPassangers);
			result.setHightOfFlying(this.hightOfFlying);

			return result;
		}

	}

	public Plane countOfPassangers(int countOfPassangers) {
		this.countOfPassangers = countOfPassangers;
		return this;
	}

	public Plane newInstance() {
		Plane result = (Plane) super.newInstance();

		return result.countOfPassangers(this.countOfPassangers);
	}

	public Plane hightOfFlying(int hightOfFlying) {
		this.hightOfFlying = hightOfFlying;
		return this;
	}

	public int getCountOfPassangers() {
		return countOfPassangers;
	}

	public void setCountOfPassangers(int countOfPassangers) {
		this.countOfPassangers = countOfPassangers;
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
		result = prime * result + countOfPassangers;
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
		if (countOfPassangers != other.countOfPassangers)
			return false;
		if (hightOfFlying != other.hightOfFlying)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plane [ " + super.toString() + " countOfPassangers=" + countOfPassangers + " hightOfFlying="
				+ hightOfFlying + "]";
	}

	@Override
	public void fly() {
		System.out.println("Plane with name " + getName() + " is flying.");

	}

}
