package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftCard {
	
WebDriver driver;
	
	Actions action;
	
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public GiftCard(WebDriver driver) {
		this.driver=driver;
		this.action=new Actions(driver);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@data-test='giftCard']") 
	WebElement giftcardMenu;
	
	@FindBy(xpath="//a//img[@alt='Pepperfry Birthday Gift Card']")
	WebElement happyBirthdayCard;
	
	@FindBy(xpath="//input[@formcontrolname='rname']")
	WebElement Name;
	
	@FindBy(xpath="//input[@formcontrolname='rmob']")
	WebElement Number;
	
	
	@FindBy(xpath="//input[@formcontrolname='rmail']")
	WebElement Email;
	
	@FindBy(xpath="//textarea[@formcontrolname='rmsg']")
	WebElement Message;
	
	@FindBy(xpath="//input[@formcontrolname='sname']")
	WebElement fromName;
	
	@FindBy(xpath="//input[@formcontrolname='smob']")
	WebElement fromNumber;
	
	@FindBy(xpath="//input[@formcontrolname='smail']")
	WebElement fromemail;

	@FindBy(xpath="/html/body/app-root/main/pf-gc-product-page/div/div/div/div/div[1]/section/div/div[2]/div[2]/pf-gc-denomination-card/div/div[2]/div[1]/a")
	WebElement denomination;
	
	
	public void clickingOnGiftCard() {
		giftcardMenu.click();
	}
	
	public void clickingHappyBirthdayCard() {
		action.moveToElement(happyBirthdayCard).click().perform();
	}
	public void EnterName(String value) {
		Name.sendKeys(value);
	}
	
	public void EnterNumber(String value) {
		Number.sendKeys(value);
	}
	public void EnterEmail(String value) {
		Email.sendKeys(value);
	}
	
	public void EnterMessage(String value) {
		Message.sendKeys(value);
	}
	
	public void EnterfromName(String value) {
		fromName.sendKeys(value);
	}
	public void EnterfromNumber(String value) {
		fromNumber.sendKeys(value);
	}
	
	public void Enterfrommail(String value) {
		fromemail.sendKeys(value);
	}
	
	public void addDenomination() {
		action.moveToElement(denomination).perform();
		wait.until(ExpectedConditions.elementToBeClickable(denomination));
    	denomination.click();
	}
	
}
