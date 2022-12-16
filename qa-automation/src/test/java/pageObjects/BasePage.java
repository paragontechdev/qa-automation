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
import java.util.Iterator;
import java.util.List;

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

public class BasePage extends Page{
	
	long startTime, endTime, totalTime;
	
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
	public String getPageTitle() {

		return driver.getTitle();
		
	}
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
				
	}
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

		URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.connect();

        int intResponseCode = connection.getResponseCode();
        String strResponseMessage = connection.getResponseMessage();
        System.out.println("Response: " + intResponseCode + " - " + strResponseMessage);
        
        return intResponseCode;
        
	 }
	
	
	/**
	 * Waits and checks
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
	@Override
	public void verifyElementIsDisplayed(WebElement element) {
		
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isDisplayed());
		}catch(Exception e){
			System.out.println("Expected web element not displayed: " + element.toString());
			e.printStackTrace();
		}
	}
	@Override
	public void verifyElementIsNotDisplayed(WebElement element) {
	
		try{
			wait.until(ExpectedConditions.invisibilityOf(element));
			Assert.assertFalse(element.isDisplayed());
		}catch(Exception e){
			System.out.println("Unexpected web element displayed: " + element.toString());
			e.printStackTrace();
		}
	}
	@Override
	public void verifyElementIsEnabled(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.isEnabled());
		}catch (Exception e){
			System.out.println("Error finding enabled object: " + element.toString());
			e.printStackTrace();
		}
	}
	@Override
	public void verifyElementIsDisabled(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertFalse(element.isEnabled());
		}catch (Exception e){
			System.out.println("Error finding disabled object: " + element.toString());
			e.printStackTrace();
		}
	}
	
	@Override
	public void verifyPageIsDisplayed(String expectedPage) {
		//TODO
	}
	
	
	/**
	 * Interface actions
	 */
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
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		}catch(Exception e){
			System.out.println("Error clicking web element: " + element.toString());
			e.printStackTrace();
			
			// click sign-on button
		}
	}	
	@Override
	public void doSendKeys(WebElement element, String text) {
		
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
		}catch(Exception e){
			System.out.println("Error setting text value: " + element.toString());
			e.printStackTrace();
		}
	}
	@Override
	public void doMouseOver(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
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
			wait.until(ExpectedConditions.visibilityOf(element));
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
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
		}catch(Exception e){
			System.out.println("Error clearing text object: " + element.toString());
			e.printStackTrace();
		}	
		
	}
	
	public void doNavigateMenu(String page) {
		
		try {
			WebElement menuItem = driver.findElement(By.xpath("//a[contains(text(), '" + page + "')]"));
			verifyElementIsDisplayed(menuItem);
			verifyElementIsEnabled(menuItem);
			doClick(menuItem);
					
			switch (page) {
				case "home": 
					getInstance(IWC_HomePage.class);
				case "artist": 
					getInstance(IWC_ArtistsPage.class);
				default: break;
		    }
		}catch (Exception e){
			e.printStackTrace();
		}
	
	}

	/**
	 * Other useful methods
	 */
	@Override
	public void getCurrentPageBrokenLinks() throws MalformedURLException, IOException {
		   
		// Get all page links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total link count: " + links.size());
                
 	    // Iterate through each link
 	    for (WebElement link : links) {
 	    	String url = link.getAttribute("href");
 	    	HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
 	    	connection.setRequestMethod("HEAD");
 	    	connection.connect();
 	    	
 	    	// If the response code is not 200 (OK), the link may be broken
 	    	if (connection.getResponseCode() != 200) {
 	    		int intResponseCode = connection.getResponseCode();
 	    		String strResponseMessage = connection.getResponseMessage();
 	    		System.out.println("Verify response: " + intResponseCode + " - " + strResponseMessage);
 	        }
 	    }
    }
	@Override
	public void getStatusOfAllLinksOnCurrentPage() throws MalformedURLException, IOException {
		   
		// Get all page links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total link count: " + links.size());
                
 	    // Iterate through each link
 	    for (WebElement link : links) {
 	    	String url = link.getAttribute("href");
 	    	HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
 	    	connection.setRequestMethod("HEAD");
 	    	connection.connect();
 	    	
 	    	// Print link status
 	    	int intResponseCode = connection.getResponseCode();
 	    	String strResponseMessage = connection.getResponseMessage();
 	    	System.out.println("Verify response: " + intResponseCode + " - " + strResponseMessage);
 	    }
    }
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

}
