package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IWP_PhoneStorePage extends BasePage{
	
	long startTime, endTime, totalTime;
	
	
	public IWP_PhoneStorePage (WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
	
	}

/////Phonestorepageqa.iwantclips.com/phone/store/733808/Marynono


	private By ActiveListingBtn = By.xpath("//*[@class='btn btn-default btn-block call-btn']");
	

	
	

	public WebElement getActiveListingBtn() {
		
		return getElement(ActiveListingBtn);
		
	}
	
}	

//////how to choose active listing if more than one active?  *[contains(text(),'Call Now')]   

//// //https://qa.iwantclips.com/model/phone/dashboard

///*[@class="bootstrap-switch-label"] how to switch to ON?