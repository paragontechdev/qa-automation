//Author: Marina Lozko
//Co-Author: Kevin McGowan


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
public class IWC_CustomHomePage extends BasePage{
	
	long startTime, endTime, totalTime;
	
	
	public IWC_CustomHomePage (WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
	
	}

	private By customTopStorePage1Image1 = By.xpath("//*[@data-page='1'][1]");
	private By customTopStorePage1Image2 = By.xpath("//*[@data-page='1'][2]");
	private By customTopStorePage1Image3 = By.xpath("//*[@data-page='1'][3]");
	private By customTopStorePage1Image4 = By.xpath("//*[@data-page='1'][4]");
	private By customTopStorePage2Image1 = By.xpath("//*[@data-page='2'][1]");
	private By customTopStorePage2Image2 = By.xpath("//*[@data-page='2'][2]");
	private By customTopStorePage2Image3 = By.xpath("//*[@data-page='2'][3]");
	private By customTopStorePage2Image4 = By.xpath("//*[@data-page='2'][4]");
	private By customTopStorePage3Image1 = By.xpath("//*[@data-page='3'][1]");
	private By customTopStorePage3Image2 = By.xpath("//*[@data-page='3'][2]");
	private By customTopStorePage3Image3 = By.xpath("//*[@data-page='3'][3]");
	private By customTopStorePage3Image4 = By.xpath("//*[@data-page='3'][4]");
	
	private By selectCategoryDropDown = By.xpath("//*[@class='ais-MenuSelect-select form-control']");
		
	private By searchCustomStore = By.id("nav-search-cc");
		
	private By customStoreIcon = By.xpath("//*[@class='col-lg-2 col-md-3 col-sm-6 col-xs-12']");
	 
	public WebElement getCustomTopStorePage1Image1() {
		
		return getElement(customTopStorePage1Image1);
		
	}
	public WebElement getCustomTopStorePage1Image2() {
		
		return getElement(customTopStorePage1Image2);
		
	}
	public WebElement getCustomTopStorePage1Image3() {
		
		return getElement(customTopStorePage1Image3);
		
	}
	public WebElement getCustomTopStorePage1Image4() {
		
		return getElement(customTopStorePage1Image4);
		
	}
	public WebElement getCustomTopStorePage2Image1() {
		
		return getElement(customTopStorePage2Image1);
		
	}
	public WebElement getCustomTopStorePage2Image2() {
		
		return getElement(customTopStorePage2Image2);
		
	}
	public WebElement getCustomTopStorePage2Image3() {
		
		return getElement(customTopStorePage2Image3);
		
	}
	public WebElement getCustomTopStorePage2Image4() {
		
		return getElement(customTopStorePage2Image4);
		
	}
	public WebElement getCustomTopStorePage3Image1() {
		
		return getElement(customTopStorePage3Image1);
		
	}
	public WebElement getCustomTopStorePage3Image2() {
		
		return getElement(customTopStorePage3Image2);
		
	}
	public WebElement getCustomTopStorePage3Image3() {
		
		return getElement(customTopStorePage3Image3);
		
	}
	public WebElement getCustomTopStorePage3Image4() {
		
		return getElement(customTopStorePage3Image4);
		
	}
	public WebElement getSelectCategoryDropDown() {
			
			return getElement(selectCategoryDropDown);
	}	
	public WebElement getSearchCustomStore() {
				
			return getElement(searchCustomStore);	
		
	}
	public WebElement getCustomStoreIcon() {
		
		return getElement(customStoreIcon);	
	
	}
}		