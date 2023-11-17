package datePicker;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32 (1)/chromedriver.exe");
       WebDriver driver= new ChromeDriver();
       driver.get("https://www.globalsqa.com/demo-site/datepicker/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       
       WebElement fr =driver.findElement(By.xpath("//*[@id=\"post-2661\"]/div[2]/div/div/div[1]/p/iframe"));
       driver.switchTo().frame(fr);
       driver.findElement(By.id("datepicker")).click();
       WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
       
       String month=driver.findElement(By.className("ui-datepicker-month")).getText();
       String year=driver.findElement(By.className("ui-datepicker-year")).getText();
       System.out.println(month+ year);
       Thread.sleep(3000);
       while(!(month.equals("June") && year.equals("2023"))) {
    	   driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();
    	   //month =driver.findElement(By.className("ui-datepicker-month")).getText();
          // year =driver.findElement(By.className("ui-datepicker-year")).getText();
           
       }
       driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();
	}
	 
	}


