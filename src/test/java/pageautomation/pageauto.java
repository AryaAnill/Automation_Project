package pageautomation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class pageauto {
	WebDriver driver;
	By From =  By.xpath("//*[@id=\"txtfromcity\"]");
	By Del = By.xpath("//*[@id=\"RctSr\"]/div/div/div[3]/div/div/div/div[1]");
	By To = By.xpath("//*[@id=\"txtdesticity\"]");
	By Sec = By.xpath("//*[@id=\"RctDest\"]/div/div/div[5]/div/div/div/div[1]");
	By Date = By.xpath("//input[@id='txtDate']");
	By Search = By.xpath("//*[@id=\"TrainBySearch\"]/div[4]/input");
	
	public pageauto(WebDriver driver)
	{
	this.driver = driver;	
	}
	public void set() throws Exception
	{
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(From).click();
		driver.findElement(Del).click();
		driver.findElement(To).click();
		driver.findElement(Sec).click();
		driver.findElement(Date).click();
		//driver.findElement(Search).click();
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("E:\\easytrain.png"));
		
		while(true)
		{
			WebElement month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]"));
			String month1 = month.getText();
			if(month1.equals("November"))
			{
				System.out.println(month);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			
			List <WebElement> alldates1 = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td/a"));
			
			for(WebElement dateelement:alldates1)
			{
				String date = dateelement.getText();
				if(date.equals("29"))
				{
					dateelement.click();
					break;
				}
			}
			
			
		}
		
	}
	public void Search()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(Search).click();
	}

	public void backhome()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().back();
	}
	public void close()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.close();
	}
}
