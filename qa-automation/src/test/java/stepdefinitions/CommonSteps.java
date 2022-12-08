package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.BasePage;
import pageObjects.Page;

public class CommonSteps {

	WebDriver driver;
	WebDriverWait wait;
	public Page page;
	long startTime, endTime, totalTime;
/*	
	@Before
	public void setUp(String browser, String url){
		
		switch(browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
		 		driver = new ChromeDriver();
				System.setProperty("webdriver.chrome.silentOutput", "true");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			default:
				System.out.println("No valid browser defined.");
		}
				
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
			
			// driver.get("https://dev.admin.iwantglobal.com/review/dashboard");			
				
			// driver.get(url);
			
			page = new BasePage(driver, wait);
			
		
	}
	*/
	// @After
	public void teardown() {
		
		driver.close();
		driver.quit();
		
	}
	
}
