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
public class IWG_DashboardPage extends BasePage {

	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWG_DashboardPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
	
	}

	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	public By videosNeedingReviewLnk = By.partialLinkText("Videos Needing Review");
	public By imagesNeedingReviewLnk = By.partialLinkText("Images Needing Review");
	public By documentsNeedingReviewLnk = By.partialLinkText("Documents Needing Review");
	public By messagesNeedingReviewLnk = By.partialLinkText("Messages Needing Review");
	public By customClipScriptsNeedingReviewLnk = By.partialLinkText("Custom Clip Scripts Needing Review");
	public By customClipsNeedingReviewLnk = By.partialLinkText("Custom Clips Needing Review");
	public By totalReviewsDoneTodayLnk = By.partialLinkText("Total Reviews Done Today");
	public By flaggedContentQueueLnk = By.partialLinkText("Flagged Content Queue");
	public By profilePicturesReviewLnk = By.partialLinkText("Profile Pictures Queue");
	public By biometricProfileQueueLnk = By.partialLinkText("Biometric Profile Queue");
	public By revisionsQueueLnk = By.partialLinkText("Revisions Queue");
	
	/**
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getVideosNeedingReviewLnk() {
	
		return getElement(videosNeedingReviewLnk);
	
	}
	
	public WebElement getImagesNeedingReviewLnk() {
		
		return getElement(imagesNeedingReviewLnk);
	
	}
	
	public WebElement getDocumentsNeedingReviewLnk() {
	
		return getElement(documentsNeedingReviewLnk);
	
	}
	
	public WebElement getMessagesNeedingReviewLnk() {
	
		return getElement(messagesNeedingReviewLnk);
	
	}
	
	public WebElement getCustomClipScriptsNeedingReviewLnk() {
	
		return getElement(customClipScriptsNeedingReviewLnk);
	
	}
	
	public WebElement getCustomClipsNeedingReviewLnk() {
		
		return getElement(customClipsNeedingReviewLnk);
	
	}
	
	public WebElement getTotalReviewsDoneTodayLnk() {
		
		return getElement(totalReviewsDoneTodayLnk);
	
	}
	
	public WebElement getFlaggedContentQueueLnk() {
		
		return getElement(flaggedContentQueueLnk);
	
	}
	
	public WebElement getProfilePicturesReviewLnk() {
		
		return getElement(profilePicturesReviewLnk);
	
	}
	
	public WebElement getBiometricProfileQueueLnk() {
		
		return getElement(biometricProfileQueueLnk);
	
	}
	
	public WebElement getRevisionsQueueLnk() {
		
		return getElement(revisionsQueueLnk);
	
	}	
		
}
