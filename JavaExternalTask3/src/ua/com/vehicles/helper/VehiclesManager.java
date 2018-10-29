package ua.com.vehicles.helper;

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

	public List<Vehicle> createListVechicles() {
		List<Vehicle> list = new ArrayList<>();
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
