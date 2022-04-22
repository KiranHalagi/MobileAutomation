package methods;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import driver.DriverScript;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class MobileGestures extends DriverScript {
	//tap
	//scroll
	//drag and drop
	//longPress 
	// swipe method need to write
	
	public boolean tapOnElement(AndroidDriver<AndroidElement>driver, By objBy, ExtentTest test)
	{
		WebElement oEle=null;
	   TouchAction t=null;
		try
		{
			t=new TouchAction(driver);
		  	oEle=driver.findElement(objBy);
		    t.tap(tapOptions().withElement(element(oEle))).perform();
	
		  	return true;
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'tapOnElemenet()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEle=null;
			t=null; 
		}
	}
	
	
	public boolean longPress(AndroidDriver<AndroidElement>driver, By objBy, ExtentTest test)
	{
		WebElement oEle=null;
		TouchAction t=null;
		try
		{
			t=new TouchAction(driver);
			oEle=driver.findElement(objBy);
			t.longPress(longPressOptions().withElement(element(oEle)).withDuration(Duration.ofSeconds(2))).release().perform();
			return true;
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'longPress()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEle=null;
			 t=null;
		}
	}
	
	public boolean scroll(AndroidDriver<AndroidElement>driver, String startPageId, String scrollEndPoint, ExtentTest test)
	{
		try                     
		{    
			Thread.sleep(3000);
			WebElement source=driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']"));
			source.click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+startPageId+"\"))"
					+ ".scrollIntoView(new UiSelector().textMatches(\""+scrollEndPoint+"\").instance(0))"));
			return true;
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'scroll()' method "+e.getMessage(),test);
			return false;
		}
		
	}
	
	public boolean dragAndDrop(AndroidDriver<AndroidElement>driver, By objBy, WebElement source,WebElement destination,ExtentTest test)
	{
		TouchAction t=null;
		try
		{
			 t=new TouchAction(driver);
			 source=(WebElement) driver.findElements(objBy);
			 destination=(WebElement) driver.findElements(objBy);
			 
			t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();	
			return true;
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'DragAndDrop()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			t=null;
		}
	}
	
	 public boolean ShortScrollMethod(AndroidDriver<AndroidElement>driver,String visibleText ,ExtentTest test)
	  {
		 try
		 {
			 WebElement source=driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']"));
				source.click();
			WebElement selectountry= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+visibleText+"\"))");
			selectountry.click();
			 return true;
		 }catch(Exception e)
		 {
			 reports.writeResult(driver,"exception","Exception in 'ShortScrollMethod()' "+e.getMessage(),test);
			 return false;
		 }
		  
	  }

}
