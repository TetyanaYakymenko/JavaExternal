import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
	private static final Logger LOGGER = Logger.getLogger(Helper.class.getName());
	private static ArrayList<Vehicle> list = new ArrayList<>();
	private static ResourceBundle rb;
	private static Locale locale;

	public static void main(String[] args) {
		LOGGER.info("Choose language: \n 1. English; \n 2. Ukrainian;\n 3. Russian;");

		Scanner sc = new Scanner(System.in);
		int language = 1;
		while (true) {
			try {
				language = sc.nextInt();
				break;

			} catch (InputMismatchException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				sc.nextLine();
			}
			;
		}

		setInternalisation(language);
		createListVechicles();
		dialogWithUser();

	}

	private static void createListVechicles() {
		Plane planeTu = new Plane();
		GregorianCalendar temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2008);
		planeTu = (Plane) planeTu.newBuilder().setHightOfFlying(3000).setCountOfPassangers(240).setYearOfLaunch(temp)
				.setSpeed(350).setName("TU27").setCoordinates(24, 56).build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2011);
		Plane planeAn = new Plane();
		planeAn = (Plane) planeAn.newBuilder().setHightOfFlying(7000).setCountOfPassangers(307).setYearOfLaunch(temp)
				.setName("AN56").setPrice(26000).setSpeed(400).setCoordinates(6, 56).build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2011);
		Plane planeIl = new Plane();
		planeIl = (Plane) planeIl.newBuilder().setHightOfFlying(5000).setCountOfPassangers(150).setName("IL06")
				.setPrice(30000).setYearOfLaunch(temp).setSpeed(450).setCoordinates(24, 5).build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2017);
		Car volvo = new Car();
		volvo = (Car) volvo.newBuilder().setName("Volvo").setPrice(75000).setName("Volvo").setYearOfLaunch(temp)
				.setSpeed(200).setCoordinates(2, 9).build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2012);
		Car bmv = new Car();
		bmv = (Car) bmv.newBuilder().setName("BMV").setPrice(70000).setYearOfLaunch(temp).setSpeed(150)
				.setCoordinates(2, 29).build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2004);
		Ship ship = new Ship();
		ship = (Ship) ship.newBuilder().setCountOfPassangers(1000).setPort(102).setName("ShipOne").setPrice(40000)
				.setYearOfLaunch(temp).setSpeed(100).build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2018);
		AmphibianCar amphCar = new AmphibianCar();
		amphCar = (AmphibianCar) amphCar.newBuilder().setYearOfLaunch(temp).setPrice(75000).setSpeed(200)
				.setCoordinates(23, 18).setName("Amphibia 001").build();

		temp = new GregorianCalendar();
		temp.set(Calendar.YEAR, 2018);
		AmphibianCar amphCar2 = new AmphibianCar();
		amphCar2 = (AmphibianCar) amphCar2.newBuilder().setYearOfLaunch(temp).setPrice(70000).setSpeed(210)
				.setCoordinates(23, 20).setName("Amphibia 002").build();

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

		for (Vehicle item : list) {
			LOGGER.info(item.toString());
		}

		LOGGER.info(rb.getString("message2"));

		int minPrice = minPrice(list);

		for (Vehicle item : list) {
			if ((2018 - item.getYearOfLaunch().get(Calendar.YEAR) >= 5) && (minPrice == item.getPrice()))
				LOGGER.info(item.toString());
		}

		LOGGER.info(rb.getString("message3"));
		for (Vehicle item : list) {
			if ((item instanceof Plane) && (((Plane) item).getHightOfFlying() >= 5000)
					&& (((Plane) item).getYearOfLaunch().get(Calendar.YEAR) >= 2000)) {
				LOGGER.info(item.toString());
			}
		}

		LOGGER.info(rb.getString("flyable"));
		for (Vehicle item : list) {
			if (item instanceof Flyable) {
				LOGGER.info(item.toString());
			}
		}
		LOGGER.info(rb.getString("moveable"));
		for (Vehicle item : list) {
			if (item instanceof Runable) {
				LOGGER.info(item.toString());
			}
		}
		LOGGER.info(rb.getString("swimable"));
		for (Vehicle item : list) {
			if (item instanceof Swimable) {
				LOGGER.info(item.toString());
			}
		}
		LOGGER.info(rb.getString("message4"));

		int maxSpeed = maxSpeed(list);

		for (Vehicle item : list) {
			if (maxSpeed == item.getSpeed())
				LOGGER.info(item.toString());
		}
	}

	private static int minPrice(ArrayList<Vehicle> list) {
		int tmp = 0;

		for (Vehicle item : list) {
			if (tmp > item.getPrice())
				tmp = item.getPrice();
		}

		return tmp;
	}

	private static int maxSpeed(ArrayList<Vehicle> list) {
		int tmp = 0;

		for (Vehicle item : list) {
			if (tmp < item.getPrice())
				tmp = item.getSpeed();
		}

		return tmp;
	}

	private static void setInternalisation(int language) {
		if ((language <= 0) || (language >= 4))
			throw new IncorrectInputException("You must choose 1,2 or 3.");
		switch (language) {
		case 1:
			locale = new Locale("eng", "UK");
			break;
		case 2:
			locale = new Locale("ua", "Ua");
			break;
		default:
			locale = new Locale("ru", "RU");
			break;
		}
		rb = ResourceBundle.getBundle("text", locale);
	}
}
