package org.applicationHooks;

import java.io.File;
import java.util.Properties;

import org.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.ConfigReader;
import org.utilities.GenericUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	public static Properties prop;
	public static WebDriver driver;
	public static Scenario scn;
	
	@Before(order = 1)		//1st
	public void init(Scenario scn) {
		ConfigReader cr = new ConfigReader();
		prop = cr.getProp();
		AppHooks.scn = scn;
		DriverFactory df = new DriverFactory();
		driver = df.init_driver(prop.getProperty("bName"));
	}
	/*
	@Before(order = 2)
	public void test2() {
		
	}
	*/
	/*
	@After(order = 4)		//3rd
	public void tearDown() {
		driver.close();
	}
	*/
	@After(order = 9)		//2nd
	public void getScreenShotForSceanario() {
		if(scn.isFailed()){
			try {
				String scnName = scn.getName().replaceAll(" ", "");
				GenericUtility gu = new GenericUtility();
				//String name = gu.getUniqueNumber();
				//File scnFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + scnName + "_" + gu.getUniqueNumber() + ".png");
				TakesScreenshot ts = (TakesScreenshot)driver;
//				String s =  ts.getScreenshotAs(OutputType.BASE64);
				byte[] s =  ts.getScreenshotAs(OutputType.BYTES);
				AppHooks.scn.attach(s, "image/png", scnName+gu.getUniqueNumber()+".png");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*@After(order = 9)
	public void getScreenshot()
	{
	//take screenshot and save it in folder
	  try {
		  Date d = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
		  String name = sdf.format(d).replaceAll(" ","").replaceAll("-","").replaceAll(":","");
		  //21102023212845456
		  File scnFile = new File(System.getProperty("user.dir") + "\\screenshots\\"+name+".png");
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File f_obj =  ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(f_obj , scnFile );
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
	}*/
}
