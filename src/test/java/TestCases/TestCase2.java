package TestCases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.BasePage2;


public class TestCase2 {
	
	WebDriver driver;
	
	@BeforeClass(groups={"sanity","Master"})
	void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,groups= {"regression","Master"})
	void sendingSearchData() throws InterruptedException {
		BasePage2 bs=new BasePage2(driver);
		bs.searchElement("study chairs");
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		Thread.sleep(2000);
	}
	
	@Test(priority=2,groups= {"regression","Master"})
	void filterForPriceMethod() throws InterruptedException {
		BasePage2 bs=new BasePage2(driver);
		bs.filterForPrice();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,groups= {"regression","Master"})
	void filterforPriceRangeClick() {
		BasePage2 bs=new BasePage2(driver);
		bs.filterPriceMethod();
	}
	
	
	@Test(priority=4,groups= {"regression","Master"})
	void priceRangeValue() throws InterruptedException {
		BasePage2 bs=new BasePage2(driver);
		bs.priceRangeFilter("15000");
		Thread.sleep(3000);
	}
	
	@Test(priority=5,groups= {"regression","Master"})
	void clickApplyButton() {
		BasePage2 bs=new BasePage2(driver);
		bs.applyBtn();
	}
	
	@Test(priority=6,groups= {"regression","Master"})
	void clickDropDown() {
		BasePage2 bs=new BasePage2(driver);
		bs.sortByButton();
	}
	
	
	@Test(priority=7,groups= {"regression","Master"})
	void sortByCustomersValue() {
		BasePage2 bs=new BasePage2(driver);
		bs.sortByCustomerDropDown();
	}
	@AfterClass(groups={"sanity","Master"})
	void tearDown() {
		driver.quit();
	}


}
