package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** 
 * PAGE OBJECT MODEL (POM): These are assignments for all page objects using 'By' locators. 
 * A POM class is to be created for each individual page for easier maintenance.  Each page 
 * should extend the BasePage class, which includes common methods that can be called by 
 * all pages of a tested site.  
 */
public class IWC_TopListsPage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_TopListsPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	
	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By topStore1Lnk = By.xpath("(//a[@class='topLink'])[1]"); 
	private By topStore2Lnk = By.xpath("(//a[@class='topLink'])[2]");
	private By topStore3Lnk = By.xpath("(//a[@class='topLink'])[3]");
	private By showAllTop100StoresLnk = By.xpath("//input[@id='email']");
	
		
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getTopStore1Lnk() {
		
		return getElement(topStore1Lnk);
		
	}
	public WebElement getTopStore2Lnk() {

		return getElement(topStore2Lnk);
		
	}
	public WebElement getTopStore3Lnk() {
		
		return getElement(topStore3Lnk);
		
	}
	public WebElement getShowAllTop100StoresLnk() {
		
		return getElement(showAllTop100StoresLnk);
		
	}

	
	/**
	 * These custom methods will be used with this class. The return type should be the next
	 * landing page object class.
	 */
	public String getRankedArtistName(String rankNumber) {
		
		int intRank = Integer.parseInt(rankNumber);
		WebElement element = null;
		
		try {
			if (intRank <= 3){
				element = driver.findElement(By.xpath("(//h3[@class='topName'])[" + intRank + "]"));
			} else {
				intRank -= 3;
				//element = driver.findElement(By.xpath("(//div[@class='topBox']/h4[text()= '#" + intRank + "'])[1]"));
				element = driver.findElement(By.xpath("(//div[@class='topBox'])[" + intRank + "]"));
			}
		} catch(Exception e) {
			System.out.println("Error finding ranked artist.");
		}
		
		return element.getText();
		
	}	
	public IWC_TopListsPage doClickRankedArtistLink(String rankNumber) {
		
		int intRank = Integer.parseInt(rankNumber);
		WebElement element = null;
		
		try {
			if (intRank <= 3){
				element = driver.findElement(By.xpath("(//div[@class='roundModelPic'])[" + intRank+ "]/img[@class='img-circle img-responsive']"));
			} else {
				intRank -= 3;
				element = driver.findElement(By.xpath("(//div[@class='topBox'])[" + intRank + "]/div/img[@class='img-circle img-responsive']"));
			}
			
			doClick(element);
			
		} catch(Exception e) {
			System.out.println("Error clicking ranked artist list.");
		}
		
		return getInstance(IWC_TopListsPage.class);
		
	}

}
