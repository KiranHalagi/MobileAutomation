package contextSwitching;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import eCommerceApp.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ContextSwitchingDemo extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement>driver=Capabilities();
		

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement source=driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']"));
		source.click();
		
		WebElement clickOnIndia= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"))");
		clickOnIndia.click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("kk");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Add to cart
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//Click on add to cart button
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		// tap getsure
		TouchAction t=new TouchAction(driver);
		WebElement sendCheckBox=driver.findElement(By.className("android.widget.CheckBox"));
		t.tap(tapOptions().withElement(element(sendCheckBox))).perform();
		
		//longPress option
		WebElement longPressOnread=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(longPressOptions().withElement(element(longPressOnread)).withDuration(Duration.ofSeconds(2))).perform();
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(7000);
		Set<String>contextNames=driver.getContextHandles();
		
		for(String contextName:contextNames)
		{
			System.out.println(contextName);
		}
		
		Thread.sleep(7000);
		driver.context("WEBVIEW_chrome");
		Thread.sleep(7000);
		
		 driver.findElement(By.xpath("//input[@name='q']")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
		//Andoid Back Switch to native app
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
		
		
	}
}
