package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	
	String propPath;
	
	public Properties gettingProperty() throws IOException{
		propPath=System.getProperty("user.dir")+"//src//main//java//resources//data.properties";
		FileInputStream fs= new FileInputStream(propPath);
		Properties p = new Properties();
		p.load(fs);
		return p;
	}
	
	public WebDriver initilise() throws IOException
	{
		String browserPath=System.getProperty("user.dir")+"//src//main//java//resources//chromedriver.exe";
		String browserName=gettingProperty().getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", browserPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", browserPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public boolean isAlertPresent()
	{
		boolean alert=true;
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		if(wait.until(ExpectedConditions.alertIsPresent())==null) {
			alert=false;
		}
		return alert;
	}

}
