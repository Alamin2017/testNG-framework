package daraz_test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Products extends base{
	
	@Test
	public void product_items() throws InterruptedException
	{
		
		driver.get("https://www.daraz.com.bd/");	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='q']")).sendKeys("camera"+Keys.ENTER);
		Thread.sleep(3000);
		String last_page=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[3]/div/ul/li[8]/a")).getText();
		int count_lastpage=Integer.parseInt(last_page);
		System.out.println("Last page count:"+count_lastpage);
		int pageresult,count=1;
		for (int num=1;num<=count_lastpage;num++)
		{
			Thread.sleep(3000);
			List<WebElement> itemlistperpage=driver.findElements(By.xpath("//div[@class='box--ujueT']/div"));
			pageresult=itemlistperpage.size();
			System.out.println("Items for page["+count+"]:"+pageresult);
			count++;
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4250)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//li[@title='Next Page']//a[@class='ant-pagination-item-link']")).click();
			Thread.sleep(3000);
			
		}
	
	
	}

}
