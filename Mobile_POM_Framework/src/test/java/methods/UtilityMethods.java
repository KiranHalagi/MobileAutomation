package methods;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class UtilityMethods {

	public AndroidDriver<AndroidElement> LaunchApp(String appName, String deviceName)
	{
		AndroidDriver<AndroidElement> driver=null;
		File f=null;
		//File fs=null;
		try
		{
			
			 f=new File(System.getProperty("user.dir")+"//"+appName);
			// fs=new File(f, appName);
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator-2");
			cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			
			driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return driver;
		}catch(Exception e)
		{
			System.out.println("Failed to launch the 'LaunchApp()' method "+e.getMessage());
			return null;
		}
		finally
		{
			driver=null;
			
		}
		
		
	}
	
	 public boolean ShortScrollMethod(AndroidDriver<AndroidElement>driver,String visibleText)
	  {
		 try
		 {
			
			WebElement selectountry= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+visibleText+"\"))");
			selectountry.click();
			 return true;
		 }catch(Exception e)
		 {
			 System.out.println("Exception in 'ShortScrollMethod()' "+e.getMessage());
			 return false;
		 }
		  
	  }

}
