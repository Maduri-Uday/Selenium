package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsAlertPresent {
	
	
	
	public boolean isAlertPresent(WebDriver driver)
	{
		boolean alert=true;
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		if(wait.until(ExpectedConditions.alertIsPresent())!=null);
		else
			alert=false;
		return alert;
	}

}
