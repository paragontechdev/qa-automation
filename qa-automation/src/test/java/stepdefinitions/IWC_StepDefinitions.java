package stepdefinitions;

//import static pageObjects.IWC_StorePage.artistName;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.IWC_ArtistHomePage;
import pageObjects.IWC_ArtistsPage;
import pageObjects.IWC_FetishCategoriesPage;
import pageObjects.IWC_HomePage;
import pageObjects.IWC_MemberWishlistPage;
import pageObjects.IWC_PersonalInformationPage;
import pageObjects.IWC_ShoppingCartPage;
import pageObjects.IWC_StorePage;
import pageObjects.IWC_TopListsPage;
import pageObjects.IWG_DashboardPage;
import pageObjects.IWG_LoginPage;
import pageObjects.IWG_ReviewHistoryPage;
import pageObjects.IWG_ReviewQueuePage;
import pageObjects.Page;

public class IWC_StepDefinitions {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	public long startTime, endTime, totalTime;
	
	
	// Setup (@Before) and tear-down (@After) methods
	@Before
	public void setUp() {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "false");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("--window-size=1024,768");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		page = new BasePage(driver, wait);
		driver.manage().deleteAllCookies();
		
	}
	@After
	public void teardown() {
	//	driver.quit();
	}
	
	
	// Actions
	@When("^([^\"]*) logs in with (.*) and (.*)$")
	public void do_Login(String userType, String username, String password) throws Exception {
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.login(username, password);
	}	
	@Then("^([^\"]*) navigates to the \"([^\"]*)\" page$")
	public void do_NavigateToPage(String userType, String iwcPage) throws Exception {
		BasePage base = new BasePage(driver, wait);
		base.doNavigateToPage(iwcPage);
	}
	@When("^([^\"]*) accepts terms of use$")
	public void do_AcceptTermsOfUse(String userType) throws Exception {
	    
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		iwcHome.acceptTermsOfUse();
				
	}
	@When("^([^\"]*) rejects terms of use$")
	public void do_RejectTermsOfUse() throws Exception {
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		iwcHome.rejectTermsOfUse();
	}
	
	
	// Click
	@When("^(.*) clicks \"Show all 100 Top (.*)\"$")
	public void click_TopListsShowAllLink(String userType, String link) throws Exception {
		
		By element = null;
		IWC_TopListsPage topLists = new IWC_TopListsPage(driver, wait);
				
		if (link.contains("Stores")) {
			topLists.doClick(topLists.getShowAllTop100StoresLnk());
			element = By.xpath("(//div[@class='topContainer'][@style='height: 100%;'])[1]");
		} else if (link.contains("Items")) {
			topLists.doClick(topLists.getShowAllTop100ItemsLnk());
			element = By.xpath("(//div[@class='topItemContainer'][@style='height: 100%;'])[1]");
		} else {
			topLists.doClick(topLists.getShowAllTop100CategoriesLnk());
			element = By.xpath("(//div[@class='topFetishContainer'][@style='height: 100%;'])[1]");
		}
		
		// Wait for the list to fully load before continuing
		wait.until(ExpectedConditions.presenceOfElementLocated(element));	
	}
	@When("^([^\"]*) clicks a random top 100 (.*)$")
	public void click_RandomTop100ListElement(String userType, String listType) throws Exception {
		IWC_TopListsPage topLists = new IWC_TopListsPage(driver, wait);
		topLists.doClickRandomTop100Element(listType);
	}
	@When("^(.*) clicks the \"([^\"]*)\" link$")
	public void click_Link(String userType, String link) throws Exception {
		
		try {
			IWC_HomePage home = new IWC_HomePage(driver, wait);
				
			switch(link.toLowerCase()) {
			case "iwantcustomclips":
			case "customs":
				home.doClick(home.getCustomsLnk());
				home.verifyPageIsDisplayed(link);
				break;
			
			case "iwantphone":
			case "phone":
				home.doClick(home.getPhoneLnk());
				home.verifyPageIsDisplayed(link);
				break;
			
			case "join free":
			case "join free!":
				home.doClick(home.getJoinFreeLnk());
				home.verifyElementIsDisplayed(home.getMemberJoinBtn());
				home.verifyElementIsDisplayed(home.getModelJoinBtn());
				break;
			}
		} catch(Exception e) {
			throw new Exception(link + " not defined in Java method.");
		}
		
	}
	@When("(.*) clicks a random artist image")
	public void click_RandomArtist() {
		IWC_ArtistsPage artistPage = new IWC_ArtistsPage(driver, wait);
		artistPage.doSelectRandomArtist();
	}
	@When("(.*) selects a random store item")
	public void click_RandomStoreItem() {
		IWC_ArtistsPage artistPage = new IWC_ArtistsPage(driver, wait);
		artistPage.doSelectRandomStoreItem();
	}
	@When("^(.*) clicks the Join Now button on the (.*) modal$")
	public void click_JoinNowButtonOnJoinNowModal(String userType, String fanOrArtist) {
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		
		switch(fanOrArtist.toLowerCase()) {
		case "fan": 
			home.doClick(home.getMemberJoinBtn());
			break;
		case "artist": 
			home.doClick(home.getModelJoinBtn());
			break;
		}
	}
	
	
	@When("^(.*) clicks on (.*) section link$")
	public void click_FeaturedStoresImageLink(String userType, String widget) throws Exception{
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.doSelectRandomWidgetItem(widget);
	}
	@When("^(.*) cli cks on (.*) widget link$")
	public void click_FeaturedPhoneStoresImageLink(String userType, String widget) throws Exception{
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.doClickRandomFeaturedPhoneStoreImage();
	}
	@When("^(.*) cli cks on Top Selling Content widget link")
	public void click_TopSellingContentImageLink(String userType, String widget) throws Exception {
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.doSelectRandomWidgetItem(widget);
	}
	@When("^(.*) cli cks on (.*) (widget|section) link")
	public void click_RandomWidgetLink(String userType, String sectionName, String widgetOrSection) throws  Exception {
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.doSelectRandomWidgetItem(sectionName);
	}
	
	
	// Verifications
	@Then("^the \"([^\"]*)\" page is displayed$")
	public void verify_PageIsDisplayed(String page) throws Exception {
		BasePage base = new BasePage(driver, wait);
		base.verifyPageIsDisplayed(page);
	}
	@Then("^the artist store page ([^\"]*) is displayed$")
	public void verify_CurrentUrlHasArtistId(String artistId) {
		IWC_StorePage store = new IWC_StorePage(driver, wait);
		store.verifyCurrentUrlHasArtistId(artistId);
	}
	@Then("^the correct ([^\"]*) page is displayed$")
	public void verify_CorrectTopListPageIsDisplayed(String listType) throws Exception {
		IWC_StorePage store = new IWC_StorePage(driver, wait);
		IWC_FetishCategoriesPage fetishCategories = new IWC_FetishCategoriesPage(driver, wait);
		
		switch(listType) {
		case "store":
			store.verifyStorePageDisplaysArtistName(store.getStoreArtistName());
			break;
		case "item":
			store.verifyItemPageDisplaysItemName(store.getStoreItemName());
			store.verifyItemPageDisplaysArtistName(store.getStoreArtistName());
			break;
		case "category":
			fetishCategories.verifyPageDisplaysFetishCategory(fetishCategories.getFetishCategoryName());
			break;
		default:
			throw new Exception("Invalid listType: $listType");
		}
	}
	@Then("^there are no broken links on the page$")
	public void verify_CurrentPageLinksStatuses() throws Exception {
		BasePage basePage = new BasePage(driver, wait);
		basePage.getStatusOfCurrentPageLinks(true);
	}
	@Then("^the top (.*) ([^\"]*) are displayed$")
	public void verify_TopListItemsAreDisplayed(int listCount, String listType) throws Exception{
		IWC_TopListsPage topLists = new IWC_TopListsPage(driver, wait);
		topLists.verifyTopListsAreDisplayed(listCount, listType);
	}
	@Then("^([^\"]*) verfies (.*) page links navigate to the correct page$")
	public void verify_CategoryLinksNavigateToCorrectPage(String userTye, String allOrMaxCount) throws InterruptedException {
		IWC_FetishCategoriesPage fetishCategories = new IWC_FetishCategoriesPage(driver, wait);
		fetishCategories.verifyFetishCategoryLinks(allOrMaxCount);
	}
	@Then("the item description page is displayed")
	public void verify_ItemDescriptionPageElements() throws Exception {
		IWC_ArtistsPage artistsPage = new IWC_ArtistsPage(driver, wait);
		artistsPage.verifyItemDescriptionPageElements();
	}
	@Then("the Join Now modals are displayed")
	public void verify_JoinNowModalsAreDisplayed() throws Exception {
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.verifyElementIsDisplayed(home.getMemberJoinBtn());
		home.verifyElementIsDisplayed(home.getModelJoinBtn());
	}
	@Then("categories that contain the search term are displayed")
	public void verify_ItemCategoriesAreDisplayed() throws InterruptedException {
		IWC_FetishCategoriesPage fetishPage = new IWC_FetishCategoriesPage(driver, wait);
		fetishPage.verifyFetishCategorySearchResults(fetishPage.getFetishCategorySearchTerm());
	}
	@Then("(.*) account creation form is displayed")
	public void verify_AccountCreationFormIsDisplayed(String userType) throws Exception {
		IWC_HomePage home = new IWC_HomePage(driver, wait);
		home.verifyElementIsDisplayed(home.getJoinNowBtn());
	
	}
	@Then("terms of use alert is displayed")
	public void verify_TermsOfUseAlertIsDisplayed() {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		Assert.assertTrue(iwcHome.getIAmNot18Lnk().isDisplayed());
	}
	@Then("terms of use alert is not displayed")
	public void verify_TermsOfUseAlertIsNotDisplayed() {
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		Assert.assertFalse(iwcHome.getIAmNot18Lnk().isDisplayed());
	}
	
	
	// Search
	@When("^(.*) searches for a fetish category (.*)$")
	public void search_FetishCategory(String userType, String searchTerm) throws Exception {
	    IWC_FetishCategoriesPage fetishPage = new IWC_FetishCategoriesPage(driver, wait);
	    fetishPage.doSendKeys(fetishPage.getSearchFetishCategoriesEdt(), searchTerm);
	    IWC_FetishCategoriesPage.fetishCategorySearchTerm = searchTerm;
	}
		
	
	

	/**
	 * Artist and artist store methods
	 * 
	 */
	
	@Given("^(.*) navigates to an artist store page ([^\"]+)")
	public void artistStore_navigate_to_artist_store(String userType, String artistId) throws Exception {

		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.doNavigateToArtistStorePage(artistId);

	}

	@When("user clicks Tribute Me button")
	public void artistStore_click_tribute_me_button() {
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.doClick(iwcStore.getTributeMeLnk());

	}
		
	@When("^user(.*) tributes (.*) dollars$")
	public void artistStore_send_tribute(String userType, String amount) throws Exception {

		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.tipOrTribute(userType, amount);
		
	}
    
	@Then("^tribute(.*) has been sent$")
	public void artistStore_verify_tribute_has_been_sent(String amount) throws Exception{
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.verifyTipOrTributeSent(amount);
		
	}
			
	@When("^user adds an item(.*) to their shopping cart$")
	public void artistStore_add_item_to_shopping_cart(String itemId) {
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.addArtistClipToCartById(itemId);

	}

	@When("^user(.*) checks out$")
	public void artistStore_check_out(String userType) throws Exception {
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.goToShoppingCart();
		iwcStore.checkout("guest");
		
	}

	@Then("a purchase confirmation message is displayed")
	public void artistStore_verify_purchase_confirmation_displays() throws Exception {

		IWC_ShoppingCartPage iwcCart = new IWC_ShoppingCartPage(driver, wait);
		
		iwcCart.verifyElementIsDisplayed(iwcCart.getSuccessfulAlr());

	}
	
	@When("user adds artist ([^\"]+) to their favorites")
	public void artistStore_add_artist_to_favorites(String artistId) {
		
		driver.get("https://qa.iwantclips.com/store/add_favorite_confirmation/" + artistId);
			
	}
	
	@Then("artist ([^\"]+) is displayed in user favorites")
	public void member_verify_artist_displays_in_favorites(String artistId) {

		driver.get("https://qa.iwantclips.com/member/favorites");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, '" + artistId + "')]")));
				
	}
		
	
	
	/**
	 * Terms of Use modal methods
	 *  
	 */
	
	
	/**
	 * Sign-up methods
	 * 
	 */
	@When("^artist clicks I (Agree|Disagree) on the Biometric Information notice$")
	public void agree_with_biometric_info_notice(boolean agree) throws Exception {
		
		IWC_ArtistHomePage artistHome = new IWC_ArtistHomePage(driver, wait);
		
		if (agree = true) {
			artistHome.agreeToBiometricDataUse();
		}else {
			artistHome.disagreeWithBiometricDataUse();
		}
		
	}
		
	@When("user clicks join button")
	public void user_clicks_join_button() {

		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.doClick(iwcHome.getJoinFreeLnk());
		
	}

	@When("user selects to join as a fan")
	public void user_selects_to_join_as_a_fan() {

		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.doClick(iwcHome.getMemberJoinBtn());
		
	}
	
	@When("user selects to join as an artist")
	public void user_selects_to_join_as_an_artist() {

		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.doClick(iwcHome.getModelJoinBtn());
		iwcHome.doClick(iwcHome.getApplyNowBtn());
				
	}
	
	@Then("the fan signup form is displayed")
	public void the_fan_signup_form_is_displayed() {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.waitUntilElementIsDisplayed(iwcHome.getJoinUsernameEdt());
		
	}
	
	@When("^user submits signup form$")
	public void user_submits_signup_form(String accountType, String gender, String month, String day, String year, 
			String username, String email, String password, String question, String answer, String country) throws Exception {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.doClick(iwcHome.getApplyNowBtn());
		
		// artists-only account
		if (accountType.toLowerCase().compareTo("fan") != 0) {
				
			if (accountType.toLowerCase().compareTo("artist") != 0) {
				iwcHome.doClick(iwcHome.getArtistAccountRad());
			}else {
				iwcHome.doClick(iwcHome.getStudioAccountRad());
			}
			iwcHome.doSelect(iwcHome.getGenderDrp(), gender);
			iwcHome.doSelect(iwcHome.getBirthMonthDrp(), month);
			iwcHome.doSelect(iwcHome.getBirthDayDrp(), day);
			iwcHome.doSelect(iwcHome.getBirthYearDrp(), year);
			iwcHome.doClick(iwcHome.getIAgreeChk());
		}
		
		// fan and artist account
		iwcHome.doSendKeys(iwcHome.getJoinUsernameEdt(), username);
		iwcHome.doSendKeys(iwcHome.getJoinEmailEdt(), email);
		iwcHome.verifyElementIsDisplayed(iwcHome.getUsernameAvailableAlr());
		iwcHome.doSendKeys(iwcHome.getJoinPasswordEdt(), password);
		iwcHome.verifyElementIsDisplayed(iwcHome.getEmailAvailableAlr());
		iwcHome.doSendKeys(iwcHome.getJoinConfirmPasswordEdt(), password);
		iwcHome.doSelect(iwcHome.getJoinCountryDrp(), country);
		
		// fan-only account
		if (accountType.toLowerCase().compareTo("fan") != 0) {
			iwcHome.doSelect(iwcHome.getJoinSecurityQuestionEdt(), question);
			iwcHome.doSendKeys(iwcHome.getJoinSecurityAnswerEdt(), answer);
		}
		
		iwcHome.doClick(iwcHome.getJoinCaptcha());
		// iwcHome.doClick(iwcHome.getSignUpBtn());
	}

	@Then("new user account is created")

	public void new_user_account_is_created() throws Exception {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.verifyElementIsDisplayed(iwcHome.getAccountSuccessfullyCreatedLab());
		
	}


	
	
	
	@When("^user navigates to IWC sub page ([^\"]+)$")
	public void the_user_navigates_to_IWC_sub_page(String page) {
	    
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.navigateMenu(page);
		
	}
	
	@When("^user adds item ([^\"]+) to wishlist$")
	public void add_wishlist_item(String itemId) {

		IWC_MemberWishlistPage iwcWishlist = new IWC_MemberWishlistPage(driver, wait);
		
		iwcWishlist.addToWishlist(itemId);
				
	}
	
	@Then("^item ([^\"]+) is displayed in user wishlist$")
	public void verify_wishlist_item(String itemId) throws Exception {
		
		IWC_MemberWishlistPage iwcWishlist = new IWC_MemberWishlistPage(driver, wait);
		
		iwcWishlist.verifyWishlistItem(itemId);
		
	}
	
	@When("^user updates account information from ([^\"]+) to ([^\"]+)$")
	public void update_account_information(String oldValue, String newValue) {
	    
		IWC_PersonalInformationPage iwcPersonalInfo = new IWC_PersonalInformationPage(driver, wait);
		
		iwcPersonalInfo.updatePassword(oldValue, newValue);

		wait.until(ExpectedConditions.visibilityOf(iwcPersonalInfo.getUpdateSuccessfulMsg()));
		
	}
		
	@Then("updated account information is saved")
	public void verify_account_information_update_saved() {
	    
		IWC_PersonalInformationPage iwcPersonalInfo = new IWC_PersonalInformationPage(driver, wait);

		wait.until(ExpectedConditions.visibilityOf(iwcPersonalInfo.getUpdateSuccessfulMsg()));		
	}

	
	
	
	// CRP
	// @When("^.* navigates to the ([^\"]+) Queue$")
	public void crp_queue(String queueContent) {		
		WebElement element = null; 
		String expectedUrl = null;
		
		IWG_DashboardPage dashboardPage = new IWG_DashboardPage(driver, wait);
		dashboardPage.doStartTimer("Navigate to " + queueContent + " Queue");
		
		// cap first letter to avoid mismatches
		queueContent = queueContent.substring(0,1).toUpperCase() + queueContent.substring(1);
		switch (queueContent.toLowerCase()){
			case "biometric profile":
				element = driver.findElement(By.partialLinkText(queueContent + " Queue"));
				expectedUrl = "https://dev.admin.iwantglobal.com/review/bio_profile_queue";
				break;
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(queueContent + " Queue")));
		element.click();
		
		// compare actual vs expected URL to verify the correct page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),' Queue')]")));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.compareTo(expectedUrl) == 0);
		dashboardPage.doStopTimer();
		
	}

	@When("^.* navigates to the ([^\"]+) Review Queue$")
	public void crp_review_queue(String queueContent) {		
		WebElement element = null; 
		String expectedUrl = null;
		IWG_DashboardPage dashboardPage = new IWG_DashboardPage(driver, wait);
		dashboardPage.doStartTimer("Navigate to " + queueContent + " Queue");
		
		// cap first letter to avoid mismatches
		queueContent = queueContent.substring(0,1).toUpperCase() + queueContent.substring(1);
		switch (queueContent.toLowerCase()){
			case "document": 
				element = driver.findElement(By.partialLinkText(queueContent + "s Needing Review"));
				expectedUrl = "https://dev.admin.iwantglobal.com/review/docqueue";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(queueContent + "s Needing Review")));
				break;
			case "image":
				element = driver.findElement(By.partialLinkText(queueContent + "s Needing Review"));
				expectedUrl = "https://dev.admin.iwantglobal.com/review/imagequeue";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(queueContent + "s Needing Review")));
				break;
			case "video":
				element = driver.findElement(By.partialLinkText(queueContent + "s Needing Review"));
				expectedUrl = "https://dev.admin.iwantglobal.com/review/videoqueue";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(queueContent + "s Needing Review")));
				break;
			case "biometric profile":
				element = driver.findElement(By.partialLinkText(queueContent + " Queue"));
				expectedUrl = "https://dev.admin.iwantglobal.com/review/bio_profile_queue";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(queueContent + " Queue")));
				break;
		}

		element.click();
		
		// compare actual vs expected URL to verify the correct page is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),' Queue')]")));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.compareTo(expectedUrl) == 0);
		dashboardPage.doStopTimer();
		
	}
		
	@When(".* clicks? the ([^\"]+) link in the ([^\"]+) Queue?$")
	public void crp_queue_link(String queueContent, String link) {
		
		IWG_ReviewQueuePage reviewQueue = new IWG_ReviewQueuePage(driver, wait);
		
		reviewQueue.getAllLnk().click();
		
	}
		
	@When(".* clicks? the ([^\"]+) link in the ([^\"]+) Review?$")
	public void crp_review_queue_link(String queueContent, String link) {
		
		IWG_ReviewQueuePage reviewQueue = new IWG_ReviewQueuePage(driver, wait);
		
		reviewQueue.getAllLnk().click();
		
	}
	
