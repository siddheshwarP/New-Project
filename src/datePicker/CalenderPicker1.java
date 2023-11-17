package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPicker1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Date of travel ")).click();
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("August")) {
			driver.findElement(By.xpath("//div/span[@class='flatpickr-next-month']")).click();
			
		}
		List<WebElement> ele= driver.findElements(By.xpath("//div[@class='dayContainer']"));
		int count=ele.size();
		
		for(int i=0;i<count;i++) {
			String text= driver.findElements(By.xpath("//div[@class='dayContainer']")).get(i).getText();
			
			if(text.equalsIgnoreCase("3")) {
				driver.findElements(By.xpath("//div[@class='dayContainer']")).get(i).click();
				break;
			}
		}
	}

}
