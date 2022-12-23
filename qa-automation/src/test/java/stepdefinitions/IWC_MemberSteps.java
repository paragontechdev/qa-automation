package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.BasePage;
import pageObjects.IWC_ArtistHomePage;
import pageObjects.IWC_ArtistsPage;
import pageObjects.IWC_HomePage;
import pageObjects.IWC_MemberWishlistPage;
import pageObjects.IWC_PersonalInformationPage;
import pageObjects.IWC_ShoppingCartPage;
import pageObjects.IWC_StorePage;
import pageObjects.IWG_DashboardPage;
import pageObjects.IWG_LoginPage;
import pageObjects.IWG_ReviewHistoryPage;
import pageObjects.IWG_ReviewQueuePage;
import pageObjects.Page;

public class IWC_MemberSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	public Page page;
	long startTime, endTime, totalTime;
		
	
	/**
	 * Setup (@Before) and tear-down (@After) methods
	 */
	@Before
	public void InitializeBowser() throws InterruptedException{
		
		// WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		//chromeOptions.addArguments("start-maximized");
		
		driver = new ChromeDriver(chromeOptions);
		//driver.get("chrome://settings/clearBrowserData");
		//Thread.sleep(1000);
		//driver.switchTo().activeElement();
		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		page = new BasePage(driver, wait);
		driver.manage().deleteAllCookies();
		
			
	}
		
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
	}

	@After
	public void teardown() {
		//driver.close();
		//driver.quit();
	}
	

	
	
	

	/**
	 * Landing and login methods 
	 * @throws Exception 
	 */
	public void navigate_to_a_page(String page) throws Exception {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.doNavigateMenu("Artists");
		
	}	
	
	@Then("^(.*) navigates to the ([^\"]+) page$")
	public void navigate_to_iwc_page(String userType, String iwcPage) {
		
		BasePage basePage = new BasePage(driver, wait);
				
		String navigationMessage = "Navigating to " + iwcPage + " page...";
		try {
			
			basePage.doNavigateMenu(iwcPage);
			switch (iwcPage.toLowerCase()) {
					
			case "home":
				driver.get("https://qa.iwantclips.com");
				IWC_HomePage homePage = new IWC_HomePage(driver, wait);
				// homePage.doLogMessage(navigationMessage);
				break;
				
			case "artists":
				driver.get("https://qa.iwantclips.com/artists");
				IWC_ArtistsPage artistsPage = new IWC_ArtistsPage(driver, wait);
				artistsPage.doLogMessage(navigationMessage);
				break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the ([^\"]+) page is displayed$")
	public void verify_page_is_displayed(String page) {
		
		String currentUrl = driver.getCurrentUrl();
		try {
			if (currentUrl.contains(page)) {
				
				switch(page.toLowerCase()){
				case "store":
					IWC_StorePage iwcStorePage = new IWC_StorePage(driver, wait);
					//iwcStorePage.waitUntilElementIsDisplayed(iwcStorePage.getUserMenuLst());
					break;
				
				case "artists":
					IWC_ArtistsPage iwcArtists = new IWC_ArtistsPage(driver, wait);
					Assert.assertTrue(iwcArtists.getSearchArtistsEdt().isDisplayed());
					break;
				
				default:
					IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
					Assert.assertTrue(iwcHome.getUserMenuLst().isDisplayed());
					break;
				}
			} else {
				IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
				Assert.assertTrue(iwcHome.getUserMenuLst().isDisplayed());
			}
			
			System.out.println("The " + page + ": page was found.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@When("^(.*) submits IWC username(.*) and password(.*)$")
	@When("^(.*) logs in with ([^\"]*) and ([^\"]*)$")
	public void login(String userType, String username, String password) {

		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.login(username, password);
		
	}
	
	
	
	/**
	 * Artist and artist store methods
	 */
	@Given("^(.*) navigates to the Artists page$")
	public void artist_navigate_to_artists_page() {

		IWC_ArtistsPage iwcArtists = new IWC_ArtistsPage(driver, wait);
		
		// iwcArtists.doNavigateMenu("Artists");
		
		driver.get("https://qa.iwantclips.com/artists/");
		wait.until(ExpectedConditions.visibilityOf(iwcArtists.getSearchArtistsEdt()));
			
	}
	
	@Then("artist updates page is displayed")
	public void artist_verify_updates_page_is_displayed() {
	
		IWC_ArtistHomePage artistHome = new IWC_ArtistHomePage(driver, wait);
		
		artistHome.verifyElementIsDisplayed(artistHome.getArtistLinkLnk());
				
	}
		
	@Given("^(.*) navigates to an artist(.*) store page$")
	public void artistStore_navigate_to_artist_store(String artistId) {

		IWC_ArtistsPage iwcArtists = new IWC_ArtistsPage(driver, wait);
		driver.get("https://qa.iwantclips.com/store/" + artistId);
		wait.until(ExpectedConditions.visibilityOf(iwcArtists.getSearchArtistsEdt()));
		
	}

	@When("user clicks Tribute Me button")
	public void artistStore_click_tribute_me_button() {
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.doClick(iwcStore.getTributeMeLnk());

	}
		
	@When("^user(.*) tributes (.*) dollars$")
	public void artistStore_send_tribute(String userType, String amount) {

		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.tipOrTribute(userType, amount);
		
	}
    
	@Then("^tribute(.*) has been sent$")
	public void artistStore_verify_tribute_has_been_sent(String amount){
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.verifyTipOrTributeSent(amount);
		
	}
			
	@When("^user adds an item(.*) to their shopping cart$")
	public void artistStore_add_item_to_shopping_cart(String itemId) {
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.addArtistClipToCartById(itemId);

	}

	@When("^user(.*) checks out$")
	public void artistStore_check_out(String userType) {
		
		IWC_StorePage iwcStore = new IWC_StorePage(driver, wait);
		
		iwcStore.goToShoppingCart();
		iwcStore.checkout("guest");
		
	}

	@Then("a purchase confirmation message is displayed")
	public void artistStore_verify_purchase_confirmation_displays() {

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
	 */
	@When("^(.*) accepts terms of use$")
	public void termsOfUse_accepted(String userType) {
	    
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
				
		iwcHome.acceptTermsOfUse();
				
	}

	@When("^(.*) rejects terms of use$")
	public void termsOfUse_rejected() {
	    
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		iwcHome.rejectTermsOfUse();
				
	}

	@Then("terms of use alert is displayed")
	public void termsOfUse_alert_is_displayed() {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		Assert.assertTrue(iwcHome.getIAmNot18Lnk().isDisplayed());
	}
	
	@Then("terms of use alert is not displayed")
	public void termsOfUse_alert_is_not_displayed() {
		
		IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
		
		Assert.assertFalse(iwcHome.getIAmNot18Lnk().isDisplayed());
	}
	
	
	
	/**
	 * Sign-up methods
	 */
	@When("^artist clicks I (Agree|Disagree) on the Biometric Information notice$")
	public void agree_with_biometric_info_notice(boolean agree) {
		
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
			String username, String email, String password, String question, String answer, String country) {
		
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

	public void new_user_account_is_created() {
		
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
	public void verify_wishlist_item(String itemId) {
		
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
		

/*		
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

*/		

	