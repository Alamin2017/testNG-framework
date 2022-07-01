package cross_browser;
import org.testng.annotations.Test;
public class Products extends base{
	
	@Test
	public void product_items() throws InterruptedException
	{
		
		driver.get("https://learn-automation.com/");
		Thread.sleep(3000);	
	}

}
