package practisePackage;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SampleProgram extends Basedemo {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement>driver=Capabilities();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']")).click();

	}

}
