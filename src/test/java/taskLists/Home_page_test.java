package taskLists;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Home_page_test extends Base{
	
	@Test(priority=1)
	public void testSearchBoxExists() throws InterruptedException
	{
	
		Boolean isExists=driver.findElement(By.xpath("//input[@id='q']")).isDisplayed();
		System.out.println("Actual output for search box: "+isExists);
		Boolean expected=true;
		Assert.assertEquals(expected,isExists);
	}
	@Test(priority=2)
	public void testCartOptionExists() 
	{
		
		boolean isdisplayed=driver.findElement(By.xpath("//span[@class='cart-icon']//*[name()='svg']")).isDisplayed();
		System.out.println("Actual output for cart option: "+isdisplayed);
		boolean expected=true;
		Assert.assertEquals(isdisplayed, expected);	
	}
	@Test(priority=3) 
	public void testTotalCategoryTypes()
	{
		
		List<WebElement>totalcategory=driver.findElements(By.xpath("//div[@class='card-categories-li hp-mod-card-hover align-left']"));
		int total=totalcategory.size();
		System.out.println("Total Catgory list__:"+total);
		Assert.assertEquals(total,16);
	}
	
	@Test (priority=4)
	public void testCategoryNames() throws InterruptedException
	{
	
		List<WebElement>totalcategoryList=driver.findElements(By.xpath("//div[@class='card-categories-ul']/div[@class='card-categories-li hp-mod-card-hover align-left']"));
		int total=totalcategoryList.size();
		System.out.println("Total Catgory list:"+total);
		int index=1;
		for(WebElement category : totalcategoryList)
		{
			String Categoryname = category.findElement(By.xpath(".//div[@class='card-categories-name']/span")).getText();
			
			System.out.println("Category Name["+index+"]:"+Categoryname);
		
			index++;
		}
	}
	@Test(priority=5)
	public void PaymentMethods()
	{
		
		List<WebElement>totalPaymentList=driver.findElements(By.xpath("//*[@class='drz-footer-width-25 payment-column']/span"));
		int total=totalPaymentList.size();
		System.out.println("Total Payment Methods are:"+total);
		Assert.assertEquals(total, 5);
	}

}
