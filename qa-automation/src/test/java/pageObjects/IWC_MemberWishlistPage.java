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
public class IWC_MemberWishlistPage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_MemberWishlistPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By addToCartBtn = By.xpath("//button[@class='btn btn-default cart addToCart']");
	private By addToCartDropdownBtn = By.xpath("//button[@class='btn btn-default dropdown-toggle cartDropdown']");
	private By addToWishListBtn = By.xpath("//button[@class='btn btn-default dropdown-toggle cartDropdown']");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getAddToCartBtn() {
		
		return getElement(addToCartBtn);
		
	}
	
	public WebElement getAddToCartDropdownBtn() {
		
		return getElement(addToCartDropdownBtn);
		
	}
		
	public WebElement getAddToWishListBtn() {
		
		return getElement(addToWishListBtn);
		
	}
		
	/**
	 * These are the methods that will be used with this class. The return type should be the next 
	 * landing page object class.
	 */
	public IWC_MemberWishlistPage addToCart(String itemId) {
		
		driver.get("https://qa.iwantclips.com/store/item/" + itemId);
		
		return getInstance(IWC_MemberWishlistPage.class);
	}

	public IWC_MemberWishlistPage addToWishlist(String itemId) {
		
		driver.get("https://qa.iwantclips.com/my_store/add_member_wishlist/" + itemId);
		
		return getInstance(IWC_MemberWishlistPage.class);		
	}

	public IWC_MemberWishlistPage verifyWishlistItem(String itemId) {
		
		driver.get("https://qa.iwantclips.com/member/content/wishlist");
		
		verifyElementIsDisplayed(getElement(By.xpath("//span/a[contains(@href, '" + itemId + "')]")));
		
		return getInstance(IWC_MemberWishlistPage.class);		
	}
		 
}
