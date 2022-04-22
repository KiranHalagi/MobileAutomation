package testScripts;

import driver.DriverScript;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import methods.StartServer;


public class TestScript extends DriverScript{
	
	public boolean TS_LoginLogout()
	{
		AndroidDriver<AndroidElement>driver=null;
		String strStaus=null;
		
		try
		{
			 
			test = extent.startTest("TS_LoginLogout");
			services.startServer();
		   	driver=appInd.LaunchApp(appInd.readConfigData("AppName"), "Android Device", test);
		   	 strStaus+=appDep.LoginToApp(driver, "kiran", test);
		   	if(strStaus.contains("false"))
		   	{
		   		reports.writeResult(driver,"fail","Test script 'TS_LoginLogout()' Failed",test);
				return false;
			}else {
				reports.writeResult(driver,"pass","Test script 'TS_LoginLogout()' Passed",test);
				return true;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in TS_LoginLogout() method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			StartServer.stopServer();
			reports.endExtentReport(test);
			driver=null;
			strStaus=null;
			
		}
		
	}

}
