package ua.com.vehicles.vehicles;

import ua.com.vehicles.Vehicle;
import ua.com.vehicles.interfaces.Swimable;

public class AmphibianCar extends Car implements Runnable, Swimable {
	public AmphibianCar() {
		this("");
	}

	public AmphibianCar(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("AmphibianCar with name " + getName() + " is running");

	}

	@Override
	public void swim() {
		System.out.println("AmphibianCar with name " + getName() + " is swimming");

	}
	
	public Builder newBuilder() {
		return new Builder();
	}

	public static class Builder extends Car.Builder {
		public Builder() {
			super();
		}

		public AmphibianCar build() {
			AmphibianCar result = new AmphibianCar();
			Vehicle car = super.build();
			result.setName(car.getName());
			result.setPrice(car.getPrice());
			result.setSpeed(car.getSpeed());
			result.setCoordinates(car.getCoordinates());
			result.setYearOfLaunch(car.getYearOfLaunch());
			return result;
		}
	}

}
