package practisePackage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;


import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.*;

import static java.time.Duration.ofSeconds;

public class TouchactionsDemo {

	public static void main(String[] args) throws MalformedURLException {
	
		File f=new File("src");
		File fs=new File(f,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		AndroidDriver<AndroidElement>driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
		WebElement expa=driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		TouchAction t=new TouchAction<>(driver);
		t.tap(tapOptions().withElement(element(expa))).perform();
		
     	t.tap(tapOptions().withElement(element(driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")")))).perform();
//		
         WebElement longpress=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
     	
     	t.longPress(longPressOptions().withElement(element(longpress)).withDuration(ofSeconds(2))).release().perform();
     	
     	System.out.println(driver.findElementById("android:id/title").isDisplayed());
     	
     	//Tap on x,y co-ordinates
     	
     	t.tap(PointOption.point(109, 443)).perform();
		
		t.tap(PointOption.point(188, 572)).waitAction(waitOptions(Duration.ofMillis(10))).perform();
		
		
		
		
	}

}
