package taskLists;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
public class TestLandingPage extends Base {
	
	@Test(priority=1)
	public void testSearchBoxExists() throws InterruptedException
	{
		
		
		Boolean isExists=driver.findElement(By.xpath("//input[@id='q']")).isDisplayed();
		System.out.println("Actual for search box: "+isExists);
		Boolean expected=true;
		Assert.assertEquals(expected,isExists);

	}
	
	@Test(priority=2)
	public void testAddToCartOptionExists() 
	{
	
		boolean isdisplayed=driver.findElement(By.xpath("//span[@class='cart-icon']//*[name()='svg']")).isDisplayed();
		System.out.println("Actual for add to cart box: "+isdisplayed);
		boolean expected=true;
		Assert.assertEquals(isdisplayed, expected);
		
	}
	
	@Test(priority=3)
	public void testAddToCartOptionActive() 
	{
		
		
		boolean isEnabled=driver.findElement(By.xpath("//span[@class='cart-icon']//*[name()='svg']")).isEnabled();
		System.out.println("Actual for add to cart: "+isEnabled);
		boolean expected=true;
		Assert.assertEquals(isEnabled, expected);
	
		
	}
}
