package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IWC_StorePage extends BasePage {
	
	public static String storeArtistName;
	public static String storeItemName;
	
	/**
	 * CONSTRUCTOR: Ensure the driver and wait variables are initialized using a constructor.
	 * They are declared in the Page class, which is a super (parent) class of the BasePage 
	 * class.
	 */
	public IWC_StorePage(WebDriver driver, WebDriverWait wait) {
		
		super(driver, wait);
		
	}
		
	/**
	 * ENCAPSULATION: The page locators are encapsulated in private (class-level) object 
	 * references (variables). These references have been declared private and as such, 
	 * cannot be accessed outside of this class.
	 */
	private By amountRad;
	private By tipAmountAlr;
	private By artistClipImg;
	private By artistClipAddToCartBtn;
	private By inCartLbl;
		
	private By buyMyClipsBtn = By.xpath("//div[@class='options stacked']");
	private By tributeMeLnk = By.xpath("//div[@class='col-sm-10 col-sm-offset-1 actions']//*[contains(text(), 'Tribute Me')]");
	private By messageMeLnk = By.xpath("//div[@class='col-sm-10 col-sm-offset-1 actions']//*[contains(text(), 'Message Me')]");
	private By favoriteMeLnk = By.xpath("//div[@class='col-sm-10 col-sm-offset-1 actions']//*[contains(text(), 'Favorite Me')]");
	private By shareMeLnk = By.xpath("//div[@class='col-sm-10 col-sm-offset-1 actionsNoBorder']//*[contains(text(), 'Share Me')]");
	private By sendTipBtn = By.xpath("//button[text()='Send Tip']");
	private By shoppingCartIco = By.xpath("//a[contains(@href, 'shopping_cart')]");
	
	/** 
	 * TYPE-CONVERSION: To access the page objects whose references were declared private, 
	 * use public variables (getters). Using getElement, encapsulated 'By' locators are 
	 * converted to WebElements so that relative actions can be taken against the web element
	 * instead of the locator.
	 */
	public WebElement getBuyMyClipsBtn() {
		
		return getElement(buyMyClipsBtn);
		
	}
	public WebElement getTributeMeLnk(){
		
		return getElement(tributeMeLnk);
	
	}	
	public WebElement getMessageMeLnk(){
			
		return getElement(messageMeLnk);
		
	}
	public WebElement getFavoriteMeLnk(){
		
		return getElement(favoriteMeLnk);
	
	}
	public WebElement getShareMeLnk(){
		
		return getElement(shareMeLnk);
	
	}
	public WebElement getSendTipBtn(){
		
		return getElement(sendTipBtn);
	
	}
	public WebElement getShoppingCartIco() {
		return getElement(shoppingCartIco);
	}
	
	// runtime setters
	public WebElement getAmountRad() {
		return getElement(amountRad);
	}
	public WebElement getTipAmountAlr() {
		return getElement(tipAmountAlr);
	}
	public WebElement getArtistClipImg() {
		return getElement(artistClipImg);
	}
	public WebElement getArtistClipAddToCartBtn() {
		return getElement(artistClipAddToCartBtn);
	}
	public WebElement getInCartLbl() {
		return getElement(inCartLbl);
	}
	public String getStoreArtistName() {
		return (storeArtistName);
	}
	public String getStoreItemName() {
		return (storeItemName);
	}
	
	public void setAmountRad(By amountRad) {
		this.amountRad = amountRad;
	}
	public void setTipAmountAlr(By tipAmountAlr) {
		this.tipAmountAlr = tipAmountAlr;
	}
	public void setArtistClipImg(By artistClipImg) {
		this.artistClipImg = artistClipImg;
	}
	public void setArtistClipAddToCartBtn(By artistClipAddToCartBtn) {
		this.artistClipAddToCartBtn = artistClipAddToCartBtn;
	}
	public void setInCartLbl(By inCartLbl) {
		this.inCartLbl = inCartLbl;
	}
	
	
	/** 
	 * These custom methods will be used with this class. The return type should be the next
	 * landing page object class.
	 * @throws Exception 
	 */
	public IWC_StorePage doNavigateToArtistStorePage(String artistId) throws Exception {
		
		try {
			driver.get(siteUrl + "store/" + artistId);
			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentUrl.contains(artistId));
		} catch (Exception e) {
			throw new Exception("");
		}
			
		return getInstance(IWC_StorePage.class);
		
	}
	
	public IWC_StorePage verifyCurrentUrlHasArtistId(String artistId) {
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains(artistId));
		
		return getInstance(IWC_StorePage.class);
		
	}
	public IWC_StorePage verifyStorePageDisplaysArtistName(String artistName) {
		
		String currentPageArtistName = getElement(By.xpath("//span/h1")).getText();
		Assert.assertEquals(artistName + " clicked, but current page is " + currentPageArtistName, currentPageArtistName, artistName);
		return getInstance(IWC_StorePage.class);
	}
	public IWC_StorePage verifyItemPageDisplaysItemName(String itemName){
		
		String currentPageItemName = getElement(By.xpath("//span[@class='headline hidden-xs']")).getText();
		Assert.assertEquals(itemName + " clicked, but current page shows " + currentPageItemName, currentPageItemName, itemName);
		return getInstance(IWC_StorePage.class);
	}
	public IWC_StorePage verifyItemPageDisplaysArtistName(String artistName){
		
		String currentPageArtistName = getElement(By.xpath("//a[@class='modelLink']")).getText();
		Assert.assertEquals(artistName + " expected, but current page shows " + currentPageArtistName, currentPageArtistName, artistName);
		return getInstance(IWC_StorePage.class);
	}
	
	public IWC_StorePage tipOrTribute(String userType, String amount) throws Exception {
		
		setAmountRad(By.xpath("//input[@type='radio' and @value='" + amount + "']"));
		
		doClick(getTributeMeLnk());
		doClick(getAmountRad());
		
		IWC_ShoppingCartPage iwcCart = new IWC_ShoppingCartPage(driver, wait);
		
		if(userType.toLowerCase().compareTo("member")==0) {
			doClick(getSendTipBtn());
			iwcCart.submitPaymentInfo("member");
		}else{
			iwcCart.submitPaymentInfo("guest");
		}
		
		return getInstance(IWC_StorePage.class);
		
	}
	public IWC_StorePage addArtistClipToCartByInstance(long instance){
		
		setArtistClipImg(By.xpath("(//div[contains(@id, 'clip-')])[" + instance + "]"));
		setArtistClipAddToCartBtn(By.xpath("//button[contains(text(), 'Add to Cart']"));
				
		doClick(getArtistClipImg());
		doClick(getArtistClipAddToCartBtn());
		
		return getInstance(IWC_StorePage.class);
	}
	public IWC_StorePage addArtistClipToCartById(String itemId){
		
		setArtistClipImg(By.id("clip-" + itemId));
		setArtistClipAddToCartBtn(By.xpath("(//button[@data-id='" + itemId + "' and text()=' Add to Cart'])[1]"));
		setInCartLbl(By.xpath("//button[@data-id='" + itemId + "' and text()='In Cart']"));
		
		doClick(getArtistClipImg());
		doClick(getArtistClipAddToCartBtn());
		
		return getInstance(IWC_StorePage.class);
	}
	
	public IWC_ShoppingCartPage goToShoppingCart() throws Exception{
		
		IWC_ShoppingCartPage iwcCart = new IWC_ShoppingCartPage(driver, wait);
		
		doClick(getShoppingCartIco());
		verifyElementIsDisplayed(iwcCart.getCheckoutBtn());
		
		return getInstance(IWC_ShoppingCartPage.class);
	}
	public IWC_ShoppingCartPage checkout(String userType) throws Exception {
		
		IWC_ShoppingCartPage iwcCart = new IWC_ShoppingCartPage(driver, wait);
		
		doClick(iwcCart.getCheckoutBtn());
		iwcCart.submitPaymentInfo(userType);
		verifyElementIsDisplayed(iwcCart.getSuccessfulAlr());
		
		return getInstance(IWC_ShoppingCartPage.class);
		
	}
	public IWC_ShoppingCartPage verifyTipOrTributeSent(String amount) throws Exception {
		
		setTipAmountAlr(By.xpath("//span[text()='" + amount + ".00'"));
		
		IWC_ShoppingCartPage iwcCart = new IWC_ShoppingCartPage(driver, wait);
		verifyElementIsDisplayed(iwcCart.getTipOrTributeSentAlr());
		verifyElementIsDisplayed(getTipAmountAlr());
		
		return getInstance(IWC_ShoppingCartPage.class);
	}

}
