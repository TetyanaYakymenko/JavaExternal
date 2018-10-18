import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import classes.Coordinates;
import classes.Vehicle;
import classes.vehicles.AmphibianCar;
import classes.vehicles.BatCar;
import classes.vehicles.Car;
import classes.vehicles.Plane;
import classes.vehicles.Ship;

import exceptions.IncorrectInputException;

import interfaces.Flyable;
import interfaces.Runable;
import interfaces.Swimable;

public class Helper {
	private static final Logger LOGGER = Logger.getLogger( Helper.class.getName());
	private static ArrayList<Vehicle> list = new ArrayList<>() ;
	private static ResourceBundle rb;
	private static Locale locale;
	
	public static void main(String[] args) {
		LOGGER.info("Choose language: \n 1. English; \n 2. Ukrainian;\n 3. Russian;");
	
		Scanner sc = new Scanner(System.in);
		int language = 1;
		while(true) {
			try {
				language = sc.nextInt();
				break;
				
			}catch (InputMismatchException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				sc.nextLine();
			};
		}
		
		setInternalisation(language);
		createListVechicles();
		dialogWithUser(); 
		 
		 
	 }
	
	private static void createListVechicles() {
		Plane planeTu = new Plane("TU27");
		planeTu.hightOfFlying(3000).countOfPassangers(240).yearOfLaunch(2008).price(20000).speed(350).coordinates(new Coordinates(24, 56));
		
		Plane planeAn = new Plane("AN56");
		planeTu.hightOfFlying(7000).countOfPassangers(307).yearOfLaunch(2011).price(26000).speed(400).coordinates(new Coordinates(6, 56));
		
		Plane planeIl = new Plane("IL06");
		planeTu.hightOfFlying(5000).countOfPassangers(150).price(30000).yearOfLaunch(2013).speed(450).coordinates(new Coordinates(24, 5));
		
		Car volvo = new Car("Volvo");
		volvo.price(75000).yearOfLaunch(2017).speed(200).coordinates(new Coordinates(2, 9));
		
		Car bmv = new Car("BMV");
		bmv.price(70000).yearOfLaunch(2012).speed(150).coordinates(new Coordinates(2, 29));

		Ship ship = new Ship("ShipOne");
		ship.countOfPassangers(1000).port(102).price(40000).yearOfLaunch(2004).speed(100);
		
		AmphibianCar amphCar = new AmphibianCar("Amphibia 001");
		amphCar.price(75000).yearOfLaunch(2018).speed(200).coordinates(new Coordinates(23, 18));
		
		AmphibianCar amphCar2 = new AmphibianCar("Amphibia 002");
		amphCar.price(70000).yearOfLaunch(2018).speed(210).coordinates(new Coordinates(23, 20));
		
		BatCar myBatCar = BatCar.getInstance();
		
		
		list.add(planeTu);
		list.add(planeAn);
		list.add(planeIl);
		list.add(volvo);
		list.add(bmv);
		list.add(ship);
		list.add(amphCar);
		list.add(amphCar2);
		list.add(myBatCar);
		

	}

	private static void dialogWithUser() {	
		LOGGER.info(rb.getString("message1"));
		
		
		for(Vehicle item : list) {
			LOGGER.info(item.toString());
		}
		
		LOGGER.info(rb.getString("message2"));
		
		int minPrice = minPrice(list);
		
		for(Vehicle item : list) {
			if((2018 - item.getYearOfLaunch() >= 5) && ( minPrice == item.getPrice()))
				LOGGER.info(item.toString());
		}
		 
		LOGGER.info(rb.getString("message3"));
		 for (Vehicle item : list) {
			 if((item instanceof Plane) && (((Plane)item).getHightOfFlying() >= 5000) && (((Plane)item).getYearOfLaunch() >= 2000)) {
				 LOGGER.info(item.toString());
			 }
		 }
		
		 LOGGER.info(rb.getString("flyable"));
		 for (Vehicle item : list) {
			 if(item instanceof Flyable) {
				 LOGGER.info(item.toString());
			 }
		 }
		 LOGGER.info(rb.getString("moveable"));
		for (Vehicle item : list) {
			 if(item instanceof Runable) {
				 LOGGER.info(item.toString());
			 }
		 }
		LOGGER.info(rb.getString("swimable"));
		for (Vehicle item : list) {
			 if(item instanceof Swimable) {
				 LOGGER.info(item.toString());
			 }
		 }
		LOGGER.info(rb.getString("message4"));
		
		int maxSpeed = maxSpeed(list);
		
		for(Vehicle item : list) {
			if ( maxSpeed == item.getSpeed())
				LOGGER.info(item.toString());
		}	
	}
	
	private static int minPrice(ArrayList<Vehicle> list) {
		int tmp = 0;
		
		for(Vehicle item : list) {
			if(tmp > item.getPrice()) tmp = item.getPrice();
		}
		
		return tmp;
	}
	private static int maxSpeed(ArrayList<Vehicle> list) {
		int tmp = 0;
		
		for(Vehicle item : list) {
			if(tmp < item.getPrice()) tmp = item.getSpeed();
		}
		
		return tmp;
	}
	
	private static void setInternalisation(int language) {
		if((language <= 0) || (language >= 4))
			throw new IncorrectInputException("You must choose 1,2 or 3.");
		switch (language) {
		case 1:
			locale = new Locale("eng", "UK");
			break;
		case 2:
			locale = new Locale("ua", "Ua");
			break;
		default:
			//locale = new  Locale("ru", "RU");
			locale = new Locale("eng", "UK");
			break;
		}
		rb = ResourceBundle.getBundle("text", locale);
	}
}
