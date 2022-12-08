package stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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


public class IWC_ArtistsSteps {

	WebDriver driver;
	WebDriverWait wait;
	public Page page;
	long startTime, endTime, totalTime;
	
	public void upload(){
	
		IWC_ArtistHomePage iwcArtists = new IWC_ArtistHomePage(driver, wait);
		
		iwcArtists.setUploadDetails("Title", "c:\temp\testfile.mp4");
		
		iwcArtists.doClick(iwcArtists.getLaunchPreviewGeneratorBtn());
		iwcArtists.setUploadOptions(false, false, false, false);
		iwcArtists.setComplianceRequiremnents(true, false);
		
		iwcArtists.doClick(iwcArtists.getAgreementChk());
		iwcArtists.doClick(iwcArtists.getSaveBtn());
	
	}
	
	
	
	
}
