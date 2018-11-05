package ua.com.project2.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoProject2 {
	private static Logger LOGGER = Logger.getLogger(DemoProject2.class.getName());
	private static String FILE_NAME_INPUT = "src" + File.separator + "ua" + File.separator + "com" + File.separator
			+ "project2" + File.separator + "files" + File.separator + "inputData.txt";
	private static TextManager textManager = new TextManager();

	public static void main(String[] args) {
		try {
			readText(new File(FILE_NAME_INPUT));
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
	}

	public static void readText(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			StringBuilder wholeTextBuilder = new StringBuilder();
			while (bufferedReader.ready()) {
				String buffer = bufferedReader.readLine();
				buffer = buffer.replaceAll("\\s+", " ");
				wholeTextBuilder.append(buffer);
				wholeTextBuilder.append('\r');
			}
			 textManager = new TextManager(wholeTextBuilder.toString());

		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		
		LOGGER.log(Level.INFO, "Maximum count of sentences with the same word(s) is " + textManager.getMaxEntriesWord());
	}
}
