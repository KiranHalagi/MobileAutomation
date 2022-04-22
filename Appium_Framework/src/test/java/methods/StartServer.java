package methods;

import java.io.IOException;
import java.net.ServerSocket;

import driver.DriverScript;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class StartServer extends DriverScript {
	public static AppiumDriverLocalService services;
	
	/*******************************************
	 * Method Name : startServer()
	 * Purpose	   : Read Data from properties file
	 * Author      :
	 * Reviewer    :
	 * *
	 * @return ****************************************
	 */
	
	public  AppiumDriverLocalService startServer()
	{
		try
		{
			boolean flag=checkIfServerIsRunning(4723);
			if(!flag)
			{
	        services=AppiumDriverLocalService.buildDefaultService();
	        services.start();
			}
	        
	        return services;
		}catch(Exception e)
		{
			System.out.println("Exception in 'startServer()' method"+e.getMessage());
			return null;
		}
		
	}
	
	public static void stopServer()
	{
		services.start();
		
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serverSocket=null;
		try
		{
			serverSocket=new ServerSocket(port); 
			serverSocket.close();
		}catch(IOException e)
		{
			//If control comes here the port is in use
			isServerRunning=true;
		}
		finally
		{
			serverSocket=null;
		}
		return  isServerRunning;
	}

}
