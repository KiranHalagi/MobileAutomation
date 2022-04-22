package eCommerceApp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyTotalAmount extends Base{

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
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		 double count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		 
		 double sum=0;
		for(int i=0; i<count ;i++)
		{
			String product1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			double product=getAmount(product1);
			sum=sum+product;
		}
		
//		String product1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
//		product1=product1.substring(1);
//		double FirstproducPrice=Double.parseDouble(product1);
//		
//		String product2=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
//		product2=product2.substring(1);
//		double SecondProductPrice=Double.parseDouble(product2);
		
//		double totalSum=FirstproducPrice+SecondProductPrice;
		
		System.out.println("Grabbed Total Sum : "+sum);
		
		String totalPurchaseAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		double FinalAmount=getAmount(totalPurchaseAmount);
		
//		totalPurchaseAmount=totalPurchaseAmount.substring(1);
//		
//		Double FinalAmount=Double.parseDouble(totalPurchaseAmount);
		
		System.out.println("Final Amount is : "+FinalAmount);
		
		Assert.assertEquals(FinalAmount, sum);
		

	}
	
	public static double getAmount(String value)
	{
		value=value.substring(1);
		double producPrice=Double.parseDouble(value);
		return producPrice;
		
	}

}
