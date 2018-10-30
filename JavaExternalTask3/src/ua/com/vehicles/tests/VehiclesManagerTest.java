package ua.com.vehicles.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import ua.com.vehicles.Vehicle;
import ua.com.vehicles.helper.VehiclesManager;
import ua.com.vehicles.vehicles.Plane;

public class VehiclesManagerTest {
	private VehiclesManager vehiclesManager = VehiclesManager.INSTANCE;
	
	@Test
	public void getList_NullList_Error() {
		Assertions.assertThrows(NullPointerException.class, () -> vehiclesManager.getFlyableVehicles(null));
		Assertions.assertThrows(NullPointerException.class, () -> vehiclesManager.getMoveableVehicles(null));
	}
	
	@Test
	public void minPrice_OneTwo_One() {
		ArrayList<Vehicle> list = new  ArrayList<Vehicle>();
		Plane plane = new Plane();
		plane = (Plane) plane.newBuilder().setHightOfFlying(0)
				.setCountOfPassengers(0).setName("one").setPrice(1).setYearOfLaunch(new GregorianCalendar())
				.setSpeed(0).setCoordinates(0, 0).build();
		list.add(plane);
		Plane plane1 = new Plane();
		plane1 = (Plane) plane.newBuilder().setHightOfFlying(0)
				.setCountOfPassengers(0).setName("two").setPrice(2).setYearOfLaunch(new GregorianCalendar())
				.setSpeed(0).setCoordinates(0, 0).build();
		list.add(plane1);
		assertEquals( 1, vehiclesManager.minPrice(list));
	}
	@Test 
	public void getVehiclesWithSpeed_OneOne_OneItem() {
		ArrayList<Vehicle> list = new  ArrayList<Vehicle>();
		Plane plane = new Plane();
		plane = (Plane) plane.newBuilder().setHightOfFlying(0)
				.setCountOfPassengers(0).setName("one").setPrice(0).setYearOfLaunch(new GregorianCalendar())
				.setSpeed(10).setCoordinates(0, 0).build();
		list.add(plane);
		Plane plane1 = new Plane();
		plane1 = (Plane) plane.newBuilder().setHightOfFlying(0)
				.setCountOfPassengers(0).setName("two").setPrice(0).setYearOfLaunch(new GregorianCalendar())
				.setSpeed(2).setCoordinates(0, 0).build();
		list.add(plane1);
		ArrayList<Vehicle> expectedlist = new  ArrayList<Vehicle>();
		expectedlist.add(plane1);
		assertArrayEquals(list.toArray(), expectedlist.toArray());
	}
}
