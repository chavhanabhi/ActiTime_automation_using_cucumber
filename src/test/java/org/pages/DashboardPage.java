package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.GenericUtility;

public class DashboardPage extends GenericUtility{
	private WebDriver driver;
	
	//1.WebElements
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;
	
	@FindBy(css = ".content.selected.tt>div:first-child")
	private WebElement timeTrackTab;
	
	@FindBy(css = "td[class*='navItem navCell']>a>div:first-child")
	private List<WebElement> dashboardTabNames;
	
	@FindBy(css = "#topnav tr >td[class^='navItem navCell']:nth-child(2)>a")
	private WebElement timeTrackTabLink;
	
	@FindBy(xpath = "//td[a[@class = 'content tasks']]")
	private WebElement tasksTab;
	
	@FindBy(xpath = "//td[a[@class ='content users']]")
	private WebElement usersTab;
	
	//2.Constructor
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//3.Page Action methods
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	public String getDashboardPageTitle() {
		waitForTitleContains(driver, 10, "Time-Track");
		return driver.getTitle();
	}
	public String getDashboardPageURL() {
		waitForURLContains(driver, 10, "submit_tt");
		return driver.getCurrentUrl();
	}
	public boolean verify4DashboardTabsAreDisplyed() {
		for(int i=0; i<4; i++) {
			try {
				//boolean flag = dashboardTabNames.get(i).isDisplayed();
				//if(flag == false) {
				
				if(!dashboardTabNames.get(i).isDisplayed()) {
					return false;
				}
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}
	public boolean isTimeTrackTabDisplayed() {
		waitForVisibilityByElement(driver, 10, timeTrackTab);
		return timeTrackTab.isDisplayed();
	}
	public int getNumberOfDashboardTabs() {
		return dashboardTabNames.size();
	}
	public boolean isTimeTrackTabSelected() {
		return timeTrackTabLink.getAttribute("class").contains("selected");
	}
	public boolean verifyDashboardTabNames(String[] expTabNames) {
		for(int i=0; i<expTabNames.length; i++) {
			WebElement ele = dashboardTabNames.get(i);
			String actTabName = ele.getText();
			if(!actTabName.equals(expTabNames[i])) {
				return false;
			}
		}
		return true;
	}
	public void clickOnTasksBtn() {
		tasksTab.click();
	}
	public void clickOnUsersTab() {
		usersTab.click();
	}
}
