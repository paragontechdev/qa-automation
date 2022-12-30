package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
// import stepdefinitions.DashboardPage;

public class BasePage extends Page{
	
	public long startTime, endTime, totalTime;
		
	// constructor
	public BasePage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
	
	}
	
	/**
	 * METHOD OVERRIDING: These inherited methods were declared as abstract in the Page class. 
	 * These are the method bodies. 
	 */
	
	/**
	 * Get object values
	 */
	@Override
	public String getCurrentPage() {
		
		String currentUrl = driver.getCurrentUrl();
		String currentPage;
		
		if (currentUrl.contains("artist")) currentPage = "Artists";
			else if (currentUrl.contains("store")) currentPage = "Store";
			else if (currentUrl.contains("top_lists")) currentPage = "Top Lists";
		else currentPage = "Home";
		
		
		return currentPage;
	}
	@Override
	public String getPageTitle() {

		return driver.getTitle();
		
	}
	@Override
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
				
	}
	@Override
	public WebElement getElement(By locator) {
	    WebElement element = null;

	    try {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        element = driver.findElement(locator);
	        return element;
	    } catch (NoSuchElementException e) {
	        System.out.println("Error occured while getting element: " + locator.toString() + ". Element not found.");
	        return null;
	    } catch (TimeoutException e) {
	        System.out.println("Error occured while getting element: " + locator.toString() + ". Element not visible.");
	        return null;
	    } catch (Exception e) {
	        System.out.println("Error occured while getting element: " + locator.toString());
	        e.printStackTrace();
	        return null;
	    }
	}
	@Override
	public String getText(WebElement element) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e){
			System.out.println("Error getting text: " + element.toString());
			e.printStackTrace();
		}	
		
		return element.getText();
	
	}
	@Override
	public String getCurrentMethodName() {
		
		// getStackTrace() method, return current method name at 0th index
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
       
        return currentMethodName;
			
	}
	@Override
	public int getHttpResponseCode(String link) throws MalformedURLException, IOException {
		int i = 0, intResponseCode = 0;
		String url = null;
		HttpURLConnection connection = null;
		
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(5000);
	        connection.connect();
	
	        intResponseCode = connection.getResponseCode();
	        String strResponseMessage = connection.getResponseMessage();
	        System.out.println("Response: " + intResponseCode + " - " + strResponseMessage);
	    }catch(Exception e) {
			System.out.println("Error establishing connection to URL: " + i + ": " + url + "\n");
		}
		
		return intResponseCode;
	 }
	@Override
	public void getStatusOfCurrentPageLinks(boolean logBrokenLinksOnly) throws MalformedURLException, IOException {
		int i = 0, intResponseCode = 0;
		String url = null, strResponseMsg = null;
		HttpURLConnection connection = null;
		
		// Get all page links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		     
		try {
		 	// Iterate through each link
		 	for (WebElement link : links) {
		 		i++;
		 		url = link.getAttribute("href");
		 		
		 		// open a connection and get http response
		 		try {
			 		connection = (HttpURLConnection) new URL(url).openConnection();
			 		connection.setRequestMethod("HEAD");
			 		connection.setConnectTimeout(5000);
			        connection.connect();
			 		
			        // log response
			 		intResponseCode = connection.getResponseCode();
			 		strResponseMsg = connection.getResponseMessage();
			 		
			 		if (logBrokenLinksOnly & intResponseCode >= 400) {
			 			System.out.println("Link #" + i + " of " + links.size());
			 			System.out.println(url);
			 			System.out.println("Response: " + intResponseCode + "-" + strResponseMsg + "\n");
			 		}else {
			 			Assert.assertTrue(intResponseCode < 400);
			 		}
			 		
		 		} catch (IOException e) {
		 			// Log the exception and continue iterating through the links
		 			System.out.println(e.getMessage());
		 			System.out.println("Error establishing connection to URL: " + i + ": " + url + "\n");
		 			continue;
		 		}
		 	}
		} catch (Exception e) {
			System.out.println("Error retreiving link attributes: " + i + ": " + url + "\n");
		}
	}
	
	public String getArtistId(String link){
		return link;
	}
	
	/**
	 * Wait for object property
	 */
	@Override
	public void waitUntilElementIsEnabled(WebElement element) {

		Assert.assertTrue(element.isEnabled());
		
	}
	@Override
	public void waitUntilElementIsDisabled(WebElement element) {

		Assert.assertFalse(element.isEnabled());
				
	}
	@Override
	public void waitUntilElementIsDisplayed(WebElement element) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch(Exception e){
			System.out.println("Element not found: " + element.toString());
			e.printStackTrace();
		}
		
	}
	@Override
	public void waitUntilElementIsNotDisplayed(WebElement element) {

		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch(Exception e){
			System.out.println("Element found unexpectedly: " + element.toString());
			e.printStackTrace();
		}
		
	}
	@Override
	public void waitForPageTitle(String expectedPageTitle) {

		try {
			wait.until(ExpectedConditions.titleContains(expectedPageTitle));
		} catch(Exception e){
			System.out.println("Error occurred while waiting for page title: " + expectedPageTitle);
		}
		
	}

	
	/**
	 * Verify for object property
	 */
	@Override
	public void verifyElementIsDisplayed(WebElement element) throws Exception{
		
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
		}catch(Exception e){
			throw new Exception("Expected web element not displayed: " + element.toString());
		}
	}
	@Override
	public void verifyElementIsNotDisplayed(WebElement element) throws Exception {
	
		try{
			wait.until(ExpectedConditions.invisibilityOf(element));
			Assert.assertFalse(element.isDisplayed());
		}catch(Exception e){
			throw new Exception("Expected web element displayed: " + element.toString());
		}
	}
	@Override
	public void verifyElementIsEnabled(WebElement element) throws Exception {
		try {
			verifyElementIsDisplayed(element);
			Assert.assertTrue(element.isEnabled());
		}catch(Exception e){
			throw new Exception("Enabled object not found.");
		}
	}
	@Override
	public void verifyElementIsDisabled(WebElement element) throws Exception {
		try {
			verifyElementIsDisplayed(element);
			Assert.assertFalse(element.isEnabled());
		}catch(Exception e){
			throw new Exception("Disabled object not found: " + element.toString());
		}
	}
	@Override
	public void verifyPageIsDisplayed(String expectedPage) throws Exception {

		String currentPage = driver.getTitle();
		
		try {
			
			if (currentPage.contains(expectedPage)) {
				
				switch(expectedPage.toLowerCase()){
				case "top lists":
					IWC_TopListsPage iwcTopListsPage = new IWC_TopListsPage(driver, wait);
					Assert.assertEquals(iwcTopListsPage.getCurrentPage(), "Top Lists");
					break;
				
				case "store":
					IWC_StorePage iwcStorePage = new IWC_StorePage(driver, wait);
					Assert.assertEquals(iwcStorePage.getCurrentPage(), "Store");
					break;
				
				case "artists":
					IWC_ArtistsPage iwcArtists = new IWC_ArtistsPage(driver, wait);
					Assert.assertEquals(iwcArtists.getCurrentPage(), "Artists");
					break;
				
				default:
					IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
					Assert.assertEquals(iwcHome.getCurrentPage(), "Home");
					break;
				}
			} else {
				IWC_HomePage iwcHome = new IWC_HomePage(driver, wait);
				Assert.assertTrue(iwcHome.getUserMenuLst().isDisplayed());
			}
			
		} catch(Exception e) {
			throw new Exception("Error getting current page name.");
		}
		
	}
	
	
	/**
	 * Interface actions
	 */
	@Override
	public void doStartTimer(String description) {
		
		try {
			System.out.print(description + "...");
			startTime = System.currentTimeMillis();
		} catch(Exception e){
			System.out.println("Error occurred while starting clock: " + description);
		}
	}
	@Override
	public void doStopTimer() {
		
		try {
			endTime = System.currentTimeMillis();
			totalTime = endTime - startTime;
			System.out.println("Done in " + totalTime + "ms");
		} catch(Exception e){
			System.out.println("Error occurred while stopping clock.");
		}
	}
	@Override
	public void doScrollToElement(WebElement element) {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);", element);     
		} catch(Exception e){
			System.out.println("Error occurred while trying to locate element: " + element);
		}
	}	
	@Override
	public void doClick(WebElement element) {
		
		try {
			waitUntilElementIsDisplayed(element);
			waitUntilElementIsEnabled(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
		}catch(Exception e){
			System.out.println("Error finding web element to click.");
		}
	}	
	@Override
	public void doSendKeys(WebElement element, String text) throws Exception {
		
		try{
			waitUntilElementIsDisplayed(element);
			doClear(element);
			element.sendKeys(text);
		}catch(Exception e){
			System.out.println("Error setting text value: " + element.toString());
			e.printStackTrace();
		}
		
	}
	@Override
	public void doMouseOver(WebElement element) {
		try {
			waitUntilElementIsDisplayed(element);
			element.clear();
			
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
		}catch (Exception e){
			System.out.println("Error mousing over object: " + element.toString());
			e.printStackTrace();
		}
	}
	@Override
	public void doSelect(WebElement element, String option) {
		
		try{
			waitUntilElementIsDisplayed(element);
			Select dropdownOpt = new Select(element);
			dropdownOpt.selectByVisibleText(option);
		}catch(Exception e){
			System.out.println("Error selecting dropdown value: " + element.toString());
			e.printStackTrace();
		}		
	}
	@Override
	public void doClear(WebElement element) {
		
		try {
			waitUntilElementIsDisplayed(element);
			element.clear();
		}catch(Exception e){
			System.out.println("Error clearing text object: " + element.toString());
			e.printStackTrace();
		}	
		
	}
	public void doNavigateToPage(String page) throws Exception {
		
		// Create a mapping of page names to page classes. Add more page names and classes as needed.
		Map<String, Class<? extends BasePage>> pageClassMap = new HashMap<>();
		pageClassMap.put("Home", IWC_HomePage.class);
		pageClassMap.put("Artists", IWC_ArtistsPage.class);
		pageClassMap.put("Top Lists", IWC_TopListsPage.class);
				
		try {
			// Get the page class for the specified page name
			Class<? extends BasePage> pageClass = pageClassMap.get(page);
			if (pageClass == null) {
				throw new IllegalArgumentException("Invalid page name: " + page);
			} else {
				try {
					By menuItem = By.partialLinkText(page);

					switch (page.toLowerCase()) {
					// Expected values are found in the getCurrentPage() method
					case "home":
						driver.get("https://qa.iwantclips.com");
						IWC_HomePage homePage = new IWC_HomePage(driver, wait);
						Assert.assertEquals(homePage.getCurrentPage(), "Home");
						break;
						
					case "artists":
						getElement(menuItem).click();
						IWC_ArtistsPage artistsPage = new IWC_ArtistsPage(driver, wait);
						Assert.assertEquals(artistsPage.getCurrentPage(), "Artists");
						break;
						
					case "top lists":
						getElement(menuItem).click();
						IWC_TopListsPage topListsPage = new IWC_TopListsPage(driver, wait);
						Assert.assertEquals(topListsPage.getCurrentPage(), "Top Lists");
						break;
						
					}
				} catch (Exception e) {
					throw new Exception("");
				}
			}
			
			// Instantiate the page object
			getInstance(pageClass);
		} catch (RuntimeException e) {
			// Handle the error in a more meaningful way, such as by throwing a custom exception
			throw new Exception("Error navigating to " + page + " page.");
		}
	}
	
	
	/**
	 * Other useful methods
	 * 
	 */
	@Override
	public void doCreateFile(String filepath) {

	    try {
	    	File file = new File(filepath);
	    	file.getParentFile().mkdirs();
	        boolean isFileCreated = file.createNewFile();
	        if (!isFileCreated) {
		        throw new IOException("File already exists: " + filepath);
	        }
	    } catch (SecurityException e) {
		      System.out.println("Error creating file: " + filepath);
		      System.out.println("Cause: " + e.getMessage());
	    } catch (IOException e) {
		      System.out.println("Error creating file: " + filepath);
		      System.out.println("Cause: " + e.getMessage());
	    }
    }
	@Override
	public void doFileUpload(WebElement element, String filepath) {
		try {
			doClick(element);
			
			Robot robot = new Robot();
			
			// copying file path to Clipboard
			StringSelection str = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
			// press CTRL+V for pasting
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyRelease(KeyEvent.VK_V);
		 
			// for pressing and releasing Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			System.out.println("Error uploading file: " + filepath);
			e.printStackTrace();
		}
	}
	@Override
	public void doLogMessage(String logMessage) {
		
		System.out.println(logMessage);
		
	}

}
