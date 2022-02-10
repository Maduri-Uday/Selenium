package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class MultipleWindows extends Base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void initiliseBrowser() throws IOException
	{
		driver = initilise();
		String url=gettingProperty().getProperty("Url");
		driver.get(url);
	}
	
	@Test
	public void windowHandling()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,2000)");
		//WebElement lDriver=driver.findElement(By.id("gf-BIG"));
		WebElement ldriver=	driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		List<WebElement> list=  ldriver.findElements(By.tagName("a"));
		for(int i=0;i<list.size();i++)
		{
			//System.out.println( list.get(i).getText());
			list.get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
		}
		
		Set<String> handles=driver.getWindowHandles();
	
		Iterator<String> it= handles.iterator();
		while(it.hasNext())
		{
			String title= driver.switchTo().window(it.next()).getTitle();
			if(title.contains("REST")) {
				driver.findElement(By.linkText("What Is REST?")).click();
				break;
			}
		}
		System.out.println(driver.getTitle());
		
		
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
	

}
