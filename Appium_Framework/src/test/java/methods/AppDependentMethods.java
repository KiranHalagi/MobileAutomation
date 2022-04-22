package methods;

import com.relevantcodes.extentreports.ExtentTest;

import driver.DriverScript;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import locators.ObjectLocators;

public class AppDependentMethods extends DriverScript implements ObjectLocators {
	
	/*******************************************************
	 * Method Name	`	: loginToApplication()
	 * Purpose			: to login to the application
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, String UN, String PWD
	 * Return Type		: boolean
	 ********************************************************/
	public boolean LoginToApp(AndroidDriver<AndroidElement>driver, String name, ExtentTest test)
	{
		String strStatus=null;
		try
		{
		  strStatus+=gestures.ShortScrollMethod(driver, appInd.readConfigData("countryName"), test);
		  strStatus+=appInd.setObject(driver, username, name,test);
		  strStatus+=appInd.clickObject(driver, objGender, test);
		  strStatus+=appInd.clickObjectById(driver, letsShopButton, test);
		  
		  if(strStatus.contains("false"))
		  {
			  reports.writeResult(driver,"fail","Failed to login to the 'General-Stroe.apk' Application",test);
			  return false;
		  }
		  else
		  {
			  reports.writeResult(driver,"screenshot","Login is successfuly for 'General-Stroe.apk' Application",test);
			  return true;
		  }
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'LoginToApp()' method "+e.getMessage(),test);
			return false;
		}
	}

}
