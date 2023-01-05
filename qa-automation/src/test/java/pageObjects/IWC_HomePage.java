package pageObjects;

import java.util.List;
import java.util.Random;

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
public class IWC_HomePage extends BasePage {

	/*
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_HomePage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}

	/*
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By joinFreeLnk = By.linkText("Join Free!"); 
	private By signInLnk = By.linkText("Sign in");
	private By iAmNot18Lnk = By.linkText("I am NOT 18+");
	private By termsOfUseAlr = By.id("consentFailed");
	private By emailEdt = By.xpath("//input[@id='loginEmail']");
	private By passwordEdt = By.xpath("//input[@id='loginPass']");
	private By loginBtn = By.id("loginBtn");
	private By termsOfUseEnterBtn = By.id("enter");
	private By userMenuLst = By.xpath("//button[@id='dropdownMenu1']");
	private By categoriesMenuLnk = By.xpath("//a[text()='Categories']");
	private By artistsMenuLnk = By.xpath("//a[text()='Artists']");
	private By topListsMenuLnk = By.xpath("//a[text()='Top Lists']");
	private By customsLnk = By.xpath("//a[@data-original-title='iWant Custom Clips']");
	private By phoneLnk = By.xpath("//a[@data-original-title='iWantPhone']");
	
	/*
	 *  Sign-up modal objects (member and artist)
	 */
	private By memberJoinBtn = By.xpath("//div[@class='memberSide']//a[text()='Join Now']");
	private By modelJoinBtn = By.xpath("//div[@class='modelSide']//button[text()='Join Now']");
	private By joinUsernameEdt = By.id("username"); 
	private By joinEmailEdt = By.id("email");
	private By joinPasswordEdt = By.id("password"); 
	private By joinConfirmPasswordEdt = By.id("conf_password");
	private By joinSecurityQuestionEdt = By.id("question");
	private By joinSecurityAnswerEdt = By.id("security_ans");
	private By joinCountryDrp = By.id("country");
	private By joinCaptcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
	private By joinNowBtn = By.xpath("//button[text()='Join now!']");
	private By joinCancelBtn = By.xpath("//button[text()='Cancel']");
	private	By applyNowBtn = By.id("model-signup-link-1");
	private	By artistAccountRad = By.xpath("//input[@name='accountType' and @class='modelRadio']");
	private	By studioAccountRad = By.xpath("//input[@name='accountType' and @class='studioRadio']");
	private	By genderDrp = By.id("gender");
	private	By birthMonthDrp = By.id("month");
	private	By birthDayDrp = By.id("day");
	private	By birthYearDrp = By.id("year");
	private	By signUpBtn = By.id("submitbtn");
	private By iAgreeChk = By.id("soa");
	private By usernameNotAvailableAlr = By.xpath("//b[contains(text(), 'Username not available')]");
	private By usernameAvailableAlr = By.xpath("//b[contains(text(), 'Username Available')]");
	private By emailNotAvailableAlr = By.xpath("//b[contains(text(), 'Email not available')]");
	private By emailAvailableAlr = By.xpath("//b[contains(text(), 'Email Available')]");
	private	By accountSuccessfullyCreatedLab = By.xpath("//h1[contains(text(), 'Account successfully created !')]");
	
