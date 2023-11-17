package AlertPopup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert12 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("siddhesh");
     	driver.findElement(By.id("alertbtn")).click();
		
		Thread.sleep(3000);
		Alert alt= driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(alt.getText());
		alt.dismiss();
		
	
	}

}
