package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.GenericUtility;

public class TasksPage extends GenericUtility{
	private WebDriver driver;
	
	// 1. Web Elements
	
	@FindBy(xpath = "//div[text()='Customers & Projects']")
	private WebElement customerAndProjectHeading;
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(css = "div[class*=createNewCustomer]")
	private WebElement newCustomerBtn;
	
	@FindBy(id = "customerLightBox_nameField")
	private WebElement customerNameField;
	
	@FindBy(id = "customerLightBox_descriptionField")
	private WebElement descriptionField;
	
	@FindBy(xpath = "//span[text()='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath = "//*[contains(text(),'has been created')]")
	private WebElement msg;	
	
	@FindBy(xpath = "//div[@class='addNewContainer']/following-sibling::div//input")
	private WebElement searchField;
	
	@FindBy(xpath = "//div[div[span[text()='xyz']]]/div[4]")
	private WebElement editBtn;
	
	@FindBy(xpath = "//div[@class='customerNamePlaceHolder']/following-sibling::div/div")
	private WebElement actionBtn;
	
	@FindBy(xpath = "//div[@class=\"edit_customer_sliding_panel sliding_panel\"]//div[text()='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(id = "customerPanel_deleteConfirm_submitTitle")
	private WebElement deletePermanentlyBtn;
	
	// 2. Constructor
	public TasksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// 3. Page Action Methods
	public boolean verifyCustomerAndProjectHeadingDisplayed() {
		waitForVisibilityByElement(driver, 10, customerAndProjectHeading);
		return customerAndProjectHeading.isDisplayed();
	}
	public void clickOnAddNewBtn() {
		addNewBtn.click();
	}
	public void clickOnNewCustomerBtn() {
		newCustomerBtn.click();
	}
	public void enterCustomerName(String customerName) {
		customerNameField.sendKeys(customerName);
	}
	public void enterDescription(String description) {
		descriptionField.sendKeys(description);
	}
	public void clickOnCreateCustomerBtn() {
		createCustomerBtn.click();
	}
	public boolean verifyNewCustomerIsCreated() {
		return msg.isDisplayed();
	}
	public void clickOnSearchField() {
		searchField.click();
	}
	public void enterCustomerNameForSearch(String customerName) {
		searchField.sendKeys(customerName);
	}
	public void clickOnEditButton() {
		editBtn.click();
	}
	public void clickOnActionBtn() {
		waitForElementToBeClickableByElement(driver, 5, actionBtn);
		actionBtn.click();
	}
	public void clickOnDeleteBtn() {
		waitForVisibilityByElement(driver, 5, deleteBtn);
		deleteBtn.click();
	}
	public void clickOnDeletePermanentlyBtn() {
		waitForVisibilityByElement(driver, 5, deletePermanentlyBtn);
		deletePermanentlyBtn.click();
	}
}
