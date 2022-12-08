package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/** 
 * PAGE OBJECT MODEL (POM): These are assignments for all page objects using 'By' locators. 
 * A POM class is to be created for each individual page for easier maintenance.  Each page 
 * should extend the BasePage class, which includes common methods that can be called by 
 * all pages of a tested site.  
 */
public class IWC_PersonalInformationPage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_PersonalInformationPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By firstNameEdt = By.id("first_name");
	private By lastNameEdt = By.id("last_name");
	private By countryEdt = By.id("country");
	private By emailEdt = By.id("email");
	private By currentPasswordEdt = By.id("password");
	private By newPasswordEdt = By.id("new_password");
	private By confirmPasswordEdt = By.id("conf_password");
	private By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
	private By cancelBtn = By.xpath("//a[contains(text(), 'Cancel')]");
	private By updateSuccessfulMsg = By.xpath("//div[text()='Information updated successfully!']");
		
		
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getFirstNameEdt() {
		
		return getElement(firstNameEdt);
		
	}
	
	public WebElement getLastNameEdt() {
		
		return getElement(lastNameEdt);
		
	}
	
	public WebElement getCountryEdt() {
		
		return getElement(countryEdt);
		
	}
	
	public WebElement getEmailEdt() {
		
		return getElement(emailEdt);
		
	}
	
	public WebElement getCurrentPasswordEdt() {
	
		return getElement(currentPasswordEdt);
	
	}

	public WebElement getNewPasswordEdt() {
	
		return getElement(newPasswordEdt);
	
	}

	public WebElement getConfirmPasswordEdt() {
	
		return getElement(confirmPasswordEdt);
	
	}

	public WebElement getSaveBtn() {
		
		return getElement(saveBtn);
	
	}

	public WebElement getCancelBtn() {
		
		return getElement(cancelBtn);
	
	}

	public WebElement getUpdateSuccessfulMsg() {
		
		return getElement(updateSuccessfulMsg);
		
	}
			
	// methods
	public IWC_PersonalInformationPage updatePassword(String oldPassword, String newPassword) {
		
		// String currentUrl = driver.getCurrentUrl();
		// driver.get("https://qa.iwantclips.com/member/myaccount/edit");
				
		getCurrentPasswordEdt().sendKeys(oldPassword);
		getNewPasswordEdt().sendKeys(newPassword);
		getConfirmPasswordEdt().sendKeys(newPassword);
		getSaveBtn().click();
		
		return getInstance(IWC_PersonalInformationPage.class);
		
	}
	
	public IWC_PersonalInformationPage verifySucessfulUpdate() {
		
		waitForElementPresent(getUpdateSuccessfulMsg());
		
		return getInstance(IWC_PersonalInformationPage.class);
				
	}

}
