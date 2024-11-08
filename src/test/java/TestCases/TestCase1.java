package TestCases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.Basepage;

public class TestCase1 {
	WebDriver driver;
	
	
	@BeforeClass(groups={"sanity","Master"})
	@Parameters({"browser"})
	void setup(String br) {
		
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default:System.out.println("Invalid browser");return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,groups= {"regression","Master"})
	void sendingSearchData() {
		Basepage bs=new Basepage(driver);
		bs.searchElement("bookShelves");
//		Actions act=new Actions(driver);
//		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		System.out.println("method 1");
		
	}
	
	@Test(priority=2,groups= {"regression","Master"})
	void clickingMoreFilter() throws InterruptedException {
		Basepage bs=new Basepage(driver);
		bs.moreFilterMethod();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,groups= {"regression","Master"})
	void clickingPriceFilter() {
		Basepage bs=new Basepage(driver);
		bs.filterPriceMethod();
		
	}
	
	@Test(priority=4,groups= {"regression","Master"})
	void sendingPriceRangeFilter() throws InterruptedException {
		Basepage bs=new Basepage(driver);
		bs.priceRangeFilter("15000");
		Thread.sleep(2000);
	}
	
	@Test(priority=5,groups= {"regression","Master"})
	void clickingApplyBtn() {
		Basepage bs=new Basepage(driver);
		bs.applyBtn();
	}
	
	@Test(priority=6,groups= {"regression","Master"})
	void sortingDropDownClick() {
		Basepage bs=new Basepage(driver);
		bs.sortByButton();
	}
	
	@Test(priority=7,groups= {"regression","Master"})
	void customerRatingClick() throws InterruptedException {
		Basepage bs=new Basepage(driver);
		bs.customerRantingSort();
		Thread.sleep(3000);
	}
	@AfterClass(groups= {"sanity"})
	void tearDown() {
		driver.quit();
	}

}