	/*
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getTermsOfUseEnterBtn() {
		return getElement(termsOfUseEnterBtn);
	}
	public WebElement getJoinFreeLnk(){
		
		return getElement(joinFreeLnk);
	
	}	
	public WebElement getSignInLnk(){
		
		return getElement(signInLnk);
		
	}
	public WebElement getTermsOfUseAlr() {
		
		return getElement(termsOfUseAlr);
		
	}
	public WebElement getIAmNot18Lnk(){
		
		return getElement(iAmNot18Lnk);
		
	}
	public WebElement getEmailEdt() {
		
		return getElement(emailEdt);
		
	}
	public WebElement getPasswordEdt() {

		return getElement(passwordEdt);
		
	}
	public WebElement getLoginBtn() {
		
		return getElement(loginBtn);
		
	}
	public WebElement getUserMenuLst() {
		
		return getElement(userMenuLst);
		
	}
	public WebElement getCategoriesMenuLnk() {
		return getElement(categoriesMenuLnk);
	}
	public WebElement getArtistsMenuLnk() {
		return getElement(artistsMenuLnk);
	}
	public WebElement getTopListsMenuLnk() {
		
		return getElement(topListsMenuLnk);
		
	}
	public WebElement getMemberJoinBtn() {
		return getElement(memberJoinBtn);
	}
	public WebElement getModelJoinBtn() {
		return getElement(modelJoinBtn);
	}
	public WebElement getJoinUsernameEdt() {
		return getElement(joinUsernameEdt);
	}
	public WebElement getJoinEmailEdt() {
		return getElement(joinEmailEdt);
	}
	public WebElement getJoinPasswordEdt() {
		return getElement(joinPasswordEdt);
	}
	public WebElement getJoinConfirmPasswordEdt() {
		return getElement(joinConfirmPasswordEdt);
	}
	public WebElement getJoinSecurityQuestionEdt() {
		return getElement(joinSecurityQuestionEdt);
	}
	public WebElement getJoinSecurityAnswerEdt() {
		return getElement(joinSecurityAnswerEdt);
	}
	public WebElement getJoinCountryDrp() {
		return getElement(joinCountryDrp);
	}
	public WebElement getJoinCaptcha() {
		return getElement(joinCaptcha);
	}
	public WebElement getJoinNowBtn() {
		return getElement(joinNowBtn);
	}
	public WebElement getJoinCancelBtn() {
		return getElement(joinCancelBtn);
	}
	public WebElement getiAmNot18Lnk() {
		return getElement(iAmNot18Lnk);
	}
	public WebElement getApplyNowBtn() {
		return getElement(applyNowBtn);
	}
	public WebElement getArtistAccountRad() {
		return getElement(artistAccountRad);
	}
	public WebElement getStudioAccountRad() {
		return getElement(studioAccountRad);
	}
	public WebElement getGenderDrp() {
		return getElement(genderDrp);
	}
	public WebElement getBirthMonthDrp() {
		return getElement(birthMonthDrp);
	}
	public WebElement getBirthDayDrp() {
		return getElement(birthDayDrp);
	}
	public WebElement getBirthYearDrp() {
		return getElement(birthYearDrp);
	}
	public WebElement getSignUpBtn() {
		return getElement(signUpBtn);
	}
	public WebElement getIAgreeChk() {
		return getElement(iAgreeChk);
	}
	public WebElement getUsernameNotAvailableAlr() {
		return getElement(usernameNotAvailableAlr);
	}
	public WebElement getUsernameAvailableAlr() {
		return getElement(usernameAvailableAlr);
	}
	public WebElement getEmailNotAvailableAlr() {
		return getElement(emailNotAvailableAlr);
	}
	public WebElement getEmailAvailableAlr() {
		return getElement(emailAvailableAlr);
	}
	public WebElement getAccountSuccessfullyCreatedLab(){
		return getElement(accountSuccessfullyCreatedLab);
	}
	public WebElement getCustomsLnk(){
		return getElement(customsLnk);
	}
	public WebElement getPhoneLnk(){
		return getElement(phoneLnk);
	}
		
	/*
	 * These custom methods will be used with this class. The return type should be the next
	 * landing page object class.
	 * @throws Exception 
	 */
	public IWC_HomePage join(String memberType, String accountType, String username, String password, String question, String answer, String country) throws Exception {
		
		doClick(getJoinFreeLnk());
		
		// artist or studio account?
		if (memberType.toLowerCase() == "fan") {
			doClick(getModelJoinBtn());
			doClick(getApplyNowBtn());
			doClick(getArtistAccountRad());
			doSelect(getJoinSecurityQuestionEdt(), question);
			doSendKeys(getJoinSecurityAnswerEdt(), answer);
		}else {
			doClick(getMemberJoinBtn());
			if (accountType.toLowerCase() == "artist"){
				doClick(getArtistAccountRad());
			}else {
				doClick(getStudioAccountRad());
			}
		}
		
		// shared fields
		doSendKeys(getJoinUsernameEdt(), username);
		waitUntilElementIsDisplayed(getUsernameAvailableAlr());
		doSendKeys(getJoinEmailEdt(), username);
		doSendKeys(getJoinPasswordEdt(), password);
		doSendKeys(getJoinConfirmPasswordEdt(), password);
		doSelect(getJoinCountryDrp(), country);
		doClick(getIAgreeChk());
		doClick(getJoinCaptcha());
		doClick(getSignUpBtn());
		
		return getInstance(IWC_HomePage.class);
	}
	
