package com.liqvid.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;

public class ParallelBaseLibConfig {
	public WebDriver driver;
	public static int sStatusCnt=0;
	WebDriverWait wait=null;
	
	
	 @Parameters("browser")
	@BeforeMethod
	public void setup(String browser){
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\geckodriver.exe");
			  driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("ie")) { 
			 
		 
			System.setProperty("webdriver.ie.driver", GenericLib.sDirPath+"\\resources\\IEDriverServer.exe");
		 
			  driver = new InternetExplorerDriver();
		 
		  } else if (browser.equalsIgnoreCase("chrome")) { 
				 
				 
			  System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\chromedriver.exe");
			 
				driver = new ChromeDriver();
			 
			  } 	 
	}
	 public void loadURL(String sUrl)
		{
			try{
				driver.get(sUrl);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}catch(AssertionError e){
				NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}	
		}
		public void elementStatus(WebElement element, String elementName, String checkType) 
		{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			switch(checkType)
			{
				case "displayed":
					try 
				    {
				        element.isDisplayed();
				        NXGReports.addStep(elementName+ " is displayed", LogAs.PASSED, null);
				    } 
				    catch (Exception e) 
				    {
				    	BaseLib.sStatusCnt++;
				    	NXGReports.addStep(elementName+ " is not displayed", LogAs.FAILED, null);
				    }
					break;
				case "enabled":
					try 
				    {
				        element.isEnabled();
				        NXGReports.addStep(elementName+ " is enabled", LogAs.PASSED, null);
				    } 
				    catch (Exception e) 
				    {
				    	BaseLib.sStatusCnt++;
				    	NXGReports.addStep(elementName+ " is not enabled", LogAs.FAILED, null);
				    }
					break;
				case "selected":
					try 
					{
						element.isSelected();
					    NXGReports.addStep(elementName+ " is selected", LogAs.PASSED, null);  
					} 
					catch (Exception e) 
					{
					   	BaseLib.sStatusCnt++;
					   	NXGReports.addStep(elementName+ " is not selected", LogAs.FAILED, null);
					}
					break;
				}
		}
		
		public void visibilityOfElementWait(WebElement webElement,String elementName)
		{
		   try 
		   {
			   wait = new WebDriverWait(driver, 15);
		       wait.until(ExpectedConditions.visibilityOf(webElement));
		   } 
		   catch (Exception e) 
		   {
		     	BaseLib.sStatusCnt++;
		      	NXGReports.addStep(elementName+ " is not Visible", LogAs.FAILED, null);
		   }
		} 

}
