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
public class IWG_LoginPage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWG_LoginPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	
	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By emailEdt = By.xpath("//input[@id='email']");
	private By passwordEdt = By.xpath("//input[@id='password']");
	private By rememberMeChk = By.xpath("//input[@id='remember']");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By forgotYourPasswordLnk = By.linkText("Forgot Your Password?");
	
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getEmailEdt() {
		
		return getElement(emailEdt);
		
	}
	public WebElement getPasswordEdt() {

		return getElement(passwordEdt);
		
	}
	public WebElement getForgotYourPasswordLnk() {
		
		return getElement(forgotYourPasswordLnk);
		
	}
	public WebElement getLoginBtn() {
		
		return getElement(loginBtn);
		
	}
	public WebElement getRememberMeChk() {
		
		return getElement(rememberMeChk);
	
	}
	public void setEmailEdt(By username) {
		this.emailEdt = username;
	}
	public void setPasswordEdt(By password) {
		this.passwordEdt = password;
	}
		
	
	/**
	 * These are the methods that will be used with this class. The return type should be the next 
	 * landing page object class.
	 */
	public IWC_HomePage login(String username, String password) {
		
		setEmailEdt(emailEdt);
		setPasswordEdt(passwordEdt);
		doClick(getLoginBtn());
				
		// return next landing page class object
		return getInstance(IWC_HomePage.class);
	}
	
}
