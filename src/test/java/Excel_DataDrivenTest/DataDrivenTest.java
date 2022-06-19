package Excel_DataDrivenTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	
	public static WebDriver driver;
	@BeforeMethod
	public void goto_nopcom_website() throws InterruptedException
	{
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://admin-demo.nopcommerce.com/");
		Thread.sleep(2000);
		
	}

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp) throws InterruptedException
	{
		
		WebElement txtEmail=driver.findElement(By.xpath("//input[@id='Email']"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
		Thread.sleep(2000);
		WebElement txtPass=driver.findElement(By.xpath("//input[@id='Password']"));
		txtPass.clear();
		txtPass.sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		Thread.sleep(5000);
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		if(exp.equals("valid"))
		{
			if(exp_title.equals(act_title))
			{
				System.out.println("Login is done for Valid Data.");
				Assert.assertTrue(true);
				
			}
		}
		else if(exp.equals("invalid"))
		{
			System.out.println("Need to valid data for Login");
		}
		
		//driver.close();
	}
	@DataProvider(name="LoginData")
	public String[][] getData()
	{
		String loginData[][]= {
				{"admin@yourstore.com","admin","valid"},
				{"admin@yourstore.com","adm","invalid"},
				{"adm@yourstore.com","admin","invalid"},
				{"adm@yourstore.com","adm","invalid"}
		};
		return loginData;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}


}
