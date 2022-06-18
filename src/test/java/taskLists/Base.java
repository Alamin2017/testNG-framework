package taskLists;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void driverSetUp() throws InterruptedException
	{
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.daraz.com.bd/");
		Thread.sleep(2000);
	}
	
	@AfterMethod 
	  public void tearDown() {
		driver.close();
	  }
	

    
}
