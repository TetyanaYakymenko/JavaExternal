package ua.com.vehicles.helper;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.vehicles.Vehicle;
import ua.com.vehicles.esceptions.IncorrectInputException;
import ua.com.vehicles.helper.ResourceManager;

public class DemoVehicles {
	private static List<Vehicle> list = new ArrayList<>();

	private static ResourceManager rm = ResourceManager.INSTANCE;
	private static VehiclesManager vm = VehiclesManager.INSTANCE;
	private static Logger LOGGER = Logger.getLogger(DemoVehicles.class.getName());

	public static void main(String[] args) {
			
		LOGGER.info("Choose language: \n 1. English; \n 2. Ukrainian;\n 3. Russian;");

		Scanner sc = new Scanner(System.in);
		int language = 1;

		while (true) {
			try {
				language = sc.nextInt();
				setInternalisation(language);
				break;

			} catch (InputMismatchException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				sc.nextLine();
			}
		}
		sc.close();
		list = vm.createListVechicles();
		dialogWithUser();

	}
	
	public static void setInternalisation(int language) {
		if ((language <= 0) || (language > 3))
			throw new IncorrectInputException("You must choose 1,2 or 3.");
		Locale locale;
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
		rm.changeResource(locale) ;
	}

	
	private static void dialogWithUser() {
		List<Vehicle> temp;
		LOGGER.info(rm.getString("message1"));
		printVehicles(list);

		LOGGER.info(rm.getString("message2"));
		int minPrice = vm.minPrice(list);
		temp = vm.getVechicleWithPrice(list, minPrice, minPrice);
		temp = vm.getVechicleOlderThen(temp, 5);
		printVehicles(temp);

		LOGGER.info(rm.getString("message3"));
		temp = vm.getVehiclesWithYearOfLaunch(list, 2000, 2000);
		temp = vm.getPlanesWithHightOfFlying(temp, 5000, 5000);
		printVehicles(temp);

		LOGGER.info(rm.getString("flyable"));
		printVehicles(vm.getFlyableVehicles(list));

		LOGGER.info(rm.getString("moveable"));
		printVehicles(vm.getMoveableVehicles(list));

		LOGGER.info(rm.getString("swimable"));
		printVehicles(vm.getSwimableVehicles(list));

		LOGGER.info(rm.getString("message4"));
		int maxSpeed = vm.maxSpeed(list);
		printVehicles(vm.getVehiclesWithSpeed(list, maxSpeed, maxSpeed));

	}
	
	public static void printVehicles(List<Vehicle> list) {
		for (Vehicle item : list) {
			LOGGER.info(item.toString());
		}
	}

	
	

	
}
