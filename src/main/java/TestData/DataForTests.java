package TestData;

import org.testng.annotations.DataProvider;

public class DataForTests {

	@DataProvider(name="dataForApi")
	public Object[][] dataIO() {
		/*
		Object[][] data = new Object[2][4];
		
		data[0][0] = "suvarna";
		data[0][1] = "sura";
		data[0][2] = "padukone";
		data[0][3] = 4;
		
		data[1][0] = "revanna";
		data[1][1] = "navi";
		data[1][2] = "gokak";
		data[1][3] = 4;
		
		return data; */
		
		return new Object[][] {
			{"koteshwara", "kere", "kone", 1},
			{"banna", "kirana", "ooru", 2},
			{"siri", "shree", "malur", 1}
		};
		
	}
	
	
	@DataProvider(name = "deleteData")
	public Object[] apiDataDelete() {
		
		return new Object[] {
				13,18,19
		};
	}
	
}
