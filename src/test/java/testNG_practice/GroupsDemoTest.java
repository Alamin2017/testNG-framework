package testNG_practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

@Test(groups="user-registration")
public class GroupsDemoTest {

	@BeforeClass
	public void beforeClass() {

		System.out.println("Run this before class");

	}
	@AfterClass 
	public void afterClass() {

		System.out.println("Run this After class");

	}
	@BeforeGroups(value="regression")
	public void beforeGroup() {

		System.out.println("Run this method before regression ");

	}
	@AfterGroups(value="regression")
	public void afterGroup() {

		System.out.println("Run this method after regression");

	}
	

	@Test(priority=1,groups="regression")
	public void Test1() {
		System.out.println("Test1");
	}
	@Test(priority=2,groups="regression")
	public void Test2() {
		System.out.println("Test2");
	}
	@Test(groups={"regression","bvt"})
	public void Test3() {
		System.out.println("Test3");
	}
	@Test(groups="bvt")
	public void Test4() {
		System.out.println("Test4");
	}

}
