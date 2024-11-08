package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage2 {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public BasePage2(WebDriver driver) {
		this.driver=driver;
		this.action=new Actions(driver);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='search']") WebElement searchBtn;
	
	@FindBy(css="span.more-filter.text-md")
	WebElement moreFilterElement;
	
	@FindBy(xpath="/html/body/app-root/main/app-category/pf-clip/div/div[1]/div[3]/pf-clip-filter/div[2]/pf-clip-filter-drawer/div/pf-drawer/div/div[2]/div/div[1]/div[2]/pf-accordion/div/div/accordion/div/accordion-group[2]/div/div[1]/h4") 
	WebElement priceFilter;
	
	@FindBy(xpath="//input[@formcontrolname='inputMax']") 
	WebElement rangeFilter;
	
	@FindBy(xpath="//button//span[contains(text(),'APPLY')]")
	WebElement ApplyBtn;
	
	@FindBy(xpath="//div[@class='dropdown-btn']") 
	WebElement  sortByBtn;
	
	@FindBy(xpath="//li[@data-value='Customer Ratings']")
	WebElement sortByCustomer;
	
	public void searchElement(String value) {
		searchBtn.sendKeys(value);
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void filterForPrice() {
		action.moveToElement(moreFilterElement).perform();
		wait.until(ExpectedConditions.elementToBeClickable(moreFilterElement));
		moreFilterElement.click();
		
	}
	
	public void filterPriceMethod() {
		priceFilter.click();
	}
	public void priceRangeFilter(String value){
		rangeFilter.clear();
		rangeFilter.sendKeys(value);
	}
	public void applyBtn() {
		ApplyBtn.click();
	}
	public void sortByButton() {
		action.moveToElement(sortByBtn).perform();
		wait.until(ExpectedConditions.elementToBeClickable(sortByBtn));
		sortByBtn.click();
		
		
		
	}
	
	public void sortByCustomerDropDown() {
		action.moveToElement(sortByCustomer).click().perform();
	}
	
	
	
	

}
