package testNG_practice;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DataProviderDemoTest_orangehrm {
	
	@Test(dataProvider="create")
	public void test1(String Username,String Password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).getText().contains("Welcome Sasanka"));
		System.out.println("Welcome page verified and Login is successful");
		driver.quit();
	}	
	@DataProvider(name="create")
	public Object[][] dataset()
	{
		return new Object[][] {
			{"Admin","admin123",},
			{"Admin","admin1234",},
			{"Admin","admin12367",},
	
			
		};
	}
	


}
