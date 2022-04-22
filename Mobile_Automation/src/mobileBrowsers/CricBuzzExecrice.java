package mobileBrowsers;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CricBuzzExecrice extends BaseChrome{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement>driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cricbuzz.com/");
		
		driver.findElement(By.xpath("//span[text()='Menu ']")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		String url=driver.getCurrentUrl();
		System.out.println("Url is : "+url);
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,480)", "");
		
		boolean ass=driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header");
        Assert.assertTrue(ass);
	}

}
