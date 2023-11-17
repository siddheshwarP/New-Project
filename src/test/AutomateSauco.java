package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateSauco {
	WebDriver driver;
	@BeforeTest
	public void setup() {
//		System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32/chromedriver.exe");
//	    driver = new ChromeDriver();
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chromeOptions);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate();
		
	}
	@Test(priority=0)
	public void countImage() {
		List <WebElement> ele = driver.findElements(By.tagName("img"));
		System.out.println("no. of images : "+ ele.size());
		int count = 0;
		for(WebElement images:ele) {
			if(images.isDisplayed()) {
				count++;
				System.out.println(images.getAttribute("alt"));
			}
		}
		System.out.println("No. of total displable images: "+count);
	}
	
	@Test(priority=-1)
	public void login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	@Test(priority=1)
	public void verifyPageTitle() {
		System.out.println(driver.getTitle());
		Assert.assertEquals("Swag Labs","Swag Labs");
	}
	@Test
	public void vrifyLogo() throws InterruptedException {
		if (driver.getTitle().equals("Swag Labs")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
	}
	}
	@Test(priority=2)
	public void selectDropdown() {
		WebElement e =driver.findElement(By.className("product_sort_container"));
		Select sc =new Select(e);
		sc.selectByIndex(2);
	}
	@Test(priority=3)
	public void selectProduct() {
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
	}
	@Test(priority=4)
	public void clickonCart() {
		driver.findElement(By.xpath("//div//a[@class='shopping_cart_link']")).click();
	}
	@Test(priority=5)
	public void checkout() {
		driver.findElement(By.id("checkout")).click();
	}
	@Test(priority=6)
	public void information() {
		driver.findElement(By.id("first-name")).sendKeys("Siddhesh");
		driver.findElement(By.id("last-name")).sendKeys("Patil");
		driver.findElement(By.id("postal-code")).sendKeys("42221");
		driver.findElement(By.id("continue")).click();
	}
	@Test(priority=7)
	public void validatePaymentInformation() {
         System.out.println(driver.findElement(By.className("summary_value_label")).getText());
		Assert.assertEquals("SauceCard #31337","SauceCard #31337");
		
	}
	@AfterTest
	public void finish() {
		driver.findElement(By.id("finish")).click();
		driver.close();
	}
}