	public IWC_HomePage login(String username, String password) throws Exception {
		
		// driver.get("https://qa.iwantclips.com/logout");
		// driver.get("https://qa.iwantclips.com/home/login?redirect=https://qa.iwantclips.com/");
		
		doClick(getSignInLnk());
		Thread.sleep(2000);
		doSendKeys(getEmailEdt(), username);
		doSendKeys(getPasswordEdt(), password);
		doClick(getLoginBtn());
		
		return getInstance(IWC_HomePage.class);
	}

	public IWC_HomePage addToCart(String itemId) {
		
		driver.get("https://qa.iwantclips.com/store/item/" + itemId);
		
		return getInstance(IWC_HomePage.class);
	}
	
	public IWC_MemberWishlistPage addToWishlist(String itemId) {

		driver.get("https://qa.iwantclips.com/my_store/add_member_wishlist/" + itemId);
		
		return getInstance(IWC_MemberWishlistPage.class);		
	}
	
	public IWC_HomePage addToFavorites(String artistId){
		
		driver.get("https://qa.iwantclips.com/store/add_favorite_confirmation/" + artistId);
		
		return getInstance(IWC_HomePage.class);	
		
	}
	
 	public IWC_HomePage navigateMenu(String page) {
		
		driver.get("https://qa.iwantclips.com/member/myaccount/edit");
		
		/*
		WebElement menuItem = driver.findElement(By.xpath("//a[contains(text(), '" + page + "')]"));
		
		doClick(getUserMenuLst());
		doVerifyIsDisplayed(menuItem);
		doClick(menuItem);
		*/
		
		return getInstance(IWC_HomePage.class);	
		
	}

 	public IWC_HomePage acceptTermsOfUse() throws Exception {
 		
 		doClick(getTermsOfUseEnterBtn());
 		verifyElementIsNotDisplayed(getTermsOfUseEnterBtn());
 		
 		return getInstance(IWC_HomePage.class);
 	}

