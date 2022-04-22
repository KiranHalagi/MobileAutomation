package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import methods.UtilityMethods;

public class LoginLogoutPage {
	
	public LoginLogoutPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Locatos for LoginandLogoutPage
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Afghanistan']")
	public AndroidElement ClickOnDropDown;
	
	
	                       
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	public AndroidElement EnterYournameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	public AndroidElement selectGender;	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public AndroidElement letsShopButton;
	
	
	public boolean LoginToApp(AndroidDriver<AndroidElement>driver,String name)
	{
		try
		{
		
		    UtilityMethods util=new UtilityMethods();
			ClickOnDropDown.click();
			Thread.sleep(2000);
			util.ShortScrollMethod(driver, "Algeria");
			EnterYournameField.sendKeys(name);
			selectGender.click();
			letsShopButton.click();
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception in 'LoginToApp()' "+e.getMessage());
			return false;
		}

	}

}
