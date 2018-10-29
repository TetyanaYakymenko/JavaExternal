package ua.com.vehicles.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ua.com.vehicles.esceptions.IncorrectInputException;
import ua.com.vehicles.helper.ResourceManager;

class ResourceManagerTest {
	private ResourceManager rm =ResourceManager.INSTANCE;

	@Test
	@Ignore
	void  setInternalisation_CorrectData_NotNull() {
		//helper.setInternalisation(2);
		//assertNotNull(helper.getLocale());
		//assertNotNull(helper.getRb());
	}
	
	@Test()
	@Ignore
	void  setInternalisation_IncorrectData_NotNull() {
		//Assertions.assertThrows(IncorrectInputException.class, () -> helper.setInternalisation(6));
	}

	
}
