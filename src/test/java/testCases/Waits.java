package testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public WebDriver driver;
	
	public void waits()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
	//	wait.until(ExpectedConditions.)
		
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
