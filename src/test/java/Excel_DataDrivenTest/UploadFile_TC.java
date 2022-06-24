package Excel_DataDrivenTest;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile_TC {

	@Test
	public void Upload_file() throws InterruptedException, AWTException
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://resume.naukri.com/resume-quality-score");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@class='browse']")).click();
		
		Robot robot=new Robot();
		
		StringSelection filepath=new StringSelection("C:\\Users\\User\\Downloads\\Towfiqur_02_Python.pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(10000);
		
		System.out.println("File upload is done:");
		
	}
}



