package ua.com.project1.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.project1.Accessory;
import ua.com.project1.Bouquet;
import ua.com.project1.Flower;
import ua.com.project1.enums.AccessoryType;
import ua.com.project1.enums.FlowerColors;

public class DemoProject {
	private static Bouquet bouquet = new Bouquet();
	private static Logger LOGGER = Logger.getLogger(DemoProject.class.getName());
	private static String FILE_NAME_INPUT = "src" + File.separator + "ua" + File.separator + "com" + File.separator
			+ "project1" + File.separator + "files" + File.separator + "inputData.txt";

	public static void main(String[] args) {
		try {
			bouquet = createBoquet(new File(FILE_NAME_INPUT));
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}

		bouquet.print(LOGGER);
		LOGGER.log(Level.INFO, "\n\nSorted flowers by freshness:");
		bouquet.sortByFreshness();
		bouquet.print(LOGGER);
		LOGGER.log(Level.INFO, "\n\nGet flowers with length from 5 to 10:");
		ArrayList<Flower> list = (ArrayList<Flower>) bouquet.getFlowerWithLength(5, 10);
		bouquet.printFlowers(LOGGER, list);

	}

	public static Bouquet createBoquet(File file) throws IOException {

		if (!file.exists()) {
			file.createNewFile();
		}
		Bouquet list = new Bouquet();

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			int num = Integer.parseInt(bufferedReader.readLine());
			for (int i = 0; i < num; i++) {
				String[] values = bufferedReader.readLine().split(";");
				switch (values[0]) {
				case "Flower":
					list.addFlower(createFlower(values));
					break;
				case "Accessory":
					list.addAccessory(createAccessory(values));
					break;
				}

			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return list;
	}

	private static Flower createFlower(String[] values) {
		Flower result;
		String name = values[1];
		FlowerColors color = FlowerColors.valueOf(values[2]);
		int length = Integer.valueOf(values[3]);
		GregorianCalendar dayOfCut = new GregorianCalendar();
		String[] dates = values[4].split("/");
		dayOfCut.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dates[0]));
		dayOfCut.set(Calendar.MONTH, Integer.valueOf(dates[1]));
		dayOfCut.set(Calendar.YEAR, Integer.valueOf(dates[2]));

		BigDecimal price = BigDecimal.valueOf(Double.valueOf(values[5]));
		result = new Flower(name, dayOfCut, price, color, length);
		return result;
	}

	public static Accessory createAccessory(String[] values) {
		Accessory result;
		String name = values[1];
		AccessoryType type = AccessoryType.valueOf(values[2]);
		BigDecimal price = BigDecimal.valueOf(Double.valueOf(values[3]));
		result = new Accessory(name, price, type);
		return result;
	}

}
