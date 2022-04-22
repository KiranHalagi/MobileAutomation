package realDeviceProgram;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static java.time.Duration.ofSeconds;

public class SwipeDemo {

	public static void main(String[] args) throws MalformedURLException {
		
		File f=new File("src");
		File fs=new File(f,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		                                                        
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
		
		//Actual Swiping
		
		//longpress//on element//1 sec //move to another element and release
		
		TouchAction t=new TouchAction(driver);
		WebElement first=driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement second=driver.findElement(By.xpath("//*[@content-desc='45']"));
		
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second))
		.release().perform();
		
		
		

	}

}
