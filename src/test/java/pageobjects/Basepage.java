package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	
	WebDriver driver;
	
	Actions action;
	
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Basepage(WebDriver driver) {
		this.driver=driver;
		this.action=new Actions(driver);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@id='search']") WebElement searchBtn;
	
	@FindBy(css="span.more-filter.text-md")
	WebElement moreFilterElement;
	
	@FindBy(xpath="/html/body/app-root/main/app-category/pf-clip/div/div[1]/div[3]/pf-clip-filter/div[2]/pf-clip-filter-drawer/div/pf-drawer/div/div[2]/div/div[1]/div[2]/pf-accordion/div/div/accordion/div/accordion-group[3]/div/div/h4")
	WebElement priceFilter;
	
	@FindBy(xpath="//input[@formcontrolname='inputMax']") 
	WebElement  rangeFilter;
	
	@FindBy(xpath="//div[@data-test='clip_filter_apply_button']//button")
	WebElement ApplyBtn;
	
	@FindBy(xpath="//div[@class='dropdown-btn']")
	WebElement softByBtn;
	
	@FindBy(xpath="//li[@data-value='Customer Ratings']")
	WebElement sortByCustomer;
	
	public void searchElement(String value) {
		searchBtn.sendKeys(value);
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void moreFilterMethod() {
		moreFilterElement.click();
		wait.until(ExpectedConditions.visibilityOf(moreFilterElement));
	}
	
	public void filterPriceMethod() {
		priceFilter.click();
	}
	
	public void priceRangeFilter(String value) {
		rangeFilter.clear();
		rangeFilter.sendKeys(value);
	}
	
	public void applyBtn() {
		ApplyBtn.click();
	}
	
	public void sortByButton() {
		action.moveToElement(softByBtn).click().perform();
	}
	
	public void customerRantingSort() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortByCustomer);
	}

}
