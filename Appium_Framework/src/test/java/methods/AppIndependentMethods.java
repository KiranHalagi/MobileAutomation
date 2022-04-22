package methods;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import driver.DriverScript;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppIndependentMethods extends DriverScript{
	
	/*******************************************
	 * Method Name : readConfigData()
	 * Purpose	   : Read Data from properties file
	 * Author      :
	 * Reviewer    :
	 * *****************************************
	 */
	
	public String readConfigData(String strKey)
	{
		FileInputStream fin=null;
		Properties prop=null;
		try
		{
			fin=new FileInputStream(System.getProperty("user.dir")+"\\configuration\\Config.properties");
			 prop=new Properties();
			 prop.load(fin);
			 return prop.getProperty(strKey);
		}catch(Exception e)
		{
			System.out.println("Exception in 'getData()' Method "+e.getMessage()); 
			return null;
		}finally
		{
			try {
				fin.close();
				fin=null;
				prop=null;
			}catch(Exception e)
			{
				System.out.println("Exception in 'getData()' Method "+e.getMessage());
				return null;
			}
		}
	}
	
	
	
	/*******************************************
	 * Method Name : LaunchApplication
	 * Purpose	   :
	 * Author      :
	 * Reviewer    :
	 * *****************************************
	 */
	
	
	public AndroidDriver<AndroidElement> LaunchApp(String appName, String deviceName,ExtentTest test)
	{
		AndroidDriver<AndroidElement> driver=null;
		File f=null;
		//File fs=null;
		try
		{
			
			 f=new File(System.getProperty("user.dir")+"//"+appName);
			// fs=new File(f, appName);
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator-2");
			cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			
			driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return driver;
		}catch(Exception e)
		{
			reports.writeResult(driver, "exception", "Failed to launch the 'LaunchApp()' method "+e.getMessage(), test);
			return null;
		}
		finally
		{
			driver=null;
			
		}
		
		
	}
	
	/*******************************************************
	 * MethodName	`	: clickObject()
	 * Purpose 			: to click on the web element
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public  boolean clickObject(AndroidDriver<AndroidElement> driver, By objBy,ExtentTest test)
	{
		List<AndroidElement> oEles = null;
		try
		{
			oEles=driver.findElements(objBy);
			if(oEles.size()>0)
			{
				oEles.get(0).click();
				reports.writeResult(driver, "pass", "The element "+String.valueOf(objBy)+" was Clicked successfully", test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The Element "+String.valueOf(objBy)+" was not found in the DOM",test);
				return false;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in  'clickObject()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	
	/*******************************************************
	 * MethodName	`	: clickObject()
	 * Purpose 			: to click on the web element
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public  boolean clickObject(AndroidDriver<AndroidElement> driver, String objBy,ExtentTest test)
	{
		List<AndroidElement> oEles = null;
		try
		{
			oEles=driver.findElements(By.xpath(objBy));
			if(oEles.size()>0)
			{
				oEles.get(0).click();
				reports.writeResult(driver,"pass","The element "+String.valueOf(objBy)+" was Clicked successfully",test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The Element "+String.valueOf(objBy)+" was not found in the DOM",test);
				return false;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in  'clickObject()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}

	public  boolean clickObjectById(AndroidDriver<AndroidElement> driver, String objById,ExtentTest test)
	{
		List<AndroidElement> oEles = null;
		try
		{
			oEles=driver.findElements(By.id(objById));
			if(oEles.size()>0)
			{
				oEles.get(0).click();
				reports.writeResult(driver,"pass","The element "+String.valueOf(objById)+" was Clicked successfully",test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The Element "+String.valueOf(objById)+" was not found in the DOM",test);
				return false;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in  'clickObject()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}

	/*******************************************************
	 * Method Name	`	: setObject()
	 * Purpose			: to enter the values on the web element
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean setObject(AndroidDriver<AndroidElement> driver, By objBy,String strData,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
			oEles=driver.findElements(objBy);
			if(oEles.size()>0)
			{
				oEles.get(0).sendKeys(strData);
				reports.writeResult(driver,"pass","The data '"+strData+"' was entered in the element '"+String.valueOf(objBy)+"' successful", test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The '"+String.valueOf(objBy)+"' was not found on the DOM",test);
				return false;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'setObject()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEles=null;
		}
	}
	
	
	/*******************************************************
	 * Method Name	`	: setObject()
	 * Purpose			: to enter the values on the web element
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean setObject(AndroidDriver<AndroidElement> driver, String objBy,String strData,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
			oEles=driver.findElements(By.xpath(objBy));
			if(oEles.size()>0)
			{
				oEles.get(0).sendKeys(strData);
				reports.writeResult(driver,"pass","The data '"+strData+"' was entered in the element '"+String.valueOf(objBy)+"' successful",test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The '"+String.valueOf(objBy)+"' was not found on the DOM",test);
				return false;
			}
			
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'setObject()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEles=null;
		}
	}
	
	

	/*******************************************************
	 * Method Name	`	: clearAndSetObject()
	 * Purpose			: to enter the value on the web element
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy, String strData
	 * Return Type		: boolean
	 ********************************************************/
	public boolean clearAndSetObject(AndroidDriver<AndroidElement>driver, By objBy, String strData,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
			oEles=driver.findElements(objBy);
			if(oEles.size()>0)
			{
				oEles.get(0).clear();
				oEles.get(0).sendKeys(strData);
				reports.writeResult(driver,"pass","The data '"+strData+"' was entered in the element '"+String.valueOf(objBy)+"'successful",test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The '"+String.valueOf(objBy)+"' was not found on the DOM",test);
				return false;
			}
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'clearAndSetObject()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	/*******************************************************
	 * Method Name	`	: clearAndSetObject()
	 * Purpose			: to enter the value on the web element
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy, String strData
	 * Return Type		: boolean
	 ********************************************************/
	public boolean clearAndSetObject(AndroidDriver<AndroidElement>driver, String objBy, String strData,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
			oEles=driver.findElements(By.xpath(objBy));
			if(oEles.size()>0)
			{
				oEles.get(0).clear();
				oEles.get(0).sendKeys(strData);
				reports.writeResult(driver,"pass","The data '"+strData+"' was entered in the element '"+String.valueOf(objBy)+"'successful",test);
				return true;
			}else
			{
				reports.writeResult(driver,"fail","The '"+String.valueOf(objBy)+"' was not found on the DOM",test);
				return false;
			}
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'clearAndSetObject()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	/*******************************************************
	 * Method Name	`	: compareValue()
	 * Purpose			: to compare the both actual and expected values
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: String actual, String expected
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean compareValue(String actual, String expected,ExtentTest test)
	{
		try
		{
			if(actual.equalsIgnoreCase(expected))
			{
				reports.writeResult(null,"pass","The actual '"+actual+"' and expected '"+expected+"' values are Matching",test);
				return true;
			}else
			{
				reports.writeResult(null,"fail","The actual '"+actual+"' and expected '"+expected+"' values are not Matching",test);
				return false;
			}
		}catch(Exception e)
		{
			reports.writeResult(null,"exception","Exception in 'compareValue()' method "+e.getMessage(),test);
			return false;
		}
	}
	
   
	/*******************************************************
	 * Method Name	`	: verifyText()
	 * Purpose			: to validate the text present on the element with expected values
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy, String objectType, String expected
	 * Return Type		: boolean
	 ********************************************************/
	public boolean verifyText(AndroidDriver<AndroidElement> driver, String objBy, String objtype, String expected,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		Select oSel=null;
		String actual=null;
		
		try
		{
		  oEles=driver.findElements(By.xpath(objBy));
		  if(oEles.size()>0)
		  {
			  switch(objtype.toLowerCase())
			  {
			    case  "text":
			    	  actual=oEles.get(0).getText();
			    	  break;
			    	  
			    case  "value":
			    	actual=oEles.get(0).getAttribute("value");
			    	break;
			    	
			    case "dropdown":
			    	oSel=new Select(oEles.get(0));
			    	actual=oSel.getFirstSelectedOption().getText();
			    	break;
			    	
			    	default:
			    		reports.writeResult(driver,"warning","Invalid object type '"+objtype+"' was specified",test);
			    		return false;
			    	
			  }
			  if(appInd.compareValue(actual, expected, test))
			  {
				  return true;
			  }
			  else
			  {
				  return false;
			  }
		  }
		  else
		  {
			  reports.writeResult(driver,"fail","The element '"+String.valueOf(objBy)+"' was not found in the DOM.",test);
				return false;
		  }
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in executing 'VerifyText()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEles=null;
			oSel=null;
			actual=null;
		}
		
	}
	
	/*******************************************************
	 * Method Name	`	: verifyText()
	 * Purpose			: to validate the text present on the element with expected values
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy, String objectType, String expected
	 * Return Type		: boolean
	 ********************************************************/
	public boolean verifyText(AndroidDriver<AndroidElement> driver, By objBy, String objtype, String expected, ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		Select oSel=null;
		String actual=null;
		
		try
		{
		  oEles=driver.findElements(objBy);
		  if(oEles.size()>0)
		  {
			  switch(objtype.toLowerCase())
			  {
			    case  "text":
			    	  actual=oEles.get(0).getText();
			    	  break;
			    	  
			    case  "value":
			    	actual=oEles.get(0).getAttribute("value");
			    	break;
			    	
			    case "dropdown":
			    	oSel=new Select(oEles.get(0));
			    	actual=oSel.getFirstSelectedOption().getText();
			    	break;
			    	
			    	default:
			    		reports.writeResult(driver,"warning","Invalid object type '"+objtype+"' was specified",test);
			    		return false;
			    	
			  }
			  if(appInd.compareValue(actual, expected, test))
			  {
				  return true;
			  }
			  else
			  {
				  return false;
			  }
		  }
		  else
		  {
			  reports.writeResult(driver,"fail","The element '"+String.valueOf(objBy)+"' was not found in the DOM.",test);
				return false;
		  }
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in executing 'VerifyText()' method "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEles=null;
			oSel=null;
			actual=null;
		}
		
	}
	
	/*******************************************************
	 * Method Name	`	: verifyElementExist()
	 * Purpose			: to validate the presence of the webelement on the DOM
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean verifyElementExists(AndroidDriver<AndroidElement> driver, By objBy,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
			oEles=driver.findElements(objBy);
			if(oEles.size()>0)
			{
				reports.writeResult(driver,"pass","The webelement '"+String.valueOf(objBy)+"' was present in the DOM",test);
				return true;
			}
			else
			{
				reports.writeResult(driver,"fail","The webelement '"+String.valueOf(objBy)+"' was not found in the DOM",test);
				return false;
			}
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'verifyElementExists()' "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEles=null;
		}
	}
	
	/*******************************************************
	 * Method Name	`	: verifyElementExist()
	 * Purpose			: to validate the presence of the webelement on the DOM
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean verifyElementExists(AndroidDriver<AndroidElement> driver, String objBy,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
			oEles=driver.findElements(By.xpath(objBy));
			if(oEles.size()>0)
			{
				reports.writeResult(driver,"pass","The webelement '"+String.valueOf(objBy)+"' was present in the DOM",test);
				return true;
			}
			else
			{
				reports.writeResult(driver,"fail","The webelement '"+String.valueOf(objBy)+"' was not found in the DOM",test);
				return false;
			}
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'verifyElementExists()' "+e.getMessage(),test);
			return false;
		}
		finally
		{
			oEles=null;
		}
	}
	
	/*******************************************************
	 * Method Name	`	: verifyElementNotExist()
	 * Purpose			: to validate the non-presence of the webelement on the DOM
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	public boolean verifyElementNotExist(AndroidDriver<AndroidElement>driver, By objBy,ExtentTest test)
	{
		List<AndroidElement>oEles=null;
		try
		{
			oEles=driver.findElements(objBy);
			if(oEles.size()>0)
			{
				reports.writeResult(driver,"pass","The webelement '"+String.valueOf(objBy)+"' was still present on the DOM",test);
				return false;
			}else {
				reports.writeResult(driver,"fail","The webelement '"+String.valueOf(objBy)+"' was removed from the DOM",test);
				return true;
			}
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'verifyElementNotExist()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	/*******************************************************
	 * Method Name	`	: verifyElementNotExist()
	 * Purpose			: to validate the non-presence of the webelement on the DOM
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	public boolean verifyElementNotExist(AndroidDriver<AndroidElement>driver, String objBy,ExtentTest test)
	{
		List<AndroidElement>oEles=null;
		try
		{
			oEles=driver.findElements(By.xpath(objBy));
			if(oEles.size()>0)
			{
				reports.writeResult(driver,"pass","The webelement '"+String.valueOf(objBy)+"' was still present on the DOM",test);
				return false;
			}else {
				reports.writeResult(driver,"fail","The webelement '"+String.valueOf(objBy)+"' was removed from the DOM",test);
				return true;
			}
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'verifyElementNotExist()' method "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	
	/*******************************************************
	 * Method Name	`	: verifyOptionalElement()
	 * Purpose			: to validate the presence of the optional webelement on the DOM
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean verifyOptionalElement(AndroidDriver<AndroidElement>driver, By objBy,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
		  oEles=driver.findElements(objBy);
		  if(oEles.size()>0)
		  {
			  return true;
		  }else
		  {
			  return false;
		  }
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'verifyOptionalElement()' "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	/*******************************************************
	 * Method Name	`	: verifyOptionalElement()
	 * Purpose			: to validate the presence of the optional webelement on the DOM
	 * Author			:
	 * Reviewer			:
	 * Date creation	:
	 * Date Modified	:
	 * Modified By		:
	 * Parameters		: WebDriver oBrowser, By objBy
	 * Return Type		: boolean
	 ********************************************************/
	
	public boolean verifyOptionalElement(AndroidDriver<AndroidElement>driver, String objBy,ExtentTest test)
	{
		List<AndroidElement> oEles=null;
		try
		{
		  oEles=driver.findElements(By.xpath(objBy));
		  if(oEles.size()>0)
		  {
			  return true;
		  }else
		  {
			  return false;
		  }
		}catch(Exception e)
		{
			reports.writeResult(driver,"exception","Exception in 'verifyOptionalElement()' "+e.getMessage(),test);
			return false;
		}finally
		{
			oEles=null;
		}
	}
	
	public void writeResult(String strStatus, String strMessage)
	{
		Logger log=null;
		try
		{
			log=Logger.getLogger("SG");
			
			switch(strStatus.toLowerCase())
			{
			   case "pass" :
				   log.info(strMessage);
				   break;
				   
			   case "fail":
				   log.error(strMessage);
				   break;
				   
			   case "warning":
				   log.warn(strMessage);
				   break;
				   
			   case "exception":
				   log.fatal(strMessage);
				   break;
				   
			   case "":
				   log.info(strMessage);
					break;
				default:
					System.out.println("Invalid result status '"+strStatus+"' was specified.");
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception in 'writeResult()' method "+e.getMessage());
		}
		finally
		{
			log=null;
		}
	}
	
	/***********************************************************
	 * Method Name			: getDateTime()
	 * Author Name			: 
	 * Purpose				: It is to get the current date in required format
	 * Arguments			: String strDateFormat
	 * Return Type			: String
	 * 
	 ************************************************************/
	public String getDateTime(String strDateFormat)
	{
		Date dt = null;
		SimpleDateFormat sdf = null;
		try {
			dt = new Date();
			sdf = new SimpleDateFormat(strDateFormat);
			return sdf.format(dt);
		}catch(Exception e)
		{
			System.out.println("Exception in 'getDateTime()' method. "+ e.getMessage());
			return null;
		}
		finally
		{
			dt = null;
			sdf = null;
		}
	}
	
	
}
