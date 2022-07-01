package daraz_test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
public class base {
	
	//WebDriver driver;
	public static WebDriver driver;
	@BeforeMethod
	public void gotodaraz() throws InterruptedException 
	{
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterMethod 
	  public void tearDown() {
		driver.close();
	  }
	  
	  
}
