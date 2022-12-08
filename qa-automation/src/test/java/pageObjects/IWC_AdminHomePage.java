package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** 
 * PAGE OBJECT MODEL (POM): These are assignments for all page objects using 'By' locators. 
 * A POM class is to be created for each individual page for easier maintenance.  Each page 
 * should extend the BasePage class, which includes common methods that can be called by 
 * all pages of a tested site.  
 */
public class IWC_AdminHomePage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_AdminHomePage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By biometricConsentMod = By.xpath("//div[@role='dialog']");
	private By iAgreeBtn = By.xpath("//button/span[text()='I Agree']");
	private By iDisagreeBtn = By.xpath("//button/span[text()='I Disgree']");
	private By emailEdt = By.id("username");
	private By passwordEdt = By.id("password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By cancelBtn = By.xpath("//input[@value='Cancel']");
	private By forgotPasswordLnk = By.linkText("Forgot Password");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	
	public WebElement getBiometricConsentMod() {
			
			return getElement(biometricConsentMod);
			
		}
	
	public WebElement getIAgreeBtn() {
		
		return getElement(iAgreeBtn);
		
	}
	
	public WebElement getIDisagreeBtn() {
		
		return getElement(iDisagreeBtn);
		
	}
	
	public WebElement getEmailEdt() {
		return getElement(emailEdt);
	}
	
	public WebElement getPasswordEdt() {
		return getElement(passwordEdt);
	}
	
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	
	public WebElement getCancelBtn() {
		return getElement(cancelBtn);
	}
	
	public WebElement getForgotPasswordLnk() {
		return getElement(forgotPasswordLnk);
	}

		
	/**
	 * These custom methods will be used with this class. The return type should be the next
	 * landing page object class.
	 */
	public IWC_AdminHomePage login(String username, String password) {
		
		doSendKeys(getEmailEdt(), username);
		doSendKeys(getPasswordEdt(), password);
		doClick(getLoginBtn());
		verifyElementIsNotDisplayed(getLoginBtn());
 		
		return getInstance(IWC_AdminHomePage.class);
	}
	
 	public IWC_AdminHomePage agreeToBiometricDataUse() {
 		
 		doClick(getIAgreeBtn());
 		verifyElementIsNotDisplayed(getBiometricConsentMod());
 		
 		return getInstance(IWC_AdminHomePage.class);
 	}

 	public IWC_AdminHomePage disagreeWithBiometricDataUse() {

 		verifyElementIsDisplayed(getBiometricConsentMod());
 		doClick(getIDisagreeBtn());
 		
 		return getInstance(IWC_AdminHomePage.class);
		
 	}
 	
}

