package chaldal_test;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class test_case extends base{

	@Test(priority=1,description="test logo image visiblility check ")
	public void test_logo_image() throws InterruptedException
	{
		boolean image=driver.findElement(By.xpath("//*[@id='page']/div/div[3]/div/div[1]/div[1]/div[1]/a/img")).isDisplayed();
		Thread.sleep(3000);
		System.out.println("Image is Exist:"+image);
	}
	@Test(priority=2)
	public void test_sign_in_out_using_number() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page']/div/div[1]/div/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("01629674872");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/button[1]")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id='page']/div/div[1]/div/div/div/div[2]/div/form/div[3]/button[1]")).click();	
		Thread.sleep(3000);

		WebElement info_bar=driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/div[5]"));
		Actions act=new Actions(driver);
		act.moveToElement(info_bar).click().build().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='isLoggedIn top-header']//li[6]")).click();
		Thread.sleep(4000);
	}
	@Test(priority=3)
	public void test_help_menu() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='page']/div/div[3]/div/div[1]/div[1]/div[3]/a/span")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void test_popular_product_count_shows_products() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Popular')]")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(10000);
		
		List<WebElement> products=driver.findElements(By.xpath("//*[@class='productPane']/div"));
		System.out.println("Popular Product size:"+products.size());

		for (int i=0;i<products.size();i++)
		{
			//System.out.println(""+products.get(i).getText());
			System.out.println(""+products.get(i).getText());
			System.out.println("");
		}
		Thread.sleep(3000);
	}
	@Test(priority=5)
	public void test_change_language() throws InterruptedException
	{
		driver.findElement(By.xpath("//p[contains(text(),'বাং')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[contains(text(),'EN')]")).click();
		Thread.sleep(4000);
		 Set<Cookie> cookies=driver.manage().getCookies();
		 System.out.println("Size of Cookies:"+cookies.size());
	}
	@Test(priority=6)
	public void test_Terms_of_Service() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[2]/div/div[4]/h5/a[2]")).click();
		Thread.sleep(4000);
		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(4000);
	}
	@Test(priority=7)
	public void test_Privacy_Policy() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Privacy Policy")).click();
		Thread.sleep(4000);
		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(4000);

	}
	@Test(priority=8)
	public void test_product_details_add_to_cart_without_login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='search_term_string']")).sendKeys("potato"+Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='page']/div/div[5]/section/div/div/div/div/section/div[2]/div[2]/div[1]/div/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/section/div/div/div/div/section/div[2]/div[2]/div[1]/div/div[1]/div[5]/span/a[1]/span[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='buyNowButton']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='placeOrderButton']/span[1]")).click();
		Thread.sleep(4000);
	}
	@Test(priority=9)
	public void test_current_location_live_chat() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='metropolitanAreaName']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='citySelectionLink hidden-xs']//div[@class='headerAddressComponent visible']//div//p[contains(text(),'Use my current Location')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Live Chat')]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@class='chatWindowCloseBtn border-radius-small']")).click();
		Thread.sleep(4000);
	}
	@Test(priority=10)
	public void test_product_categories_total() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		List<WebElement> product_categories=driver.findElements(By.xpath("//*[@id=\"product-categories\"]/div[2]/a"));
		System.out.println("Total Product categories:"+product_categories.size());
	
		for (int i=0;i<product_categories.size();i++)
		{
			
			System.out.println("Item number["+(i+1)+"]:->"+product_categories.get(i).getText());
			
		}

	}
	
	@Test(priority=11)
	public void test_product_pharmacy_total() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[3]/div/div[2]/div/div/div[2]/div/div/div[2]/h5")).click();
		Thread.sleep(2000);
		List<WebElement> product_categories=driver.findElements(By.xpath("//*[@id=\"page\"]/div/div[5]/section/div/div/div/div/section/div[2]/div/a"));
		System.out.println("Total Pharmacy Product categories:"+product_categories.size());
	
		for (int i=0;i<product_categories.size();i++)
		{
			
			System.out.println("Item number["+(i+1)+"]:->"+product_categories.get(i).getText());
			
		}

	}

}
