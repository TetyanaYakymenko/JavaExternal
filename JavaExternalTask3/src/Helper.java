import java.util.ArrayList;

import classes.Vehicle;
import classes.vehicles.AmphibianCar;

public class Helper {
	private static ArrayList<Vehicle> list = new ArrayList<>() ;
	
	
	public static void main(String[] args) {
		AmphibianCar amphCar = new AmphibianCar("My amphibian car");
		list.add(amphCar);
		 
		 
	 }

}
