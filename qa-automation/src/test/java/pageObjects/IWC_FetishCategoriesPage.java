package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

/** 
 * PAGE OBJECT MODEL (POM): These are assignments for all page objects using 'By' locators. 
 * A POM class is to be created for each individual page for easier maintenance.  Each page 
 * should extend the BasePage class, which includes common methods that can be called by 
 * all pages of a tested site.  
 */
public class IWC_FetishCategoriesPage extends BasePage {
	
	public static String fetishCategoryName;
	public static String fetishCategorySearchTerm;
		
	/*
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_FetishCategoriesPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	
	/*
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By fetishCategoriesLbl = By.xpath("(//h1)[2]"); 
	private By searchFetishCategoriesEdt = By.xpath("//input[@placeholder='Search']");
	
	/*
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters/setters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public String getFetishCategoryName() {
		
		return (fetishCategoryName);
		
	}
	public String getFetishCategorySearchTerm() {
		
		return (fetishCategorySearchTerm);
		
	}
	public WebElement getFetishCategoriesLbl() {
		
		return getElement(fetishCategoriesLbl);
		
	}
	public WebElement getSearchFetishCategoriesEdt() {
		
		return getElement(searchFetishCategoriesEdt);
		
	}
	
	// These class-specific methods will usually return the next landing page's object class.
	
	SoftAssert softAssert = new SoftAssert();
	//Action actions = new Action();
	
	/** Verifies whether fetish category is displayed on the current page. 
	 * 
	 * @param	fetishCategory	the list being referenced (store, item or category)
	 * @return 					the IWC_FetishCategoriesPage class
	 *  
	 */	
	public IWC_FetishCategoriesPage verifyPageDisplaysFetishCategory(String fetishCategory){
		String currentPageFetishCategory = getElement(By.xpath("//h1[@class='top-selling-header']")).getText();
		softAssert.assertEquals(currentPageFetishCategory, fetishCategory.toUpperCase(), "Mismatch found: ");
		return getInstance(IWC_FetishCategoriesPage.class);
	}
	public IWC_FetishCategoriesPage verifyFetishCategoryLinks(String allOrMaxCount) throws InterruptedException {
		
		WebElement categoryLink = null;
		long loopCounterMax = 0;
		
		// collect all of the category links
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='col-xs-12 col-sm-6 col-md-3 fetish-item']"));

		// convert the value of the parameter to a number
		if (allOrMaxCount.equals("all")) {
			loopCounterMax = links.size();
		} else {
			loopCounterMax = Long.parseLong(allOrMaxCount);
		}
		
		// check each category link in the collection
		for (int i = 1; i <= loopCounterMax; i++) {
			driver.get(siteUrl + "fetishes");
			categoryLink = getElement(By.xpath("(//li[@class='col-xs-12 col-sm-6 col-md-3 fetish-item']/a)[" + i + "]"));
			fetishCategoryName = categoryLink.getText();
			doClick(categoryLink);
			verifyPageDisplaysFetishCategory(getFetishCategoryName());
		}
		softAssert.assertAll();
		
		return getInstance(IWC_FetishCategoriesPage.class);
	}
	public IWC_FetishCategoriesPage verifyFetishCategorySearchResults(String searchTerm) throws InterruptedException {
		
		WebElement categoryLink = null;
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='col-xs-12 col-sm-6 col-md-3 fetish-item']"));
		
		for (int i = 1; i <= links.size(); i++) {
			categoryLink = getElement(By.xpath("(//li[@class='col-xs-12 col-sm-6 col-md-3 fetish-item']/a)[" + i + "]"));
			softAssert.assertTrue(categoryLink.getText().toLowerCase().contains(searchTerm.toLowerCase()), searchTerm + " not in " + categoryLink.getText());
		}
		softAssert.assertAll();
		
		return getInstance(IWC_FetishCategoriesPage.class);
	}
}