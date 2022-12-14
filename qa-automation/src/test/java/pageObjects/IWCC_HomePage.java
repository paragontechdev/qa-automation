//Author: Marina Lozko
//Co-Author: Kevin McGowan



//// broken picture link src="/images/avatar480.png"  Store jennajustice

package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class IWCC_HomePage extends BasePage{
	
	long startTime, endTime, totalTime;
	
	
	public IWCC_HomePage (WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
	
	}

	private By customTopStore = By.xpath("//*[@data-page='1'][1]");
	
	// div[@class='top-img'][1] -returns 12 stores  or //*[@data-page='1'] - returns 4 stores
	
	
	////11 more 
	
	
	
	
	
	
	
	
	
	
	
	
	
	private By selectCategoryDropDown = By.xpath(""//*[@class='ais-MenuSelect-select form-control']");
			
			
			
			
			
		///	"//option[@value='ASMR']");
	
	
	
	
	//div[@class='ais-MenuSelect']
	
	
	////*[@class='ais-MenuSelect']
	//////select[@class='ais-MenuSelect-select form-control']
	//option[@value='ASMR']
	
	
	
	private By searchCustomStore = By.id("nav-search-cc");
	
	
	private By customStoreIcon = By.xpath("//*[@class='col-lg-2 col-md-3 col-sm-6 col-xs-12']");
	
	// returns 1st of 60 
	
	
 
	public WebElement getCustomTopStore() {
		
		return getElement(CustomTopStore);
		
	}
	public WebElement getSelectCategoryDropDown() {
			
			return getElement(SelectCategoryDropDown);
	}	
	
	public WebElement getSearchCustomStore() {
				
			return getElement(SearchCustomStore);	
		
	}
	public WebElement getCustomStoreIcon() {
		
		return getElement(CustomStoreIcon);	
	
	}
}		