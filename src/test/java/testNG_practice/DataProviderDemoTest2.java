package testNG_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DataProviderDemoTest2 {
	
	@Test(dataProvider="create")
	public void test1(String Username,String Password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
		driver.close();
	}	
	@DataProvider(name="create")
	public Object[][] dataset1()
	{
		return new Object[][] {
			{"standard_user","secret_sauce",},
			{"locked_out_user","secret_sauce",},
			{"problem_user","secret_sauce",},
			{"performance_glitch_user","secret_saucer",}
		};
	}
	


}
