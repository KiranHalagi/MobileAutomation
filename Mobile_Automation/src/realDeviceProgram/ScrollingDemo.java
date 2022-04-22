package realDeviceProgram;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollingDemo extends Base {
	
	static AndroidDriver<AndroidElement>driver=null;
	
	public static void main(String[] args) throws MalformedURLException {
		
		driver=Capabilities();
		ClickOnView();
		//scrollAndClick("WebView3");
		ShortScrollMethod("WebView3");
		
	
		
	}
	
	public static void ClickOnView()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
	}
	
	public static void scrollAndClick(String visibleText) {
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	        }
	    
	  public static void ShortScrollMethod(String visibleText)
	  {
		  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+visibleText+"\"))");
	  }

	 

}
