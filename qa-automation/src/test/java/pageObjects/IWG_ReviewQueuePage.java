package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/** 
 * PAGE OBJECT MODEL (POM): These are assignments for all page objects using 'By' locators. 
 * A POM class is to be created for each individual page for easier maintenance.  Each page 
 * should extend the BasePage class, which includes common methods that can be called by 
 * all pages of a tested site.  
 */
public class IWG_ReviewQueuePage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWG_ReviewQueuePage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	// public WebElement x = driver.findElement(By.id("abc"));
	private By startDateEdt = By.id("min");
	private By endDateEdt = By.id("max");
	private By searchEdt = By.xpath("//input[@type='search']");
	private By generateReportBtn = By.xpath("//span[contains(text(), 'Generate Report')]");
	private By reviewBtn = By.xpath("//tr[1]/td[*]/a[@class='edit btn btn-success btn-sm']");
	private By nextBtn =  By.partialLinkText("Next");
	private By previousBtn = By.linkText("Previous");
	
	private By allLnk = By.linkText("ALL");
	private By openLnk = By.linkText("OPEN");
	private By closedLnk = By.linkText("CLOSED");
	private By unableToCreateLnk = By.linkText("UNABLE TO CREATE");
	private By approvedLnk = By.linkText("APPROVED");
	private By rejectedLnk = By.linkText("REJECTED");
	private By needsRevisionLnk = By.linkText("NEEDS REVISION");
	private By hiveLnk = By.linkText("HIVE");
	private By multiPerformersLnk = By.linkText("MULTI PERFORMERS");
	private By irregularDataLnk = By.linkText("IRREGULAR DATA");
	private By managerReviewLnk = By.linkText("MANAGER REVIEW");
	private By otherLnk = By.linkText("OTHER");
	
	private By searchContentIdEdt = By.xpath("//input[@placeholder='Search Content ID']");
	private By searchHiveEdt = By.xpath("//input[@placeholder='Search Hive']");
	private By searchStoreNameEdt = By.xpath("//input[@placeholder='Search Store Name']");
	private By searchTitleEdt = By.xpath("//input[@placeholder='Search Title']");
	private By searchStatusEdt = By.xpath("//input[@placeholder='Search Status']");
	private By searchDateEdt = By.xpath("//input[@placeholder='Search Date']");
	private By searchPublishDateEdt = By.xpath("//input[@placeholder='Search Publish Date']");
	private By searchMessageIdEdt = By.xpath("//input[@placeholder='Search Message ID']");
	private By searchStoreIdEdt = By.xpath("//input[@placeholder='Search Store Id']");
	private By searchMemberNameEdt = By.xpath("//input[@placeholder='Search Member Name']");
	private By searchMemberIdEdt = By.xpath("//input[@placeholder='Search Member ID']");
	private By searchSearchTypeEdt = By.xpath("//input[@placeholder='Search Type']");
	private By searchMessageDateEdt = By.xpath("//input[@placeholder='Search Message Date']");
	private By searchDeliveryEdt = By.xpath("//input[@placeholder='Search Delivery']");
	private By searchDueDateEdt = By.xpath("//input[@placeholder='Search Due Date']");
	private By searchUrgentEdt = By.xpath("//input[@placeholder='Search Urgent']");
	private By searchReasonForFlagEdt = By.xpath("//input[@placeholder='Search Reason for Flag']");
	private By searchNewStoreEdt = By.xpath("//input[@placeholder='Search New Store']");
	private By searchQueueIdEdt = By.xpath("//input[@placeholder='Search Queue ID']");
	private By searchArtistSubStoreNameEdt = By.xpath("//input[@placeholder='Search Artist/Sub-store Name']");
	private By searchArtistSubStoreIdEdt = By.xpath("//input[@placeholder='Search Artist/Sub-store Id']");
	private By searchRevisionsEdt = By.xpath("//input[@placeholder='Search Revisions']");
	private By storeNameLnk = By.xpath("//div[3]/a");
	private By studioNameLnk = By.xpath("//div[5]/a");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getStartDateEdt() {
		return getElement(startDateEdt);
	}

	public WebElement getEndDateEdt() {
		return getElement(endDateEdt);
	}

	public WebElement getSearchEdt() {
		return getElement(searchEdt);
	}

	public WebElement getGenerateReportBtn() {
		return getElement(generateReportBtn);
	}
	
	public WebElement getReviewBtn() {
		return getElement(reviewBtn);
	}
	
	public WebElement getNextBtn() {
		return getElement(nextBtn);
	}
	
	public WebElement getPreviousBtn() {
		return getElement(previousBtn);
	}
	
	public WebElement getAllLnk() {
		return getElement(allLnk);
	}

	public WebElement getOpenLnk() {
		return getElement(openLnk);
	}

	public WebElement getClosedLnk() {
		return getElement(closedLnk);
	}

	public WebElement getUnableToCreateLnk() {
		return getElement(unableToCreateLnk);
	}

	public WebElement getApprovedLnk() {
		return getElement(approvedLnk);
	}

	public WebElement getRejectedLnk() {
		return getElement(rejectedLnk);
	}

	public WebElement getNeedsRevisionLnk() {
		return getElement(needsRevisionLnk);
	}

	public WebElement getHiveLnk() {
		return getElement(hiveLnk);
	}

	public WebElement getMultiPerformersLnk() {
		return getElement(multiPerformersLnk);
	}

	public WebElement getIrregularDataLnk() {
		return getElement(irregularDataLnk);
	}

	public WebElement getManagerReviewLnk() {
		return getElement(managerReviewLnk);
	}

	public WebElement getOtherLnk() {
		return getElement(otherLnk);
	}
	
	public WebElement getSearchContentIdEdt() {
		return getElement(searchContentIdEdt);
	}

	public WebElement getSearchHiveEdt() {
		return getElement(searchHiveEdt);
	}

	public WebElement getSearchStoreNameEdt() {
		return getElement(searchStoreNameEdt);
	}

	public WebElement getSearchTitleEdt() {
		return getElement(searchTitleEdt);
	}

	public WebElement getSearchStatusEdt() {
		return getElement(searchStatusEdt);
	}

	public WebElement getSearchDateEdt() {
		return getElement(searchDateEdt);
	}

	public WebElement getSearchPublishDateEdt() {
		return getElement(searchPublishDateEdt);
	}

	public WebElement getSearchMessageIdEdt() {
		return getElement(searchMessageIdEdt);
	}

	public WebElement getSearchStoreIdEdt() {
		return getElement(searchStoreIdEdt);
	}

	public WebElement getSearchMemberNameEdt() {
		return getElement(searchMemberNameEdt);
	}

	public WebElement getSearchMemberIdEdt() {
		return getElement(searchMemberIdEdt);
	}

	public WebElement getSearchSearchTypeEdt() {
		return getElement(searchSearchTypeEdt);
	}
	
	public WebElement getSearchMessageDateEdt() {
		return getElement(searchMessageDateEdt);
	}

	public WebElement getSearchDeliveryEdt() {
		return getElement(searchDeliveryEdt);
	}

	public WebElement getSearchDueDateEdt() {
		return getElement(searchDueDateEdt);
	}

	public WebElement getSearchUrgentEdt() {
		return getElement(searchUrgentEdt);
	}

	public WebElement getSearchReasonForFlagEdt() {
		return getElement(searchReasonForFlagEdt);
	}

	public WebElement getSearchNewStoreEdt() {
		return getElement(searchNewStoreEdt);
	}

	public WebElement getSearchQueueIdEdt() {
		return getElement(searchQueueIdEdt);
	}

	public WebElement getSearchArtistSubStoreNameEdt() {
		return getElement(searchArtistSubStoreNameEdt);
	}

	public WebElement getSearchArtistSubStoreIdEdt() {
		return getElement(searchArtistSubStoreIdEdt);
	}

	public WebElement getSearchRevisionsEdt() {
		return getElement(searchRevisionsEdt);
	}
	
	public WebElement getStoreNameLnk() {
		return getElement(storeNameLnk);
	}

	public WebElement getStudioNameLnk() {
		return getElement(studioNameLnk);
	}

	
	// old methods
	public void highlight(By object){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(object);
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	
	}
	
	public void searchAttribute(By headerColumnName, String value) {
		
		driver.findElement(headerColumnName).clear();
		driver.findElement(headerColumnName).sendKeys(value);
	
	}
		
	public void searchAttributeAndReview(By headerColumnName, String value) {
		
		driver.findElement(headerColumnName).clear();
		driver.findElement(headerColumnName).sendKeys(value);
		clickReviewButton(1);
	
	}
		
	public void searchAttributeAndReview(By headerColumnName, String value, int instance) {
		
		driver.findElement(headerColumnName).clear();
		driver.findElement(headerColumnName).sendKeys(value);
		clickReviewButton(instance);
		
	}
	
	
	// methods
	public IWG_ReviewQueuePage clickStoreLink() {
		
		waitUntilElementIsDisplayed(getStoreNameLnk());
		getStoreNameLnk().click();
		
		return getInstance(IWG_ReviewQueuePage.class);		
	}
	
	public IWG_ReviewQueuePage clickStudioLink() {
		
		waitUntilElementIsDisplayed(getStudioNameLnk());
		getStudioNameLnk().click();
		
		return getInstance(IWG_ReviewQueuePage.class);	
		
	}
	
	public IWG_ReviewQueuePage clickReviewButton() {
		
		waitUntilElementIsDisplayed(getReviewBtn());
		getReviewBtn().click();
		
		return getInstance(IWG_ReviewQueuePage.class);	
		
	}
	
	public IWG_ReviewQueuePage clickReviewButton(int instance) {
			
		WebElement reviewBtn = getElement(By.xpath("//tr[" + instance + "]/td[*]/a[@class='edit btn btn-success btn-sm']"));
		waitUntilElementIsDisplayed(reviewBtn);
		getReviewBtn().click();
		
		return getInstance(IWG_ReviewQueuePage.class);	
	}	
	
	public IWG_ReviewQueuePage selectByContentId(String contentId) {
		
		getSearchContentIdEdt().clear();
		getSearchContentIdEdt().sendKeys(contentId);
		getReviewBtn().click();
		
		return getInstance(IWG_ReviewQueuePage.class);
	}
		
	public IWG_ReviewQueuePage selectByStoreName(String storeName) {
		
		waitUntilElementIsDisplayed(getSearchStoreNameEdt());
		getSearchStoreNameEdt().clear();
		getSearchStoreNameEdt().sendKeys(storeName);
		clickReviewButton(1);
		
		return getInstance(IWG_ReviewQueuePage.class);
	}
	
	public IWG_ReviewQueuePage selectByStoreName(String storeName, int instance) {
		
		waitUntilElementIsDisplayed(getSearchStoreNameEdt());
		getSearchStoreNameEdt().clear();
		getSearchStoreNameEdt().sendKeys(storeName);
		clickReviewButton(instance);
		
		return getInstance(IWG_ReviewQueuePage.class);
	}
	
	public IWG_ReviewQueuePage selectByTitle(String title) {
		
		waitUntilElementIsDisplayed(getSearchTitleEdt());
		getSearchTitleEdt().clear();
		getSearchTitleEdt().sendKeys(title);
		clickReviewButton(1);
	
		return getInstance(IWG_ReviewQueuePage.class);	
	}	
	
	public IWG_ReviewQueuePage selectByTitle(String title, int instance) {
		
		waitUntilElementIsDisplayed(getSearchTitleEdt());
		getSearchTitleEdt().clear();
		getSearchTitleEdt().sendKeys(title);
		clickReviewButton(instance);
	
		return getInstance(IWG_ReviewQueuePage.class);	
	
	}
	
	public IWG_ReviewQueuePage selectByStatus(String status) {
		
		waitUntilElementIsDisplayed(getSearchStatusEdt());
		getSearchStatusEdt().clear();
		getSearchStatusEdt().sendKeys(status);
		clickReviewButton(1);
	
		return getInstance(IWG_ReviewQueuePage.class);	
		
	}
	
	public IWG_ReviewQueuePage selectByStatus(String status, int instance) {
		
		waitUntilElementIsDisplayed(getSearchStatusEdt());
		getSearchStatusEdt().clear();
		getSearchStatusEdt().sendKeys(status);
		clickReviewButton(instance);
	
		return getInstance(IWG_ReviewQueuePage.class);	
		
	}
	
	public IWG_ReviewQueuePage selectByPublishDate(String publishDate) {
		
		waitUntilElementIsDisplayed(getSearchPublishDateEdt());
		getSearchPublishDateEdt().clear();
		getSearchPublishDateEdt().sendKeys(publishDate);
		clickReviewButton(1);
	
		return getInstance(IWG_ReviewQueuePage.class);	
		
	}	
			
	public IWG_ReviewQueuePage selectByPublishDate(String publishDate, int instance) {
		
		waitUntilElementIsDisplayed(getSearchPublishDateEdt());
		getSearchPublishDateEdt().clear();
		getSearchPublishDateEdt().sendKeys(publishDate);
		clickReviewButton(instance);
	
		return getInstance(IWG_ReviewQueuePage.class);	
		
	}

	public IWG_ReviewQueuePage selectByHive(String hive) {

		waitUntilElementIsDisplayed(getSearchHiveEdt());
		getSearchHiveEdt().clear();
		getSearchHiveEdt().sendKeys(hive);
		clickReviewButton(1);
	
		return getInstance(IWG_ReviewQueuePage.class);	
				
	}
	
	public IWG_ReviewQueuePage selectByHive(String hive, int instance) {

		waitUntilElementIsDisplayed(getSearchHiveEdt());
		getSearchHiveEdt().clear();
		getSearchHiveEdt().sendKeys(hive);
		clickReviewButton(instance);
	
		return getInstance(IWG_ReviewQueuePage.class);	
				
	}
	
}
