package ua.com.vehicles.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ua.com.vehicles.Vehicle;

public class Serializator {
	private ObjectOutputStream objectOutputStream = null;
	private ObjectInputStream objectInputStream = null;

	public boolean serialization(Vehicle vehicle, String fileName)
			throws FileNotFoundException, NotSerializableException, IOException {
		boolean result = false;
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		if (objectInputStream == null) {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		}
		if (fileOutputStream != null) {
			objectOutputStream.writeObject(vehicle);
			result = true;
		}
		return result;
	}

	public void closeStreams() throws IOException {

		if (objectInputStream != null) {
			objectInputStream.close();
		}
		if (objectInputStream != null) {
			objectOutputStream.close();
		}
	}

	public Vehicle desrialization(String fileName) throws InvalidObjectException, ClassNotFoundException, IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		if (objectInputStream == null) {
			objectInputStream = new ObjectInputStream(fileInputStream);
		}
		Vehicle vehicle = (Vehicle) objectInputStream.readObject();
		return vehicle;
	}

}
