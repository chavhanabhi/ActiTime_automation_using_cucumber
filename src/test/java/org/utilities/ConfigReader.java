package org.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public Properties getProp() {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/org/configurations/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPropData(String key) {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/org/configurations/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
