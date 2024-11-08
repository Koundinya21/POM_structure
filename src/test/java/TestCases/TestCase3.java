package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.GiftCard;

public class TestCase3 {
	
	WebDriver driver;

	
	@BeforeClass(groups={"sanity","Master"})
	void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1,groups= {"regression","Master"})
	void clickGiftCardMenu() throws InterruptedException {
		GiftCard gc=new GiftCard(driver);
		gc.clickingOnGiftCard();
		Thread.sleep(3000);
	}
	
	@Test(priority=2,groups= {"regression","Master"})
	void clickHappyBirthdayCard() {
		GiftCard gc=new GiftCard(driver);
		gc.clickingHappyBirthdayCard();
	}
	
	@Test(priority=3,groups= {"regression","Master"})
	void EnterNameValue() {
		GiftCard gc=new GiftCard(driver);
		gc.EnterName("klaus");
		
	}
	
	@Test(priority=4,groups= {"regression","Master"})
	void EnterNumberValue() {
		GiftCard gc=new GiftCard(driver);
		gc.EnterNumber("6969696969");
		
		
	}
	
	@Test(priority=5,groups= {"regression","Master"})
	void EnterEmailValue() {
		GiftCard gc=new GiftCard(driver);
		gc.EnterEmail("KlausMikelson@gmail.com");
		
		
	}
	@Test(priority=6,groups= {"regression","Master"})
	void EnterMessageValue() {
		GiftCard gc=new GiftCard(driver);
		gc.EnterMessage("Hell");
		
		
	}
	
	@Test(priority=7,groups= {"regression","Master"})
	void EnterFromNameValue() {
		GiftCard gc=new GiftCard(driver);
		gc.EnterfromName("Elijha");
		
		
	}
	@Test(priority=8,groups= {"regression","Master"})
	void EnterFromNumberValue() {
		GiftCard gc=new GiftCard(driver);
		gc.EnterfromNumber("9696969696");
		
		
	}
	@Test(priority=9,groups= {"regression","Master"})
	void EnterFromEmailValue() {
		GiftCard gc=new GiftCard(driver);
		gc.Enterfrommail("lijhaMikelson@gmail.com");
		
		
	}
	@Test(priority=10,groups= {"regression","Master"})
	void addDenominationValue() {
		GiftCard gc=new GiftCard(driver);
		gc.addDenomination();
		
		
	}
	@AfterClass(groups={"sanity","Master"})
	void tearDown() {
		driver.quit();
	}
	
	
	
}
