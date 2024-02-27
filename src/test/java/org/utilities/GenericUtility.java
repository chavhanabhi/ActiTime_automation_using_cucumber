package org.utilities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtility {
	
	public String getUniqueNumber() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
		String uniqueNo = sdf.format(dt).replaceAll(" ", "").replaceAll("-", "").replaceAll(":", "");
		return uniqueNo; 
	}
	
	/*
	public int getNumberOfRows(Workbook wb, String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
	*/
	
	public void scrollByActions(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();;
	}
	
	public void clickByActions(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele);
	}
	
	public void waitForFrameAndSwitchByfindElements(WebDriver driver, int time, String type, String expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if(type.equals("id")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id(expression))));
		}
		if(type.equals("cssSelector")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(expression))));
		}
		if(type.equals("xpath")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath(expression))));
		}
		if(type.equals("className")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.className(expression))));
		}
		if(type.equals("linkText")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.linkText(expression))));
		}
		if(type.equals("partialLinkText")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.partialLinkText(expression))));
		}
		if(type.equals("tagName")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.tagName(expression))));
		}
		if(type.equals("name")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name(expression))));
		}
	}
	
	public void waitForFrameAndSwitchByele(WebDriver driver, int time, WebElement frameEle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameEle));
	}
	
	public void waitForFrameAndSwitchByType(WebDriver driver, int time, String type, String expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if(type.equals("id")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(expression)));
		}
		if(type.equals("cssSelector")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(expression)));
		}
		if(type.equals("xpath")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(expression)));
		}
		if(type.equals("className")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(expression)));
		}
		if(type.equals("linkText")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.linkText(expression)));
		}
		if(type.equals("partialLinkText")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.partialLinkText(expression)));
		}
		if(type.equals("tagName")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName(expression)));
		}
		if(type.equals("name")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(expression)));
		}
	}
	
	public boolean isAlertPresent(WebDriver driver, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception e){ //TImeoutException
			return false;
		}
	}
	
	public void deselectAllOptions(WebElement ddl) {
		Select sel = new Select(ddl);
		sel.deselectAll();
	}
	
	public void deselectOptionByVisibleText(WebElement ddl, String text) {
		Select sel = new Select(ddl);
		sel.deselectByVisibleText(text);
	}
	
	public void deselectOptionByIndex(WebElement ddl, int index) {
		Select sel = new Select(ddl);
		sel.deselectByIndex(index);
	}
	
	public void deselectOptionByValue(WebElement ddl, String value) {
		Select sel = new Select(ddl);
		sel.deselectByValue(value);
	}
	
	public List<String> getAllSelectedOptionsTextFromDropDown(WebElement ddl) {
		Select sel = new Select(ddl);
		List<String> allTexts = new ArrayList<String>();
		for(int i=0; i<sel.getAllSelectedOptions().size(); i++) {
			allTexts.add(sel.getAllSelectedOptions().get(i).getText());
		}
		return allTexts;
	}
	
	public void selectOptionByVisibleText(WebElement ddl, String text) {
		Select sel = new Select(ddl);
		sel.selectByVisibleText(text);
	}
	
	public void selectOptionByIndex(WebElement ddl, int index) {
		Select sel = new Select(ddl);
		sel.selectByIndex(index);
	}
	
	public void selectOptionByValue(WebElement ddl, String value) {
		Select sel = new Select(ddl);
		sel.selectByValue(value);
	}
	
	public int getCountOfAllOptions(WebElement ddl) {
		Select sel = new Select(ddl);
		return sel.getOptions().size();
	}
	
	public String getSelectedTextFromDropDown(WebElement ddl) {
		Select sel = new Select(ddl);
		return sel.getFirstSelectedOption().getText();
	}
	
	public void sendKeysByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].sendKeys();", ele);
	}
	
	public void clickByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void scrollByJS(WebDriver driver, WebElement ele){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public void scrollByPageDown(WebDriver driver, int numberOfScrolls) {
		WebElement ele = driver.findElement(By.xpath("//html"));
		for(int i=0; i<numberOfScrolls; i++) {
			ele.sendKeys(Keys.PAGE_DOWN);
		}
	}
	
	public List<String> getAllTextFromList(List<WebElement> allEles){
		List<String> allTexts = new ArrayList<String>();
		for(int i=0; i<allEles.size(); i++) {
			allTexts.add(allEles.get(i).getText());
		}
		return allTexts;
	}
	
	public void waitForTitleContains(WebDriver driver, int time, String partialTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	
	public void waitForURLContains(WebDriver driver, int time, String partialURL) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.urlContains(partialURL));
	}
	
	public void waitForVisibilityBy(WebDriver driver, int time, By obj) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj));
	}
	
	public void waitForVisibilityByType(WebDriver driver, int time, String locatorName, String Expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if(locatorName.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(Expression))));
		}else if(locatorName.equalsIgnoreCase("cssSelector")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(Expression))));
		}else if(locatorName.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Expression))));
		}else if(locatorName.equalsIgnoreCase("classname")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(Expression))));
		}else if(locatorName.equalsIgnoreCase("linkText")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("partialLinkText")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("tagName")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName(Expression))));
		}else if(locatorName.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(Expression))));
		}
	}
	
	public void waitForVisibilityByElement(WebDriver driver, int time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public List<WebElement> waitForVisibilityByTypeOfList(WebDriver driver, int time, String locatorName, String Expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		List<WebElement> eleList = new ArrayList<WebElement>(); 
		if(locatorName.equalsIgnoreCase("id")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id(Expression))));
		}else if(locatorName.equalsIgnoreCase("cssSelector")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(Expression))));
		}else if(locatorName.equalsIgnoreCase("xpath")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Expression))));
		}else if(locatorName.equalsIgnoreCase("classname")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className(Expression))));
		}else if(locatorName.equalsIgnoreCase("linkText")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.linkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("partialLinkText")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.partialLinkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("tagName")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName(Expression))));
		}else if(locatorName.equalsIgnoreCase("name")) {
			eleList = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.name(Expression))));
		}
		return eleList;
	}
	
	public void waitForVisibilityByObject(WebDriver driver, int time, String locatorName, String Expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if(locatorName.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Expression)));
		}else if(locatorName.equalsIgnoreCase("cssSelector")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Expression)));
		}else if(locatorName.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Expression)));
		}else if(locatorName.equalsIgnoreCase("classname")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Expression)));
		}else if(locatorName.equalsIgnoreCase("linkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Expression)));
		}else if(locatorName.equalsIgnoreCase("partialLinkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(Expression)));
		}else if(locatorName.equalsIgnoreCase("tagName")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Expression)));
		}else if(locatorName.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Expression)));
		}
	}
	
	public void waitForElementToBeClickableByType(WebDriver driver, int time, String locatorName, String Expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if(locatorName.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(Expression))));
		}else if(locatorName.equalsIgnoreCase("cssSelector")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(Expression))));
		}else if(locatorName.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Expression))));
		}else if(locatorName.equalsIgnoreCase("classname")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(Expression))));
		}else if(locatorName.equalsIgnoreCase("linkText")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("partialLinkText")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("tagName")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.tagName(Expression))));
		}else if(locatorName.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(Expression))));
		}
	}
	
	public void waitForElementToBeClickableByElement(WebDriver driver, int time, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForInvisibilityByType(WebDriver driver, int time, String locatorName, String Expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		if(locatorName.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id(Expression))));
		}else if(locatorName.equalsIgnoreCase("cssSelector")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(Expression))));
		}else if(locatorName.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(Expression))));
		}else if(locatorName.equalsIgnoreCase("classname")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className(Expression))));
		}else if(locatorName.equalsIgnoreCase("linkText")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.linkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("partialLinkText")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.partialLinkText(Expression))));
		}else if(locatorName.equalsIgnoreCase("tagName")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.tagName(Expression))));
		}else if(locatorName.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.name(Expression))));
		}
	}
	
	public void waitForElementToBeSelectedByType(WebDriver driver, int time, String locatorName, String Expression) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		System.out.println(wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath(Expression)))));
	}
	
	public WebDriver startUp(String bName,String url) {
		WebDriver driver = null;
		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(bName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		}
		else if(bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
		}
		else {
			System.out.println("Invalid Browser name");
		}
		//driver.manage().window().maximize();
		//driver.manage().window().minimize(); //selenium 4 onwards
		//driver.manage().window().setSize(new Dimension(550, 700));
		
		//implicit wait applicable for selenium 3 onwards
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//implicit wait upto selenium 3
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public boolean isElementDisplayed(WebElement ele) {
		try{
			return ele.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

}
