package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IWP_PhoneOrderPage extends BasePage{
	
	long startTime, endTime, totalTime;
	
	
	public IWP_PhoneOrderPage (WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
	
	}
/// Phone order page https://qa.iwantclips.com/member/phone/order/71533

	private By ListingRadioBtn = By.xpath("/input[@data-minutes='35']");
	private By SelectCallDurationBtn = By.id("stepOneBtn");
	private By AddFundsForTheCall = By.id("stepOneBtn");
	private By ContinueBtn = By.id("stepTwoBtn");
	private By CountryCodeDrp = By.id("phoneCountry");
	private By SelectUS = By.xpath("[//@id='phoneCountry']/option[229]");
	private By PhoneNumber = By.id("phoneNumber");
	private By StartCallBtn = By.id("stepThreeBtn");
	 
	public WebElement getListingRadioBtn() {
		
		return getElement(ListingRadioBtn);
		
	}
	public WebElement getSelectCallDurationBtn() {
		return getElement(SelectCallDurationBtn);
	}
	public WebElement getAddFundsForTheCall() {
		return getElement(AddFundsForTheCall);
	}
	public WebElement getContinueBtn() {
		
		return getElement(ContinueBtn);
		
	}
	public WebElement getCountryCodeDrp() {
		
		return getElement(CountryCodeDrp);
	}
		
	public WebElement getSelectUS() {
			
			return getElement(SelectUS);	
				
	}
	public WebElement getPhoneNumber() {
		
		return getElement(PhoneNumber);
				
	}
	public WebElement getStartCallBtn() {
		return getElement(StartCallBtn);
	}
}