/*		
	@Before
	public void setup() {
		
		CrpBaseObjects crp = new CrpBaseObjects(driver, wait);
		crp.startTimer("Initializing driver");
		System.out.println();
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		crp.stopTimer();
			
		crp.startTimer("Loading home page");
		driver.manage().deleteAllCookies();
		driver.get("https://dev.admin.iwantglobal.com/review/dashboard");
		crp.stopTimer();
		System.out.println();
	}	
		

	@After
	public void teardown() {
		// close all driver instances
		CrpBaseObjects crp = new CrpBaseObjects(driver, wait);
		crp.startTimer("\nClosing browser instances");
		//driver.close();
		//driver.quit();
		crp.stopTimer();
		
	}
	
	
*/			
	//@Given("^([^\"]+) access(es)?( to)? the CRP Review Dashboard$")
	@Given("^.* access to the CRP Review Dashboard$")
	public void crp_review_dashboard() {
		
		IWG_LoginPage loginPage = new IWG_LoginPage(driver, wait);
		
		driver.get("https://dev.admin.iwantglobal.com/review/dashboard");
		
		// loginPage.startTimer("Logging in");
		// loginPage.login("kevin.m@stackunited.com", "&Z5DFOk6IfjA");
		loginPage.login("kevin.m@stackunited.com", "P123456789");
		IWG_DashboardPage dashboardPage = new IWG_DashboardPage(driver, wait);
		driver.findElement(dashboardPage.documentsNeedingReviewLnk);
		// loginPage.stopTimer();
		
	}
		
	//@When("^[^ ]* open(s)? the [rR]eview( [qQ]ueue)?( [pP]age)?$")
	@When("^the ([^\"]+) Review History page is opened$")
	public void crp_review_history(String queueContent) {
		String expectedUrl = null;
		IWG_ReviewQueuePage historyPage = new IWG_ReviewQueuePage(driver, wait);
		
		historyPage.doStartTimer("Navigate to Review History");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Review History')]")));
		
		switch (queueContent.toLowerCase()){
			case "document": 
				expectedUrl = "https://dev.admin.iwantglobal.com/review/docreview/";
				break;
			case  "image":
				expectedUrl = "https://dev.admin.iwantglobal.com/review/imagereview/";
				break;
			case "video":
				expectedUrl = "https://dev.admin.iwantglobal.com/review/videoreview/";
				break;
		}
		
		// verify the correct page is displayed
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains(expectedUrl));
		historyPage.doStopTimer();
		
	}
	
	//@Then("^([^\"]+) section contains ([^\"]+)?")
	@Then("^.*Content Overview section contains ([^\\\"]+)$")
	public void crp_content_overview_section(String heading) {
	    
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.doStartTimer("Check Content Overview");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[(text()='Title:')]")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[(text()='" + heading + ":')]")));
		crp.doStopTimer();
		
	}
	
	//@When("^([^\"]+) clicks? the [rR]eview button$")
	@When("user clicks the Review button")
	public void crp_reviewDetails() {
		
		IWG_ReviewQueuePage reviewQueue = new IWG_ReviewQueuePage(driver, wait);
		reviewQueue.doStartTimer("Click the Review button");
		reviewQueue.clickReviewButton();
		reviewQueue.clickReviewButton();
		reviewQueue.doStopTimer();
		
	}
	
	@When("the Reviewer clicks \'Store Name\'")
	public void clickStoreName(String storeName) {
	    
		IWG_ReviewQueuePage reviewQueue = new IWG_ReviewQueuePage(driver, wait);
		
		reviewQueue.clickStoreLink();
		
	}

	@Then("The Reviewers browser will open the respective Admin panel in a new tab")
	public void the_reviewers_browser_will_open_the_respective_admin_panel_in_a_new_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("^[^ ]* selects? an? ([^\"]+) from the( list)?( queue)?$")
	public void crp_select_top_record_in_queue(String type) {
		
		IWG_ReviewQueuePage reviewQueue = new IWG_ReviewQueuePage(driver, wait);
		reviewQueue.doStartTimer("Select a " + type);
		reviewQueue.clickReviewButton();
		reviewQueue.doStopTimer();
		
	}

	@When("^I? click?( the)? ([^\"]+) radio button$")
	public void crp_clickApprovedRadio_button() {
			
		IWG_ReviewHistoryPage reviewHistory = new IWG_ReviewHistoryPage(driver, wait);
		
		reviewHistory.selectVerdict("Approved");
		
	}
	
	@When("^I? clicks? (the)?[sS]ave button$")
	public void crp_click_crp_save_button() {
				
		IWG_ReviewHistoryPage reviewHistory = new IWG_ReviewHistoryPage(driver, wait);
		
		reviewHistory.clickSave();
		
	}

	@Then("^(the )?[Cc]urrent [sS]tatus is ([^\"]+)$")
	public void crp_get_content_status(String status) {
		
		IWG_ReviewHistoryPage reviewHistory = new IWG_ReviewHistoryPage(driver, wait);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12'][5]")));
		
		String displayedStatusText = (reviewHistory.getCurrentStatusLbl().getText());
		Assert.assertTrue(status.compareTo(displayedStatusText.replace("Current Status:",  "").trim()) == 0);
			
		/*
		// Hard-coded...
		//String expectedStatus = "3 - Published";
		//assertTrue(expectedStatus.compareTo(displayedStatusText.replace("Current Status:",  "").trim()) == 0);
		*/
	}		
}
		

		

	