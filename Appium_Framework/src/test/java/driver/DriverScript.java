package driver;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import methods.AppDependentMethods;
import methods.AppIndependentMethods;
import methods.MobileGestures;
import methods.StartServer;
import reports.ReportUtils;
import testScripts.TestScript;

public class DriverScript {
	
	public static AppIndependentMethods appInd=null;
	public static AppDependentMethods appDep=null;
	public static TestScript script=null;
	public static MobileGestures gestures=null;
	public static ReportUtils reports=null;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	public static StartServer services=null;
	public static String screenshotLocation=null;
	public static boolean blnRes=false;

	
		
	
	   public static void main(String[] args) {

			services=new StartServer();
			appInd=new AppIndependentMethods();
			appDep=new AppDependentMethods();
			script=new TestScript();
			gestures=new MobileGestures();
			reports=new ReportUtils();
			extent = reports.startExtentReport("TestResult", appInd.readConfigData("BuildNumber"));
		
		
		blnRes = script.TS_LoginLogout();
		if(blnRes) System.out.println("The test script 'TS_LoginLogout()' passed");
		else System.out.println("The test script 'TS_LoginLogout()' failed");

	}

}
