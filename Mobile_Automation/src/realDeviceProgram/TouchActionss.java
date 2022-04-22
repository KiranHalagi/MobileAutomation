package realDeviceProgram;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TouchActionss extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		AndroidDriver<AndroidElement>driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//text(\"Views\")
		//tap
		
		TouchAction t=new TouchAction(driver);
	    WebElement expandList=	driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		
		t.tap(tapOptions().withElement(element(expandList))).perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		Thread.sleep(3000);
		
		WebElement pn=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		
		t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		
		//driver.findelementbya
		
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
		
		
		
		
		//driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
		//driver.findElementByXPath("\\android.widget.TextView[@text='1. Custom Adapter']")

	}

}
