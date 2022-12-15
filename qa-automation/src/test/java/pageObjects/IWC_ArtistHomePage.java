package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IWC_ArtistHomePage extends BasePage {
	
	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_ArtistHomePage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}
	
	
	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By biometricInfoIAgreeBtn = By.xpath("//button/*[text()='I Agree']");
	private By biometricInfoIDisagreeBtn = By.xpath("//button/*[text()='I Disagree']");
	private By biometricInfoMod = By.xpath("//div[@role='dialog']");
	private By artistLinkLnk = By.xpath("(//a[text()='qaartist'])[1]");
	
	// tabs
	private By newsTab = By.xpath("(//a/span[text()='News'])[2]");
	private By accountTab = By.xpath("(//a/span[text()='Account'])[2]");
	
	// Sell tab
	private By sellItemsTab = By.xpath("(//a/span[text()='Sell Items'])[2]");
	private By titleEdt = By.name("title");
	private By descriptionEdt = By.id("description");
	private By categoryDrp = By.id("category_chzn");
	private By keywordsEdt = By.name("price");
	private By priceEdt = By.name("price");
	private By uploadVideoEdt = By.name("file_name_2");
	private By browseBtn = By.id("content_upload_input");
	private By videoLengthEdt = By.name("video_length");
	private By videoResolutionEdt = By.name("video_resolution"); 
	private By waitingForVideoBtn = By.id("model_agreement");
	private By launchPreviewGeneratorBtn = By.className("pink-btn launch-pg-btn");
	private By saveProgressRad;
	private By hideItemRad;
	private By containsNudityRad;
	private By containsSpecialEffectsRad;
	private By doYouAppearRad;
	private By multiplePerformersRad;
	private By agreementChk = By.id("model_agreement");
	private By saveBtn = By.id("savebtn");
	
	// other tabs
	private By archivedContentTab = By.xpath("(//a/span[text()='Archived Content'])[2]");
	private By payoutsTab = By.xpath("(//a/span[text()='Payouts'])[2]");
	private By transactionsTab = By.xpath("(//a/span[text()='Transactions'])[2]");
	private By promoToolsTab = By.xpath("(//a/span[text()='Promo Tools'])[2]");
	private By referralsTab = By.xpath("(//a/span[text()='Referrals'])[2]");
	private By widgetsTab = By.xpath("(//a/span[text()='Widgets'])[2]");
	private By tutorialsTab = By.xpath("(//a/span[text()='Tutorials'])[2]");
	private By phoneTab = By.xpath("(//a/span[text()='Phone'])[2]");
	private By customsTab = By.xpath("(//a/span[text()='Customs'])[2]");
	private By socialTab = By.xpath("(//a/span[text()='Social'])[2]");
	private By blockingTab = By.xpath("(//a/span[text()='Blocking'])[2]");
	private By performerProfilesTab = By.xpath("(//a/span[text()='Performer Profiles'])[2]");
	private By addAVideoBttn = By.partialLinkText("content_factory/videos/add");
	private By addAPictureBtn =  By.partialLinkText("content_factory/pictures/add");
	private By addAPdfDocAudioBtn =  By.partialLinkText("content_factory/items/add");
	
	
	/** 
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getBiometricInfoIAgreeBtn() {
		
		return getElement(biometricInfoIAgreeBtn);
	
	}
	public WebElement getBiometricInfoIDisagreeBtn() {
		
		return getElement(biometricInfoIDisagreeBtn);
	
	}
	public WebElement getBiometricInfoMod() {
		return getElement(biometricInfoMod);
	}
	public WebElement getArtistLinkLnk() {
		return getElement(artistLinkLnk);
	}
	
	public WebElement getNewsTab() {
		return getElement(newsTab);
	}
	public WebElement getAccountTab() {
		return getElement(accountTab);
	}
		
	public WebElement getSellItemsTab() {
		return getElement(sellItemsTab);
	}
	public WebElement getArchivedContentTab() {
		return getElement(archivedContentTab);
	}
	public WebElement getPayoutsTab() {
		return getElement(payoutsTab);
	}
	public WebElement getTransactionsTab() {
		return getElement(transactionsTab);
	}
	public WebElement getPromoToolsTab() {
		return getElement(promoToolsTab);
	}
	public WebElement getReferralsTab() {
		return getElement(referralsTab);
	}
	public WebElement getWisgetsTab() {
		return getElement(widgetsTab);
	}
	public WebElement getTutorialsTab() {
		return getElement(tutorialsTab);
	}
	public WebElement getPhoneTab() {
		return getElement(phoneTab);
	}
	public WebElement getCustomsTab() {
		return getElement(customsTab);
	}
	public WebElement getSocialTab() {
		return getElement(socialTab);
	}
	public WebElement getBlockingTab() {
		return getElement(blockingTab);
	}
	public WebElement getPerformerProfilesTab() {
		return getElement(performerProfilesTab);
	}
	public WebElement getWidgetsTab() {
		return getElement(widgetsTab);
	}
	public WebElement getAddAVideoBttn() {
		return getElement(addAVideoBttn);
	}
	public WebElement getAddAPictureBtn() {
		return getElement(addAPictureBtn);
	}
	public WebElement getAddAPdfDocAudioBtn() {
		return getElement(addAPdfDocAudioBtn);
	}
	
	// Sell tab 
 	public WebElement getTitleEdt() {
		return getElement(titleEdt);
	}
	public WebElement getDescriptionEdt() {
		return getElement(descriptionEdt);
	}
	public WebElement getCategoryDrp() {
		return getElement(categoryDrp);
	}
	public WebElement getKeywordsEdt() {
		return getElement(keywordsEdt);
	}
	public WebElement getPriceEdt() {
		return getElement(priceEdt);
	}
	public WebElement getUploadVideoEdt() {
		return getElement(uploadVideoEdt);
	}
	public WebElement getBrowseBtn() {
		return getElement(browseBtn);
	}
	public WebElement getVideoLengthEdt() {
		return getElement(videoLengthEdt);
	}
	public WebElement getVideoResolutionEdt() {
		return getElement(videoResolutionEdt);
	}
	public WebElement getWaitingForVideoBtn() {
		return getElement(waitingForVideoBtn);
	}
	public WebElement getLaunchPreviewGeneratorBtn() {
		return getElement(launchPreviewGeneratorBtn);
	}
	public WebElement getSaveBtn() {
		return getElement(saveBtn);
	}
	public WebElement getSaveProgressRad() {
		return getElement(saveProgressRad);
	}
	public WebElement getHideItemRad() {
		return getElement(hideItemRad);
	}
	public WebElement getContainsNudityRad() {
		return getElement(containsNudityRad);
	}
	public WebElement getContainsSpecialEffectsRad() {
		return getElement(containsSpecialEffectsRad);
	}
	public WebElement getDoYouAppearRad() {
		return getElement(doYouAppearRad);
	}
	public WebElement getMultiplePerformersRad() {
		return getElement(multiplePerformersRad);
	}
	public WebElement getAgreementChk() {
		return getElement(agreementChk);
	}
	

	public void setSaveProgressRad(By saveProgressRad) {
		this.saveProgressRad = saveProgressRad;
	}
	public void setHideItemRad(By hideItemRad) {
		this.hideItemRad = hideItemRad;
	}
	public void setContainsNudityRad(By containsNudityRad) {
		this.containsNudityRad = containsNudityRad;
	}
	public void setContainsSpecialEffectsRad(By containsSpecialEffectsRad) {
		this.containsSpecialEffectsRad = containsSpecialEffectsRad;
	}
	public void setDoYouAppearRad(By doYouAppearRad) {
		this.doYouAppearRad = doYouAppearRad;
	}
	public void setMultiplePerformersRad(By multiplePerformersRad) {
		this.multiplePerformersRad = multiplePerformersRad;
	}
	public void setAgreementChk(By agreementChk) {
		this.agreementChk = agreementChk;
	}
	
	
	/**
	 * These custom methods will be used with this class. The return type should be the next
	 * landing page object class.
	 */
	public IWC_ArtistHomePage login(String username, String password) {
		
		//setEmailEdt(username);
		//doSendKeys(getPasswordEdt(), password);
		//doClick(getLoginBtn());
		//doVerifyNotDisplayed(getLoginBtn());
 		
		return getInstance(IWC_ArtistHomePage.class);
	}
	
	public IWC_ArtistHomePage agreeToBiometricDataUse() {
 		
 		doClick(getBiometricInfoIAgreeBtn());
 		
 		return getInstance(IWC_ArtistHomePage.class);
 	}

 	public IWC_ArtistHomePage disagreeWithBiometricDataUse() {

 		verifyElementIsDisplayed(getBiometricInfoIDisagreeBtn());
 		doClick(getBiometricInfoIDisagreeBtn());
 		
 		return getInstance(IWC_ArtistHomePage.class);
		
 	}
 	
	// Step 1: File Upload Details
	public IWC_ArtistHomePage setUploadDetails(String title, String filepath ){
		
		doSendKeys(getTitleEdt(), title);
		doSendKeys(getDescriptionEdt(), "Test Description");
		doSelect(getCategoryDrp(), "4K");
		doSelect(getCategoryDrp(), "Art");
		doSendKeys(getPriceEdt(), "5.00");
		
		doCreateFile(filepath);
		doFileUpload(getBrowseBtn(), filepath);
		
		doSendKeys(getUploadVideoEdt(), filepath);
		doClick(getLaunchPreviewGeneratorBtn());
		
		return getInstance(IWC_ArtistHomePage.class);
	}
	
	// Step 2: Upload Options
	public IWC_ArtistHomePage setUploadOptions(boolean isSaveProgress, boolean isHideItem, boolean isContainsNudity, boolean isContainsSpecialEffects){
		
		// Save Progress & Publish Later (Draft)
		if (isSaveProgress)
			setSaveProgressRad(By.id("status_1"));
		else
			setSaveProgressRad(By.id("status_2"));
		
		// Hide Item from Displaying on the Site/Your Store (Private Item)
		if (isHideItem)
			setHideItemRad(By.xpath("//input[@name='is_private' and @value='1']"));
		else
			setHideItemRad(By.xpath("//input[@name='is_private' and @value='0']"));
		
		// Does this content contain nudity?
		if (isContainsNudity)
			setContainsNudityRad(By.id("yes_full"));
		else
			setContainsNudityRad(By.id("no_nudity"));
		
		// Does this clip contain special effects? 
		if (isContainsSpecialEffects)
			setContainsSpecialEffectsRad(By.id("is_special_effects"));
		else
			setContainsSpecialEffectsRad(By.id("no_special_effects"));
		
		return getInstance(IWC_ArtistHomePage.class);
	}
	
	// Step 3: Compliance Requirements
	public IWC_ArtistHomePage setComplianceRequiremnents(boolean doYouAppear, boolean multiplePerformers ){
		
		// Do you appear in this Video/Content? 
		if (doYouAppear)
			setDoYouAppearRad(By.id("artist_appear"));
		else
			setDoYouAppearRad(By.id("artist_not_appear"));
		doClick(getDoYouAppearRad());
		
		// Are there multiple performers in this Video/Content? 
		if (multiplePerformers)
			setMultiplePerformersRad(By.id("multi_performers"));
		else
			setMultiplePerformersRad(By.id("no_mult_performers"));
		doClick(getMultiplePerformersRad());
		
		return getInstance(IWC_ArtistHomePage.class);
	}
	
}

