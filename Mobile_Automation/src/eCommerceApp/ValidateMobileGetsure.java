package eCommerceApp;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ValidateMobileGetsure extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
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
		

	}

}
