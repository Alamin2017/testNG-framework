package testNG_practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	@BeforeTest
	public void loginToApplication()
	{
		System.out.println("Login to Application ");
	}
	
	@AfterTest
	public void LogoutFromApplication()
	{
		System.out.println("Logout from Application ");
	}
	
	@BeforeMethod
	public void connectToDB()
	{
		System.out.println("DB Connected");
	}
	@AfterMethod
	public void disconnectFromDB()
	{
		System.out.println("DB DisConnected");
	}
	
	@Test(priority=1,description="This is a login test")
	public void aTest1()
	{
		System.out.println("test1");
	}
	
	@Test(priority=2,description="This is a logout test")
	public void atest2()
	{
		System.out.println("test2");
	}

}
