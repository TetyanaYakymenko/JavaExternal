package classes.vehicles;


import interfaces.Swimable;

public class AmphibianCar extends Car implements  Runnable, Swimable {

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

}
