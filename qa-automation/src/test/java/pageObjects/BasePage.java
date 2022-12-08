package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		}catch(Exception e) {
			System.out.println("Error occured while getting element: " + locator.toString());
			e.printStackTrace();
		}
		
		return element;
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

	public String getCurrentMethodName() {
		
		// getStackTrace() method, return current method name at 0th index
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
       
        return currentMethodName;
			
	}

    public String getHttpResponseCode(String linkUrl){
    	
        try{
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            
            if(httpURLConnect.getResponseCode() >= 400) {
            	System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " is a broken link");
            }else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
                
        }
        
        // return httpURLConnect.getResponseCode();
        return getHttpResponseCode();
        
        
   }
	
	
	
	
	/**
	 * Waits and checks
	 */
	@Override
	public void waitForElementPresent(WebElement element) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch(Exception e){
			System.out.println("Element not found: " + element.toString());
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void waitForElementNotPresent(WebElement element) {

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
	public void doStartTimer(String description) {
		
		try {
			System.out.print(description + "...");
			startTime = System.currentTimeMillis();
		} catch(Exception e){
			System.out.println("Error occurred while starting clock: " + description);
		}
	}
	
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

	
	/**
	 * Mouse movements
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
	
		


	public void doCreateFile(String filepath) {

        try {
        	File file = new File(filepath);
        	file.getParentFile().mkdirs();
            boolean isFileCreated = file.createNewFile();
        }catch(IOException e){
        	System.out.println("Error creating file: " + filepath);
			e.printStackTrace();   
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
	
	public void doGetAllUrls() {

		String url="";
		List<WebElement> allUrls = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the Wb Page: " + allUrls.size());

		//iterate through the list and check the elements in the list.
		Iterator<WebElement> iterator = allUrls.iterator();
		while (iterator.hasNext()) {
			url = iterator.next().getText();
			System.out.println(url);
		}
	
	}
	
	public void BrokenLinks() {
	   
        //Storing the links in a list and traversing through the links
        List<WebElement> strLinks = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        // System.out.println("No of links are " + strLinks.size());  
      
        //checking the links fetched.
        for(int i=0; i<strLinks.size(); i++)
        {
            WebElement E1= strLinks.get(i);
            String url= E1.getAttribute("href");
            checkLinks(url);
        }
        
    }
	    
	public static void checkLinks(String linkUrl) {
	    try{
	        URL url = new URL(linkUrl);
	
	        //create url connection and get response code
	        HttpURLConnection httpURLConnect = (HttpURLConnection)url.openConnection();
	        httpURLConnect.setConnectTimeout(5000);
	        httpURLConnect.connect();
	        
	        if(httpURLConnect.getResponseCode()>=400){
	        	System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
	        }    
	        //Fetching and Printing the response code obtained
	        else{
	            System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	        }
	    }catch (Exception e){
	  }
	
	}
	
	
}