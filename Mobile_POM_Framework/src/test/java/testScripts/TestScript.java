package testScripts;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import methods.UtilityMethods;
import pageFactory.LoginLogoutPage;

public class TestScript {

	public void TS_Login_Logout()
	{
		AndroidDriver<AndroidElement> driver;
		UtilityMethods util=null;
		LoginLogoutPage login=null;
		String strStatus=null;
		try
		{
			 util=new UtilityMethods();
			 driver=util.LaunchApp("General-Store.apk", "Android Device");
			 Thread.sleep(3000);
			  
			 login=new LoginLogoutPage(driver);
			 
			 strStatus+=login.LoginToApp(driver, "kiran");
			 if(strStatus.contains("false"))
			 {
				 System.out.println("The testScript 'TS_Login_Logout()' failed ");
			 }else
			 {
				 System.out.println("The testScript 'TS_Login_Logout()' Passed ");
			 }
			 
			 
			 
			 
		}catch(Exception e)
		{
			System.out.println("Exception in 'TS_Login_Logout()' method "+e.getMessage());
		}
	}
	
}
