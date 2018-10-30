package ua.com.vehicles.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ua.com.vehicles.Vehicle;
import ua.com.vehicles.interfaces.Flyable;
import ua.com.vehicles.interfaces.Moveable;
import ua.com.vehicles.interfaces.Swimable;
import ua.com.vehicles.vehicles.AmphibianCar;
import ua.com.vehicles.vehicles.BatCar;
import ua.com.vehicles.vehicles.Car;
import ua.com.vehicles.vehicles.Plane;
import ua.com.vehicles.vehicles.Ship;

public enum VehiclesManager {
	INSTANCE;

	private VehiclesManager() {
	}

	public List<Vehicle> createListVechicles(File file) throws IOException {

		if (!file.exists()) {
			file.createNewFile();
		}

		List<Vehicle> list = new ArrayList<>();

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			int num = Integer.parseInt(bufferedReader.readLine());
			for (int i = 0; i < num; i++) {
				String[] values = bufferedReader.readLine().split("\\s");
				if (values[0].equals("BatCar")) {
					list.add(BatCar.getInstance());
				}
				if (values[0].equals("Car")) {
					String name = values[1];
					int price = Integer.parseInt(values[2]);
					int speed = Integer.parseInt(values[3]);
					int year = Integer.parseInt(values[4]);
					int coordinataX = Integer.parseInt(values[5]);
					int coordinataY = Integer.parseInt(values[6]);

					GregorianCalendar temp = new GregorianCalendar();
					temp.set(Calendar.YEAR, year);
					Car car = new Car();
					car = (Car) car.newBuilder().setName(name).setPrice(price).setYearOfLaunch(temp).setSpeed(speed)
							.setCoordinates(coordinataX, coordinataY).build();
					list.add(car);

				}
				if (values[0].equals("AmphibianCar")) {
					String name = values[1].toString();
					int price = Integer.parseInt(values[2]);
					int speed = Integer.parseInt(values[3]);
					int year = Integer.parseInt(values[4]);
					int coordinataX = Integer.parseInt(values[5]);
					int coordinataY = Integer.parseInt(values[6]);

					GregorianCalendar temp = new GregorianCalendar();
					temp.set(Calendar.YEAR, year);
					AmphibianCar car = new AmphibianCar();
					car = (AmphibianCar) car.newBuilder().setName(name).setPrice(price).setYearOfLaunch(temp)
							.setSpeed(speed).setCoordinates(coordinataX, coordinataY).build();
					list.add(car);

				}
				if (values[0].equals("Plane")) {
					int hightOfFlying = Integer.parseInt(values[1]);
					int countOfPassengers = Integer.parseInt(values[2]);
					String name = values[3];
					int price = Integer.parseInt(values[4]);
					int speed = Integer.parseInt(values[5]);
					int year = Integer.parseInt(values[6]);
					int coordinataX = Integer.parseInt(values[7]);
					int coordinataY = Integer.parseInt(values[8]);

					GregorianCalendar temp = new GregorianCalendar();
					temp.set(Calendar.YEAR, year);
					Plane plane = new Plane();
					plane = (Plane) plane.newBuilder().setHightOfFlying(hightOfFlying)
							.setCountOfPassengers(countOfPassengers).setName(name).setPrice(price).setYearOfLaunch(temp)
							.setSpeed(speed).setCoordinates(coordinataX, coordinataY).build();
					list.add(plane);

				}
				if (values[0].equals("Ship")) {
					int countOfPassengers = Integer.parseInt(values[1]);
					int port = Integer.parseInt(values[2]);
					String name = values[3];
					int price = Integer.parseInt(values[4]);
					int speed = Integer.parseInt(values[5]);
					int year = Integer.parseInt(values[6]);
					int coordinataX = Integer.parseInt(values[7]);
					int coordinataY = Integer.parseInt(values[8]);

					GregorianCalendar temp = new GregorianCalendar();
					temp.set(Calendar.YEAR, year);
					Ship ship = new Ship();
					ship = (Ship) ship.newBuilder().setPort(port).setCountOfPassengers(countOfPassengers).setName(name)
							.setPrice(price).setYearOfLaunch(temp).setSpeed(speed)
							.setCoordinates(coordinataX, coordinataY).build();
					list.add(ship);

				}

			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return list;
	}

	public int minPrice(List<Vehicle> list) {
		int tmp = 0;

		for (Vehicle item : list) {
			if (tmp > item.getPrice())
				tmp = item.getPrice();
		}

		return tmp;
	}

	public int maxSpeed(List<Vehicle> list) {
		int tmp = 0;

		for (Vehicle item : list) {
			if (tmp < item.getSpeed())
				tmp = item.getSpeed();
		}

		return tmp;
	}

	public List<Vehicle> getSwimableVehicles(List<Vehicle> list) {
		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if (item instanceof Swimable) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Vehicle> getMoveableVehicles(List<Vehicle> list) {
		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if (item instanceof Moveable) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Vehicle> getFlyableVehicles(List<Vehicle> list) {
		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if (item instanceof Flyable) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Vehicle> getVehiclesWithSpeed(List<Vehicle> list, int from, int to) {
		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if ((item.getSpeed() >= from) && (item.getSpeed() <= to)) {
				result.add(item);
			}
		}
		return result;

	}

	public List<Vehicle> getPlanesWithHightOfFlying(List<Vehicle> list, int from, int to) {

		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if ((item instanceof Plane) && (((Plane) item).getHightOfFlying() >= from)
					&& (((Plane) item).getHightOfFlying() <= to)) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Vehicle> getVehiclesWithYearOfLaunch(List<Vehicle> list, int from, int to) {

		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if ((item.getYearOfLaunch().get(Calendar.YEAR) >= from)
					&& (item.getYearOfLaunch().get(Calendar.YEAR) <= to)) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Vehicle> getVechicleWithPrice(List<Vehicle> list, int from, int to) {

		List<Vehicle> result = new ArrayList<>();
		for (Vehicle item : list) {
			if ((item.getPrice() >= from) && (item.getPrice() <= to)) {
				result.add(item);
			}
		}
		return result;
	}

	public List<Vehicle> getVechicleOlderThen(List<Vehicle> list, int year) {

		GregorianCalendar dateFrom = new GregorianCalendar();
		dateFrom.set(Calendar.YEAR, dateFrom.get(Calendar.YEAR) - year);
		GregorianCalendar dateTo = new GregorianCalendar();

		List<Vehicle> result = new ArrayList<>();

		result = getVehiclesWithYearOfLaunch(list, dateFrom.get(Calendar.YEAR), dateTo.get(Calendar.YEAR));

		return result;
	}

}