 	public IWC_HomePage rejectTermsOfUse() throws Exception {

 		doClick(getIAmNot18Lnk());
 		verifyElementIsDisplayed(getTermsOfUseAlr());
 		
 		return getInstance(IWC_HomePage.class);
		
 	}
	
 	
 	public IWC_StorePage doSelectRandomWidgetItem(String widget) throws InterruptedException{
 		Random random = new Random();
 		WebElement pageSelector = null;
 		WebElement thumbnail = null;
 		String itemArtist = null;
 		
 		IWC_HomePage home = new IWC_HomePage(driver, wait);
 		IWC_StorePage store = new IWC_StorePage(driver, wait);
				
		int rangeIdx = random.nextInt(3) + 1;
		int pageIdx = random.nextInt(3) + 1;
		int imageIdx = (pageIdx - 1) * 4 + random.nextInt(4) + 1;
				
		switch (widget.toLowerCase()){
		
			case "featured stores":
				pageSelector = home.getElement(By.xpath("(//*[@id='featuredStores']/div/div[2]/ol/li)[" + pageIdx + "]"));
				thumbnail = home.getElement(By.xpath("//*[@id='featuredStoresWrapper']/div[" + imageIdx + "]/div/a"));
				itemArtist = home.getElement(By.xpath("(//*[@id='featuredStoresWrapper']/div[" + imageIdx + "]/div/a/div/img)")).getAttribute("alt");
				
				home.doClick(pageSelector);
				home.waitUntilElementIsDisplayed(thumbnail);
				IWC_StorePage.storeItemName = thumbnail.getText();
				IWC_StorePage.storeArtistName = itemArtist;
				
				home.doClick(thumbnail);
				store.verifyItemPageDisplaysItemName(store.getStoreItemName());
				
				break;
				
			case "featured phone stores":
				pageSelector = home.getElement(By.xpath("(//*[@id='phoneStores']/div/div[2]/ol/li)[" + pageIdx + "]"));
				thumbnail = home.getElement(By.xpath("//*[@id='phoneStoresWrapper']/div[" + imageIdx + "]/div/a"));
				itemArtist = home.getElement(By.xpath("(//*[@id='phoneStoresWrapper']/div[" + imageIdx + "]/div/a/div/img)")).getAttribute("alt");
				
				home.doClick(pageSelector);
				home.waitUntilElementIsDisplayed(thumbnail);
				IWC_StorePage.storeItemName = thumbnail.getText();
				IWC_StorePage.storeArtistName = itemArtist;
				
				home.doClick(thumbnail);
				store.verifyItemPageDisplaysItemName(store.getStoreItemName());
				
				break;
				
			case "top selling content":
				WebElement rangeSelector = home.getElement(By.xpath("(//*[@id='topContentType']/label)[" + rangeIdx + "]"));
				home.doClick(rangeSelector);
				pageSelector = home.getElement(By.xpath("(//*[@id='topContent']/div/div[3]/ol/li)[" + pageIdx + "]"));
				thumbnail = home.getElement(By.xpath("(//*[contains(@id, 'topClip-')]/div[2]/div[2]/span/a)[" + imageIdx + "]"));
				itemArtist = getElement(By.xpath("(//*[contains(@id, 'topClip-')]/div[2]/div[2]/h3/a)[" + imageIdx + "]")).getText();
				
				home.doClick(pageSelector);
				home.waitUntilElementIsDisplayed(thumbnail);
				IWC_StorePage.storeItemName = thumbnail.getText();
				IWC_StorePage.storeArtistName = itemArtist;
				
				home.doClick(thumbnail);
				store.verifyItemPageDisplaysItemName(store.getStoreItemName());
				store.verifyItemPageDisplaysArtistName(store.getStoreArtistName());
				
				break;
				
			case "newest content":
				pageIdx = random.nextInt(7) + 1;
				//imageIdx = (pageIdx - 1) * 4 + random.nextInt(40) + 1;
				imageIdx = random.nextInt(40) + 1;
				pageSelector = home.getElement(By.xpath("(//*[@id='pagination']/div/ul/li/a)[" + pageIdx + "]"));
				thumbnail = home.getElement(By.xpath("(//*[contains(@id, 'clip-')]/div[2]/div[3]/span[4]/a)[" + imageIdx + "]"));
				itemArtist = home.getElement(By.xpath("(//*[contains(@id, 'clip-')]/div[2]/div[3]/span[6]/a)[" + imageIdx + "]")).getText();
				
				home.doClick(pageSelector);
				home.waitUntilElementIsDisplayed(thumbnail);
				IWC_StorePage.storeItemName = thumbnail.getText();
				IWC_StorePage.storeArtistName = itemArtist;
				
				//Thread.sleep(10000);
				driver.get(thumbnail.getAttribute("href"));
				store.verifyItemPageDisplaysItemName(store.getStoreItemName());
				store.verifyItemPageDisplaysArtistName(store.getStoreArtistName());
				
				break;	
		}
		
		//WebElement pageSelector = home.getElement((By.xpath("(//*[@id='featuredStores']/div/div[2]/ol/li)[" + pageIdx + "]")));
		//home.doClick(pageSelector);

		// Randomly selected 1 of 4 images displayed on 1 of 3 randomly selected pages. Images are indexed 1-12.
		//int imageIdx = (pageIdx - 1) * 4 + random.nextInt(4) + 1;
		
		// Save item name and store artist name
		//home.waitUntilElementIsDisplayed(thumbnail);
		//IWC_StorePage.storeItemName = thumbnail.getText();
		//IWC_StorePage.storeArtistName = itemArtist;

		// Click the thumbnail and verify the correct page is displayed
		//home.doClick(thumbnail);
		
		// Verify that the correct page is displayed
		//IWC_StorePage store = new IWC_StorePage(driver, wait);
		//store.verifyItemPageDisplaysItemName(store.getStoreItemName());
		//if (!widget.contains("stores")) {
		//	store.verifyItemPageDisplaysArtistName(store.getStoreArtistName());
		//}
		
		return getInstance(IWC_StorePage.class);
				
 	}
 	
