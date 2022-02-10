package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class Alert extends Base{

	public WebDriver driver;
	
	@BeforeTest
	public void initiliseBrowser() throws IOException
	{
		driver = initilise();
		String url=gettingProperty().getProperty("Url");
		driver.get(url);
	}
	
	@Test
	public void alertValidation() throws InterruptedException
	{
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	      //alertIsPresent() condition applied
	      while(w.until(ExpectedConditions.alertIsPresent())!=null)
	      {
	    	  System.out.println("Present");
	    	  driver.switchTo().window(null);
	    	  
	      }
	      System.out.println("out");
	    
	   
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
