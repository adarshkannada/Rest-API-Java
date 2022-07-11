package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApiTestBase {
	public Properties prop;
	
	public ApiTestBase() {
		prop = new Properties();
		
		try {
			FileInputStream file = new FileInputStream("C:\\Project\\RestAPITest\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
