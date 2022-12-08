package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.IWG_DashboardPage;
import pageObjects.IWG_LoginPage;
import pageObjects.IWG_ReviewQueuePage;
import pageObjects.IWG_ReviewQueuePage;
import pageObjects.IWC_HomePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CrpCommonSteps {

/*
	
//	WebDriver driver;
	WebDriverWait wait;
	long startTime, endTime, totalTime;
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
	

	*/	
		
	
/*
	
	//@Given("^([^\"]+) access(es)?( to)? the CRP Review Dashboard$")
	@Given("^.* access to the CRP Review Dashboard$")
	public void crp_review_dashboard() {
		
		IWG_LoginPage loginPage = new IWG_LoginPage(driver);
		// loginPage.startTimer("Logging in");
		loginPage.login("kevin.m@stackunited.com", "&Z5DFOk6IfjA");
		IWG_DashboardPage dashboardPage = new IWG_DashboardPage(driver, wait);
		driver.findElement(dashboardPage.documentsNeedingReviewLnk);
		// loginPage.stopTimer();
		
	}
	
	// @When("^.* navigates to the ([^\"]+) Queue$")
	public void crp_queue(String queueContent) {		
		WebElement element = null; 
		String expectedUrl = null;
		IWG_DashboardPage dashboardPage = new IWG_DashboardPage(driver, wait);
		dashboardPage.startTimer("Navigate to " + queueContent + " Queue");
		
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
		dashboardPage.stopTimer();
		
	}

	@When("^.* navigates to the ([^\"]+) Review Queue$")
	public void crp_review_queue(String queueContent) {		
		WebElement element = null; 
		String expectedUrl = null;
		IWG_DashboardPage dashboardPage = new IWG_DashboardPage(driver, wait);
		dashboardPage.startTimer("Navigate to " + queueContent + " Queue");
		
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
		dashboardPage.stopTimer();
		
	}
		
	@When(".* clicks? the ([^\"]+) link in the ([^\"]+) Queue?$")
	public void crp_queue_link(String queueContent, String link) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(IWG_ReviewQueuePage.lnkAll));
		
		driver.findElement(IWG_ReviewQueuePage.lnkAll).click();
		
	}
		
	@When(".* clicks? the ([^\"]+) link in the ([^\"]+) Review?$")
	public void crp_review_queue_link(String queueContent, String link) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(IWG_ReviewQueuePage.lnkAll));
		
		driver.findElement(IWG_ReviewQueuePage.lnkAll).click();
		
	}
	
	
	
	
/*	
	
	
	//@When("^[^ ]* open(s)? the [rR]eview( [qQ]ueue)?( [pP]age)?$")
	@When("^the ([^\"]+) Review History page is opened$")
	public void crp_review_history(String queueContent) {
		String expectedUrl = null;
		IWG_ReviewQueuePage historyPage = new IWG_ReviewQueuePage(driver, wait);
		
		historyPage.startTimer("Navigate to Review History");
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
		historyPage.stopTimer();
		
	}
	
	//@Then("^([^\"]+) section contains ([^\"]+)?")
	@Then("^.*Content Overview section contains ([^\\\"]+)$")
	public void crp_content_overview_section(String heading) {
	    
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Check Content Overview");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[(text()='Title:')]")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[(text()='" + heading + ":')]")));
		crp.stopTimer();
		
	}
	
	//@When("^([^\"]+) clicks? the [rR]eview button$")
	@When("user clicks the Review button")
	public void crp_reviewDetails() {
		
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Click the Review button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(crp.btnReview));
		crp.clickReviewButton();
		crp.stopTimer();
		
	}
	
	@When("the Reviewer clicks \'Store Name\'")
	public void clickStoreName(String storeName) {
	    
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Click the Store link");
		wait.until(ExpectedConditions.visibilityOfElementLocated(crp.btnReview));
		crp.clickReviewButton();
		crp.stopTimer();
		
	}

	@Then("The Reviewers browser will open the respective Admin panel in a new tab")
	public void the_reviewers_browser_will_open_the_respective_admin_panel_in_a_new_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("^[^ ]* selects? an? ([^\"]+) from the( list)?( queue)?$")
	public void crp_select_top_record_in_queue(String type) {
		
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Select a " + type);
		wait.until(ExpectedConditions.visibilityOfElementLocated(crp.btnReview));
		crp.stopTimer();
		
	}

	@When("^I? click?( the)? ([^\"]+) radio button$")
	public void crp_clickApprovedRadio_button() {
			
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Click the Approved radio button");
		crp.click(crp.radApproved);
		crp.stopTimer();
		
	}
	
	@When("^I? clicks? (the)?[sS]ave button$")
	public void crp_click_crp_save_button() {
				
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Click save button");
		crp.scrollIntoView(crp.btnSave);
		crp.click(crp.btnSave);
		wait.until(ExpectedConditions.visibilityOfElementLocated(crp.alrContentReviewUpdated));
		crp.stopTimer();
		
	}
	
	@Then("^(the )?[Cc]urrent [sS]tatus is ([^\"]+)$")
	public void crp_get_content_status(String status) throws InterruptedException {
		
		IWG_ReviewQueuePage crp = new IWG_ReviewQueuePage(driver, wait);
		crp.startTimer("Confirm current status");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-12'][5]")));
		
		String displayedStatusText = (driver.findElement(crp.lblCurrentStatus).getText());
		Assert.assertTrue(status.compareTo(displayedStatusText.replace("Current Status:",  "").trim()) == 0);

		// Hard-coded...
		//String expectedStatus = "3 - Published";
		//assertTrue(expectedStatus.compareTo(displayedStatusText.replace("Current Status:",  "").trim()) == 0);
		
		crp.stopTimer();
		
	}
		
	@When("the user submits username and password")
	public IWC_HomePage the_user_submits_username_and_password(String username, String password) {

		IWC_HomePage homePage = new IWC_HomePage(driver, wait);
		
		homePage.getEdtEmail().sendKeys(username);
		homePage.getEdtPassword().sendKeys(username);
		homePage.getBtnLogin().click();
		
		return homePage.getInstance(IWC_HomePage.class);
		
	}
	
	

/*	
	
@Given("A Reviewer is reviewing the Videos, Images, or Documents queue")
public void a_reviewer_is_reviewing_the_videos_images_or_documents_queue() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("The Reviewer clicks the detail view of the content item")
public void the_reviewer_clicks_the_detail_view_of_the_content_item() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("The Reviewer will see the associated {string} under the {string} section")
public void the_reviewer_will_see_the_associated_under_the_section(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
	
*/
	
}
