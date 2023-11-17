package selectDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		WebElement element= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select sc= new Select(element);
		sc.selectByIndex(1);
		System.out.println(sc.getFirstSelectedOption().getText());
	    Thread.sleep(3000);
	    sc.selectByValue("AED");
	    System.out.println(sc.getFirstSelectedOption().getText());
	     sc.selectByVisibleText("USD");
	     System.out.println(sc.getFirstSelectedOption().getText());
	     
	}

}
