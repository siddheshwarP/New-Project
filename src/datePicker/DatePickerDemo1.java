package datePicker;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[4]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='Div1']/button")).click();
	
	//WebDriverWait wait=new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//div//table//tbody//tr[5]//td[7]//a[@class='ui-state-default']")).click();	
		
	}

}
