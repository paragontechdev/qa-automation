package pageObjects;

import java.util.List;
import java.util.Random;

import org.testng.asserts.SoftAssert;
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
public class IWC_ArtistsPage extends BasePage{

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_ArtistsPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By searchArtistsEdt = By.xpath("//input[@placeholder='Search Artists']");
	private By sortLst = By.xpath("//select[@class='ais-SortBy-select']");
	private By recentlyActiveOpt = By.xpath("//option[text()='Recently Active']");
	private By alphabeticalOpt = By.xpath("//option[text()='Alphabetical']");
	private By newestOpt = By.xpath("//option[text()='Newest']");
	private By oldestOpt = By.xpath("//option[text()='Oldest']");
	private By addToCartBtn = By.xpath("//button[contains(text(), 'Add to Cart')][1]");
	private By storeItemDescriptionTxt = By.xpath("(//div[@class='col-xs-12 description fix']/span)[2]");
	private By storeItemCategoriesTxt = By.xpath("(//div[@class='col-xs-12 category fix'])[2]");
	private By previewClipImg = By.xpath("//img[@class='videoPlayer show-flexible-picture']");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getSearchArtistsEdt() {
		
		return getElement(searchArtistsEdt);
	
	}
	public WebElement getSortLst() {
		return getElement(sortLst);
	}
	public WebElement getRecentlyActiveOpt() {
		return getElement(recentlyActiveOpt);
	}
	public WebElement getAlphabeticalOpt() {
		return getElement(alphabeticalOpt);
	}
	public WebElement getNewestOpt() {
		return getElement(newestOpt);
	}
	public WebElement getOldestOpt() {
		return getElement(oldestOpt);
	}
	public WebElement getAddToCartBtn() {
		return getElement(addToCartBtn);
	}
	public WebElement getStoreItemDescriptionTxt() {
		return getElement(storeItemDescriptionTxt);
	}
	public WebElement getStoreItemCategoriesTxt() {
		return getElement(storeItemCategoriesTxt);
	}
	public WebElement getPreviewClipImg() {
		return getElement(previewClipImg);
	}
	
	
	
	Random random = new Random();
	SoftAssert softAssert = new SoftAssert();
	
	public IWC_ArtistsPage selectAndVerifyAllArtistLinks(String allOrMaxCount) throws Exception{
	
		int xPathIndex = 0;
		long loopCounterMax = 0;
		
		// Get the total number of artist images on the page and click a random one
		List<WebElement> artistImageLinks = driver.findElements(By.xpath("//a[@class='click-hit']"));
		
		// convert the value of the parameter to a number
		if (allOrMaxCount.equals("all")) {
			loopCounterMax = artistImageLinks.size();
		} else {
			loopCounterMax = Long.parseLong(allOrMaxCount);
		}
	
		// check each category link in the collection
		for (xPathIndex = 1; xPathIndex <= loopCounterMax; xPathIndex++) {
			//driver.get(siteUrl + "artists");
			doNavigateToPage("Artists");
			WebElement artistLink = getElement(By.xpath("(//img[@class='img-responsive img-circle click-hit'])[" + xPathIndex + "]"));
			IWC_StorePage.storeArtistName = artistLink.getAttribute("alt");
			doClick(artistLink);
			
			// Store the artist name to a IWC_StorePage class variable
			IWC_StorePage store = new IWC_StorePage(driver, wait);
			store.verifyStoreHomeDisplaysArtistName(store.getStoreArtistName());
		}
		softAssert.assertAll();
		
		return getInstance(IWC_ArtistsPage.class);
	}
	public IWC_ArtistsPage selectAndVerifyRandomArtistPage() throws Exception{
		int xPathIndex = 0;
		
		// Get the total number of artist images on the page and click a random one
		List<WebElement> artistImageLinks = driver.findElements(By.xpath("//a[@class='click-hit']"));
		xPathIndex = random.nextInt(artistImageLinks.size()) + 1;
		WebElement artistLink = getElement(By.xpath("(//img[@class='img-responsive img-circle click-hit'])[" + xPathIndex + "]"));
		IWC_StorePage.storeArtistName = artistLink.getAttribute("alt");
		doClick(artistLink);
		
		// Store the artist name to a IWC_StorePage class variable
		IWC_StorePage store = new IWC_StorePage(driver, wait);
		store.verifyStoreHomeDisplaysArtistName(store.getStoreArtistName());
		
		return getInstance(IWC_ArtistsPage.class);
	}
	public IWC_ArtistsPage doSelectRandomStoreItem(){
		
		Random random = new Random();
		int xPathIndex = 0;
	
		//get the total number of item images on the page and click a random one
		List<WebElement> itemImageLinks = driver.findElements(By.xpath("//img[@class='lazy click-hit']"));
		xPathIndex = random.nextInt(itemImageLinks.size()) + 1;
		WebElement imageLink = getElement(By.xpath("(//img[@class='lazy click-hit'])[" + xPathIndex + "]"));
		doClick(imageLink);
				
		return getInstance(IWC_ArtistsPage.class);
	}
	public IWC_ArtistsPage verifyItemDescriptionPageElements() throws Exception{
		
		verifyElementIsDisplayed(getAddToCartBtn());
		verifyElementIsDisplayed(getPreviewClipImg());
		verifyElementIsDisplayed(getStoreItemDescriptionTxt());
		verifyElementIsDisplayed(getStoreItemCategoriesTxt());
		
		for (int i = 1; i <=4 ; i++) {
			verifyElementIsDisplayed(getElement(By.xpath("//div[contains(@id, 'clip-')][1]")));
		}
		
		//Items in the “Top Selling Content” section are displaying properly
		return getInstance(IWC_ArtistsPage.class);
	}
	
}
