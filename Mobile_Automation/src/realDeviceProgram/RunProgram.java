package realDeviceProgram;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RunProgram extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver=Capabilities();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
	    driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
	    driver.findElementById("android:id/checkbox").click();
	    driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
	    driver.findElementById("android:id/edit").sendKeys("kiran");
	    driver.findElementById("android:id/button1").click();
		
		

	}

}
