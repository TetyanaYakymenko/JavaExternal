package ua.com.project1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bouquet {
	private List<Flower> flowers;
	private List<Accessory> accessories;
	private BigDecimal price;

	public Bouquet() {
		super();
		flowers = new ArrayList<>();
		accessories = new ArrayList<>();
	}

	public BigDecimal getPrice() {
		if (price == null) {
			BigDecimal result = new BigDecimal(0);
			for (Flower flower : flowers) {
				result = result.add(flower.getPrice());
			}
			for (Accessory acc : accessories) {
				result = result.add(acc.getPrice());
			}
			price = result;
		}
		return price;

	}

	public void addFlower(Flower flower) {
		addFlowers(flower, 1);
	}

	public void addFlowers(Flower flower, int count) {
		if (count <= 0) {
			throw new IllegalArgumentException(" Count must be greater than 0.");
		}
		if (flower == null) {
			throw new NullPointerException("Could not add null as flower.");
		}
		for (int i = 0; i < count; i++) {
			flowers.add(flower);
		}
	}

	public void addAccessory(Accessory accessory) {
		addAccessories(accessory, 1);
	}

	public void addAccessories(Accessory accessory, int count) {
		if (count <= 0) {
			throw new IllegalArgumentException(" Count must be greater than 0.");
		}
		if (accessory == null) {
			throw new NullPointerException("Could not add null as accessory.");
		}
		for (int i = 0; i < count; i++) {
			this.accessories.add(accessory);
		}
	}

	public List<Flower> getFlowerWithLength(int from, int to) {
		ArrayList<Flower> result = new ArrayList<>();
		int length;
		for (Flower flower : flowers) {
			length = flower.getLength();
			if ((length >= from) && (length <= to)) {
				result.add(flower);
			}
		}
		return result;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public List<Accessory> getAccessoies() {
		return accessories;
	}

	public List<Flower> getFlowerWithLength(int length) {
		return getFlowerWithLength(length, length);
	}

	public void sortByFreshness() {
		Collections.sort(flowers,
				(o1, o2) -> (int) (o1.getDayOfCut().getTimeInMillis() - o2.getDayOfCut().getTimeInMillis()));
	}

	public void print(Logger log) {
		for (Flower flower : flowers) {
			log.log(Level.INFO, flower.toString());
		}
		for (Accessory accessory : accessories) {
			log.log(Level.INFO, accessory.toString());
		}
		log.log(Level.INFO, "Price = " + getPrice());
	}

	public void printFlowers(Logger log, List<Flower> flowers) {
		for (Flower flower : flowers) {
			log.log(Level.INFO, flower.toString());
		}
		;
	}

	public void printAccessories(Logger log, List<Accessory> accessories) {
		for (Accessory accessory : accessories) {
			log.log(Level.INFO, accessory.toString());
		}
		;
	}
}
