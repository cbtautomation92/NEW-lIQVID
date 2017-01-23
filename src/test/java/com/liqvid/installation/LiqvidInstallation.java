package com.liqvid.installation;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liqvid.library.GenericLib;

public class LiqvidInstallation 
{
	public static String sEnglishEdgeInstallerFile = GenericLib.sDirPath+"\\resources\\install.exe";
	public static String sLiquidInstallerFile = GenericLib.sDirPath+"\\resources\\LiqvidInstallation.exe";	
	/* 
	 * @Description: Installing the EnglishEdge.exe and to verify Registration screen is displayed.
	 * @Author: RaghuKiran MR
	 */
    @Test(priority=1,enabled=true, description="Installing the EnglishEdge.exe and to verify Registration screen is displayed.")
    public void liqvidInstallation() throws Exception
    {
		try
		{
			Runtime.getRuntime().exec(sEnglishEdgeInstallerFile);
			Thread.sleep(8000);
			Runtime.getRuntime().exec(sLiquidInstallerFile);
	    } 
		catch (Exception ex) 
		{
			ex.printStackTrace();
	    }
	}
}
