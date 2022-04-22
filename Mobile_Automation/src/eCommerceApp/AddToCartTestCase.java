package eCommerceApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddToCartTestCase extends Base{

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
		
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))"
				+ ".scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<count; i++)
		{
			String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(text.equals("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
			
		}
		
		//Verify successfully added or not
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String actualText=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		Assert.assertEquals(actualText, "Jordan 6 Rings");
		System.out.println(actualText +"SuccessFully added to Cart");
	}

}
