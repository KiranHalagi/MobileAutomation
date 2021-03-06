package embibeApp;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.AndroidElement;

public class EmbibeAllTestCases  extends LoginFunctionality  {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement>driver=Capabilities();
		
		//Check weather "Trusted By @
		//" Text is present or not"
		
		String ActualText="TRUSTED BY 200+ MILLION STUDENTS";
		String trustedText=driver.findElement(By.xpath("//android.widget.TextView[@text='TRUSTED BY 200+ MILLION STUDENTS']")).getText();
		
		if(ActualText.equals(trustedText))
		{
			System.out.println(ActualText+" text is present on the dom");
		}else
		{
			System.out.println(ActualText+" text is not present on the dom");
		}
		
		Assert.assertEquals(ActualText, trustedText);
		
		//Check weather terms and condition taking to next page upon clicking
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Terms and Conditions']")).click();
		
		//key events
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		
		//check weather signUp text is present or not
		String ActualText2="By signing up, you agree to our";
		String expected2=driver.findElement(By.xpath("//android.widget.TextView[@text='By signing up, you agree to our']")).getText();
		
		if(ActualText2.equals(expected2))
		{
			System.out.println(expected2+" text is present on the dom");
		}else
		{
			System.out.println(expected2+" text is not present on the dom");
		}

		//Click on start Learning Button
		Thread.sleep(2000);
	boolean enabled=	driver.findElement(By.xpath("//android.widget.TextView[@text='Start Learning']")).isEnabled();
	   if(enabled==true)
	   {
		   System.out.println("Button is enabled");
	   }else
	   {
		   System.out.println("Button is disabled");
	   }
		driver.findElement(By.xpath("//android.widget.TextView[@text='Start Learning']")).click();
		
		Thread.sleep(2000);
	  driver.findElement(By.id("com.embibe.student:id/et_mobile_no_email")).click();
	  
	  //Check Whether logging is displying or not
	boolean logging=  driver.findElement(By.id("android:id/autofill_dataset_list")).isDisplayed();
	if(logging==true)
	{
		System.out.println("Logging window disaplyed successfully");
	}else
	{
		System.out.println("Failed to dispaly the logging window");
	}
	
	//select window on logging window
	driver.findElement(By.id("android:id/text1")).click();
	
	//sign in using paaword
	driver.findElement(By.id("com.embibe.student:id/tv_sign_in_using_password")).click();
	
	//Login
	driver.findElement(By.id("com.embibe.student:id/etEmailID")).click();
	
	driver.findElement(By.id("android:id/content")).click();
	
	driver.findElement(By.id("com.embibe.student:id/tvSignIn")).click();
		
		
		
		
	}

}
