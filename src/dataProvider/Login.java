package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

	@Test(dataProvider="Login Data")
	public void login(String user,String pwd) {
		System.setProperty("webdriver.chrome.driver","D:/Java/chromedriver_win32/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
	}
	
@DataProvider(name="Login Data")
public Object[][] loginData() {
	Object [][]data= {{"standard_user","secret_sauce"},
			          {"performance_glitch_user","secretsauce"},
			          {"problem_user","secret_sauce"}
	                  };
	return data;
}
}