 	public IWC_StorePage doClickRandomFeaturedStoreImage() {
 		Random random = new Random();
		
 		// Select a random thumbnail page (1 of 3)
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		int pageIdx = random.nextInt(3) + 1;
		WebElement pageSelector = home.getElement((By.xpath("(//*[@id='featuredStores']/div/div[2]/ol/li)[" + pageIdx + "]")));
		home.doClick(pageSelector);
	
		/* select a random clip
		int imageIdx = 0;
		
		switch (pageIdx) {
		case 1: imageIdx = random.nextInt(4) + 1; break;
		case 2: imageIdx = random.nextInt(4) + 5; break;
		case 3: imageIdx = random.nextInt(4) + 9; break;
		}
		*/
		
		// Randomly selected 1 of 4 images displayed on 1 of 3 randomly selected pages. Images are indexed 1-12.
		int imageIdx = (pageIdx - 1) * 4 + random.nextInt(4) + 1;
		
		// Save store artist name	
		WebElement image = home.getElement(By.xpath("//*[@id='featuredStoresWrapper']/div[" + imageIdx + "]/div/a"));
		home.waitUntilElementIsDisplayed(image);
		IWC_StorePage.storeArtistName = home.getElement(By.xpath("(//*[@id='featuredStoresWrapper']/div[" + imageIdx + "]/div/a/div/img)")).getAttribute("alt");
		home.doClick(image);
		
		IWC_StorePage store = new IWC_StorePage(driver, wait);
		store.verifyStorePageDisplaysArtistName(store.getStoreArtistName());
		
		return getInstance(IWC_StorePage.class);
				
 	}
 	public IWC_StorePage doClickRandomFeaturedPhoneStoreImage() {
 		Random random = new Random();
		
 		// Select a random thumbnail page (1 of 3)
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		int pageIdx = random.nextInt(3) + 1;
		WebElement pageSelector = home.getElement((By.xpath("(//*[@id='phoneStores']/div/div[2]/ol/li)[" + pageIdx + "]")));
		home.doClick(pageSelector);

		/* select a random clip
		int imageIdx = 0;
		
		switch (pageIdx) {
		case 1: imageIdx = random.nextInt(4) + 1; break;
		case 2: imageIdx = random.nextInt(4) + 5; break;
		case 3: imageIdx = random.nextInt(4) + 9; break;
		}
		*/
		
		// Randomly selected 1 of 4 images displayed on 1 of 3 randomly selected pages. Images are indexed 1-12.
		int imageIdx = (pageIdx - 1) * 4 + random.nextInt(4) + 1;
		
		// Save store artist name		
		WebElement image = home.getElement(By.xpath("//*[@id='phoneStoresWrapper']/div[" + imageIdx + "]/div/a"));
		home.waitUntilElementIsDisplayed(image);
		IWC_StorePage.storeArtistName = home.getElement(By.xpath("(//*[@id='phoneStoresWrapper']/div[" + imageIdx + "]/div/a/div/img)")).getAttribute("alt");
		home.doClick(image);

		IWC_StorePage store = new IWC_StorePage(driver, wait);
		store.verifyStorePageDisplaysArtistName(store.getStoreArtistName());
		
		return getInstance(IWC_StorePage.class);
				
 	}
 	public IWC_StorePage doClickRandomTopSellingContentImage() {
 		Random random = new Random();
		
 		// Select a random range (daily, weekly, monthly)
 		IWC_HomePage home = new IWC_HomePage(driver, wait);
		int rangeIdx = random.nextInt(3) + 1;
		WebElement rangeSelector = home.getElement((By.xpath("(//*[@id='topContentType']/label)[" + rangeIdx + "]")));
		home.doClick(rangeSelector);

		// Select a random thumbnail page (1 of 3)
		int pageIdx = random.nextInt(3) + 1;
		WebElement pageSelector = home.getElement((By.xpath("(//*[@id='topContent']/div/div[3]/ol/li)[" + pageIdx + "]")));
		home.doClick(pageSelector);

		/* select a random clip
		int imageIdx = 0;
		
		switch (pageIdx) {
		case 1: imageIdx = random.nextInt(4) + 1; break;
		case 2: imageIdx = random.nextInt(4) + 5; break;
		case 3: imageIdx = random.nextInt(4) + 9; break;
		}
		*/
		
		// Randomly selected 1 of 4 images displayed on 1 of 3 randomly selected pages. Images are indexed 1-12.
		int imageIdx = (pageIdx - 1) * 4 + random.nextInt(4) + 1;
		
		// Save item name and store artist name
		WebElement image = home.getElement(By.xpath("(//*[contains(@id, 'topClip-')]/div[2]/div[2]/span/a)[" + imageIdx + "]"));
		home.waitUntilElementIsDisplayed(image);
		IWC_StorePage.storeItemName = image.getText();
		WebElement itemArtist = getElement(By.xpath("(//*[contains(@id, 'topClip-')]/div[2]/div[2]/h3/a)[" + imageIdx + "]"));
		IWC_StorePage.storeArtistName = itemArtist.getText();
		
		// Click the thumbnail and verify the correct page is displayed
		home.doClick(image);
		IWC_StorePage store = new IWC_StorePage(driver, wait);
		store.verifyItemPageDisplaysItemName(store.getStoreItemName());
		store.verifyItemPageDisplaysArtistName(store.getStoreArtistName());
		
		return getInstance(IWC_StorePage.class);
				
 	} 	

}
