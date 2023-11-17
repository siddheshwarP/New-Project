package selectDropdown;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/Java/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(1000, null);

		driver.findElement(By.id("autosuggest")).sendKeys("India");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BOM']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='PNQ']"))
				.click();
		// Date picker
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='Div1']/button")).click();

		// WebDriverWait wait=new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//div//table//tbody//tr[5]//td[7]//a[@class='ui-state-default']")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=1;i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		//select currency
		
		WebElement ele=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sc=new Select(ele);
		sc.selectByIndex(2);
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
