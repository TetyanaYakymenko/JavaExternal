package ua.com.project1.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ua.com.project1.Accessory;
import ua.com.project1.Bouquet;
import ua.com.project1.Flower;
import ua.com.project1.enums.AccessoryType;
import ua.com.project1.enums.FlowerColors;

class BouquetTests {
	private Bouquet bouquet ;
	
	@Test
	void getPrice_AfterAddingFlower() {
		bouquet = new Bouquet();
		Flower flower = new Flower("Tulip", new GregorianCalendar(), new BigDecimal(86), FlowerColors.YELLOW, 2);
		bouquet.addFlower(flower);
		BigDecimal expectedPrice = new BigDecimal(86);
		BigDecimal actualPrice = bouquet.getPrice();
	
		assertEquals(expectedPrice.toString(), actualPrice.toString());
	}
	
	@Test
	void getPrice_AfterAddingAccessory() {
		bouquet = new Bouquet();
		Accessory accessory = new Accessory("Red tape", new BigDecimal(45), AccessoryType.TAPE);
		bouquet.addAccessory(accessory);
		BigDecimal expectedPrice = new BigDecimal(45);
		BigDecimal actualPrice = bouquet.getPrice();
	
		assertEquals(expectedPrice.toString(), actualPrice.toString());
	}
	
	@Test
	void getPrice_EmptyBouquet_Zero() {
		bouquet = new Bouquet();
		Accessory accessory = new Accessory("Red tape", new BigDecimal(45), AccessoryType.TAPE);
		bouquet.addAccessory(accessory);
		BigDecimal expectedPrice = new BigDecimal(45);
		BigDecimal actualPrice = bouquet.getPrice();
	
		assertEquals(expectedPrice.toString(), actualPrice.toString());
	}
	
	@Test
	void addFlowers_Null__NullPointerEception() {
		bouquet = new Bouquet();
		Assertions.assertThrows(NullPointerException.class, () -> bouquet.addFlower(null));
	}
	
	@Test
	void addAccessories_Null__NullPointerEception() {
		bouquet = new Bouquet();
		Assertions.assertThrows(NullPointerException.class, () -> bouquet.addAccessory(null));
	}
	
	@Test
	void addFlowers_NegativeCount_IllegalArgExc() {
		bouquet = new Bouquet();
		Flower flower = new Flower("Tulip", new GregorianCalendar(), new BigDecimal(86), FlowerColors.YELLOW, 2);
		Assertions.assertThrows(IllegalArgumentException.class, () -> bouquet.addFlowers(flower, -5));
	
	}
	
	@Test
	void addAccessories_CoorectData_AddedAccesories() {
		bouquet = new Bouquet();
		Accessory accessory = new Accessory("green balon", new BigDecimal(12), AccessoryType.BALOON);
		bouquet.addAccessories(accessory, 2);
		List<Accessory> expectedList = new ArrayList<>();
		expectedList.add(accessory);
		expectedList.add(accessory);
		List<Accessory> actualList = bouquet.getAccessoies();
		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	
	} 

}
