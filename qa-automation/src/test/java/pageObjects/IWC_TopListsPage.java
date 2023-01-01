package pageObjects;

import java.util.Random;
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
	
	/*
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_TopListsPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	
	/*
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By topStore1Lnk = By.xpath("(//a[@class='topLink'])[1]"); 
	private By topStore2Lnk = By.xpath("(//a[@class='topLink'])[2]");
	private By topStore3Lnk = By.xpath("(//a[@class='topLink'])[3]");
	private By showAllTop100StoresLnk = By.xpath("//a[contains(text(), 'Show all 100 Top Stores')]");
	private By showAllTop100ItemsLnk = By.xpath("//a[contains(text(), 'Show all 100 Top Items')]");
	private By showAllTop100CategoriesLnk = By.xpath("//a[contains(text(), 'Show all 100 Top Categories')]");
	
	
	/*
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
	public WebElement getShowAllTop100ItemsLnk() {
		
		return getElement(showAllTop100ItemsLnk);
		
	}
	public WebElement getShowAllTop100CategoriesLnk() {
		
		return getElement(showAllTop100CategoriesLnk);
		
	}
	
	
	// These class-specific methods will usually return the next landing page's object class.
	/** Returns the artist name of a ranked top list store. 
	 * 
	 * The rank is used to reference the xPath instance, which indexes at '1'. Stores 1-3 are 
	 * accessed using the top 3 image links, which are in their own container. Stores 4-100 are in 
	 * a separate container, so link 4 will be the first xPath instance in that container (rank - 3).
	 * 
	 * The text from the web element is shown on two lines. The first line is the rank, the second line 
	 * is the artist name. The artist name is parsed and saved to static variable in the IWC_StorePage
	 * class where it can be used to determine whether a link is referencing the correct page. 
	 * 
	 * @param	rank	the rank of the store whose artist's name is to be returned
	 * @return 			the artist name of the ranked store
	 *  
	 */
	private String getRankedStore_ArtistName(int rank) {
		WebElement element = null;
		
		// get the xPath of the ranked store link (ranked 1-3)
		if (rank <= 3){
			element = getElement(By.xpath("(//h3[@class='topName'])[" + rank + "]"));
		
		// get the xPath of the ranked store link (ranked > 3)
		} else {
			rank -= 3;
			element = getElement(By.xpath("(//div[@class='topBox'])[" + rank + "]"));
		}
		
		// Parse text for the artist name 
		IWC_StorePage.storeArtistName = element.getText().split("\n")[1];
		return IWC_StorePage.storeArtistName;
	}	
	private String getRankedItem_ArtistName(int rank) {
		WebElement element = null;
		
		// get the xPath of the ranked item link (ranked 1-3)
		element = getElement(By.xpath("(//span[@class='pink'])[" + rank + "]"));
				
		// Parse text for the artist name 
		IWC_StorePage.storeArtistName = element.getText();
		return IWC_StorePage.storeArtistName;
	}
	private String getRankedItem_ItemName(int rank) {
		WebElement element = null;
		
		// get the xPath of the ranked item link (ranked 1-3)
		element = getElement(By.xpath("(//p[@class='rankTitle'])[" + rank + "]"));
				
		// Parse text for the artist name 
		IWC_StorePage.storeItemName = element.getText();
		return IWC_StorePage.storeItemName;
	}
	
	
	/** Clicks a random Top List store, item or category. 
	 * 
	 * A randomly generated number (between 1 and 100) is passed to the <b>doClickRankedListElement</b> method 
	 * as the 'rank' parameter for that method. This method is useful when the rank of the store, item or 
	 * category is not specified or must be random. 
	 * 
	 * @param	listType	the list being referenced (store, item or category)
	 * @return 				the IWC_TopListsPage class
	 * @throws	Exception 
	 *  
	 */	
	public IWC_TopListsPage doClickRandomTop100(String listType) throws Exception {
		
		// generate a random number between 1 and 100
		Random random = new Random();
		int rank = random.nextInt(100) + 1;
		
		// use generated number to click a ranked list item (store, item or category)
		doClickRankedListElement(listType, rank);
		
		return getInstance(IWC_TopListsPage.class);
	}
	public IWC_TopListsPage doClickRankedListElement(String listType, int rank) throws Exception {
		
		WebElement element = null;
		
		if (rank > 0 && rank <=100) { 
		
			// find the web element on the page
			try {
				switch(listType) {
				case "item":
					getRankedItem_ItemName(rank);
					getRankedItem_ArtistName(rank);
					element = driver.findElement(By.xpath("(//h3[contains(text(), '#" + rank + "')])[3]"));
					break;
				case "store":
					getRankedStore_ArtistName(rank);
					if (rank <= 3){
						element = driver.findElement(By.xpath("(//div[@class='roundModelPic'])[" + rank + "]/img[@class='img-circle img-responsive']"));
					} else {
						rank -= 3;
						element = driver.findElement(By.xpath("(//div[@class='topBox'])[" + rank + "]/div/img[@class='img-circle img-responsive']"));
					}
					break;
				case "category":
					break;
				}
				
				// move to element, then click on it				
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().perform();;
				
			} catch(Exception e) {
				throw new Exception("Error finding or clicking ranked item link.");
			}
		} else {
			
			throw new Exception("Rank must be between 1 and 100.");
		}
		
		return getInstance(IWC_TopListsPage.class);
		
	}
	public IWC_TopListsPage verifyTopListsAreDisplayed(int listCount, String listType) throws Exception {
		
	    if (listCount <= 0 || listCount > 100) {
	        throw new IllegalArgumentException("$listCount is invalid. Select between 1-100.");
	    }
	    
	    int xPathIndex;
	    switch (listType) {
	      case "stores":
	        xPathIndex = listCount > 3 ? 1 : 1;
	        break;
	      case "items":
	        xPathIndex = listCount > 3 ? 3 : 2;
	        break;
	      case "categories":
	        xPathIndex = listCount > 3 ? 4 : 3;
	        break;
	      default:
	        throw new IllegalArgumentException("Invalid listType: $listType");
	    }
    
        By tmp = By.xpath("(//*[(text()='#" + listCount + "')])[" + xPathIndex + "]");
        doScrollToElement(getElement(tmp));
		verifyElementIsEnabled(getElement(tmp));
	    
	    return getInstance(IWC_TopListsPage.class);
	}
	
}