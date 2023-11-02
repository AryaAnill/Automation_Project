package testautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageautomation.pageauto;


public class testauto 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver= new ChromeDriver();
	}
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://www.easemytrip.com/railways/");
		driver.manage().window().maximize();
	}	
	@Test
	public void test() throws Exception
	{
		pageauto ob = new pageauto(driver);
				ob.set();
				ob.Search();
				ob.backhome();
				ob.close();
	}
}
