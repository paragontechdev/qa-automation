package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IWC_ShoppingCartPage extends BasePage {
	
	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}
	
	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By amountRad;
	private By searchClipsEdt = By.xpath("//button/*[text()='I Agree']");
	private By emptyCartBtn = By.linkText("Empty Cart']");
	private By artistPromoCodeEdt = By.name("promoInput");
	private By artistPromoCodeApplyBtn = By.id("//button[text()='Apply']");
	private By iWantClipsPromoCodeEdt = By.id("code");
	private By iWantClipsPromoCodeApplyBtn = By.id("general_apply_btn");
	private By checkoutBtn = By.xpath("//button[text()='Checkout']");
	private By notEnoughFundsAlr = By.xpath("//div[contains(text(), 'Not enough funds.')]");
	private By successfulAlr = By.xpath("//*[@class='successMessage'");
	
	private By creditCardNumberEdt = By.xpath("//input[@*='card_number'] | //input[@*='creditCard']");
	private By expirationMonthDrp = By.id("month");
	private By expirationYearDrp = By.id("year");
	private By ccvEdt = By.id("ccv");
	private By firstNameEdt = By.id("firstName");
	private By lastNameEdt = By.id("lastName");
	private By addressEdt = By.name("bill_street");
	private By cityEdt = By.xpath("//input[@*='bill_city']");
	private By stateDrp = By.id("bill_state_select");
	private By phoneNumberEdt = By.xpath("//input[@*='cust_phone']");
	private By countryDrp = By.name("bill_country");				
	private By zipCodeEdt = By.name("bill_zip");
	private By completeOrderBtn = By.xpath("//button[text()='Complete Order']");
	private By emailEdt = By.id("Email");
	private By confirmEmailEdt = By.id("EmailConfirmation");
	private By iAgreeChk = By.xpath("//input[@type='checkbox' and contains(@name, 'agree')]");
	private By tipOrTributeSentAlr = By.xpath("//*[@class='successMessage'");
	
	
	/** 
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getSearchClipsEdt() {
		
		return getElement(searchClipsEdt);
	
	}
	public WebElement getEmptyCartBtn() {
		
		return getElement(emptyCartBtn);
	
	}
	public WebElement getArtistPromoCodeEdt() {
		
		return getElement(artistPromoCodeEdt);
	
	}
	public WebElement getArtistPromoCodeApplyBtn() {
		
		return getElement(artistPromoCodeApplyBtn);
	
	}
	public WebElement getIWantClipsPromoCodeEdt() {
		
		return getElement(iWantClipsPromoCodeEdt);
	
	}
	public WebElement getIWantClipsPromoCodeApplyBtn() {
		
		return getElement(iWantClipsPromoCodeApplyBtn);
	
	}
	public WebElement getNotEnoughFundsAlr() {
		
		return getElement(notEnoughFundsAlr);
	
	}
	public WebElement getCheckoutBtn() {
		return getElement(checkoutBtn);	
	}
	public WebElement getSuccessfulAlr() {
		return getElement(successfulAlr);
	}
	
	public WebElement getCreditCardNumberEdt() {
		return getElement(creditCardNumberEdt);
	}
	public WebElement getExpirationMonthDrp() {
		return getElement(expirationMonthDrp);
	}
	public WebElement getExpirationYearDrp() {
		return getElement(expirationYearDrp);
	}
	public WebElement getCcvEdt() {
		return getElement(ccvEdt);
	}
	public WebElement getFirstNameEdt() {
		return getElement(firstNameEdt);
	}
	public WebElement getLastNameEdt() {
		return getElement(lastNameEdt);
	}
	public WebElement getCountryDrp() {
		return getElement(countryDrp);
	}
	public WebElement getStateDrp() {
		return getElement(stateDrp);
	}
	public WebElement getAddressEdt() {
		return getElement(addressEdt);
	}
	public WebElement getCityEdt() {
		return getElement(cityEdt);
	}
	public WebElement getZipCodeEdt() {
		return getElement(zipCodeEdt);
	}
	public WebElement getPhoneNumberEdt() {
		return getElement(phoneNumberEdt);
	}
	public WebElement getCompleteOrderBtn() {
		return getElement(completeOrderBtn);
	}
	public WebElement getEmailEdt() {
		return getElement(emailEdt);
	}
	public WebElement getConfirmEmailEdt() {
		return getElement(confirmEmailEdt);
	}
	public WebElement getIAgreeChk() {
		return getElement(iAgreeChk);
	}
	public WebElement getTipOrTributeSentAlr() {
		return getElement(tipOrTributeSentAlr);
	}
	
	
	/** 
	 * These custom methods will be used with this class. 
	 * For submitted pages, the return type should be the next landing page object class.
	 * @throws Exception 
	 */
 	public IWC_ShoppingCartPage checkout(String userType) throws Exception {
		
		doClick(getCheckoutBtn());
		submitPaymentInfo(userType);
		verifyElementIsDisplayed(getSuccessfulAlr());
		
		return getInstance(IWC_ShoppingCartPage.class);
		
	}
	public IWC_ShoppingCartPage addFunds(String amount) {
		
		amountRad = By.xpath("//input[@type='radio' and @value='" + amount + "']");
		doClick(getElement(amountRad));
		
		return getInstance(IWC_ShoppingCartPage.class);
	
	}
	protected IWC_ShoppingCartPage submitPaymentInfo(String userType) throws Exception {
		
		// cc info, name , address and phone
		doSendKeys(getCreditCardNumberEdt(), "378282246310005");
		doSelect(getExpirationMonthDrp(), "01");
		doSelect(getExpirationYearDrp(), "2024");
		doSendKeys(getCcvEdt(), "123");
		doSendKeys(getFirstNameEdt(), "John");
		doSendKeys(getLastNameEdt(), "Doe");
		doSendKeys(getAddressEdt(), "123 Any St");
		doSendKeys(getCityEdt(), "Anywhere");
		doSelect(getCountryDrp(), "United States");
		doSelect(getStateDrp(), "California");
		doSendKeys(getZipCodeEdt(), "12345");
		doSendKeys(getPhoneNumberEdt(), "1234567890");
		
		// guest checkout requires email
		if (userType.toLowerCase().compareTo("guest") == 0){
			doSendKeys(getEmailEdt(), "test@iwantclips.com");
			doSendKeys(getConfirmEmailEdt(), "test@iwantclips.com");
		}
		
		// agree to terms and submit
		doClick(getIAgreeChk());
		doClick(getCompleteOrderBtn());
		
		return getInstance(IWC_ShoppingCartPage.class);
	}
	

}