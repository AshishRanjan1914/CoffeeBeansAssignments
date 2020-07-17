package mytests;

import org.testng.annotations.Test;

import base.MainBaseClass;

public class ClearTripTest extends MainBaseClass {
	
	@Test
	public void clearTripTest() {
		driver.get(configProp.getProperty("ClearTrip"));
	}

}
