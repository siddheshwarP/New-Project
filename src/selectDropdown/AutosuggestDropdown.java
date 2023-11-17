package selectDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32 (1)/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> options= driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		//driver.findElements(By.xpath("//li[@class='ui-menu-item']/a[@id=ui-id-167"));
		Thread.sleep(2000);
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
	/*	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		List<WebElement> option1= driver.findElements(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']/a"));
		for(WebElement option2:option1) {
			if(option2.getText().equalsIgnoreCase("pune")) {
				option2.click();
				break;
			}
		}*/

	}

}
