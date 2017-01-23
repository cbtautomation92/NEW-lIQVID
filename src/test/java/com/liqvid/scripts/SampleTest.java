package com.liqvid.scripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.liqvid.library.BaseLib;
import com.liqvid.library.GenericLib;
import com.liqvid.library.ParallelBaseLibConfig;

public class SampleTest extends BaseLib {
	
	public void swtichhearderframe(){
		driver.switchTo().frame(driver.findElement(By.id("fraheader")));
		Assert.assertTrue(driver.findElement(By.id("spnTitle2")).isDisplayed(),"The text is not displayed" );
		System.out.println(driver.findElement(By.id("spnTitle2")).getText());
	
		
	}
	public void swtichbarframe() throws InterruptedException{
		
		driver.switchTo().frame(driver.findElement(By.id("frabotbar")));
	Assert.assertTrue(driver.findElement(By.id("pgValue")).isDisplayed(),"the text is not displayed");
   	  System.out.println(driver.findElement(By.id("pgValue")).getText());
   	 WebElement element3 = driver.findElement(By.id("imgNext"));
     WebElement element4 = driver.findElement(By.id("imgRef"));
   	 JavascriptExecutor js = (JavascriptExecutor)driver;
   	  js.executeScript("arguments[0].click();", element3);
     Thread.sleep(5000);
     js.executeScript("arguments[0].click();", element4);
	
		
	}
	
	@Test(priority=1,enabled=true, description="To Verify the display of Elements in Auditor Login Page")
	public void adminLogin() throws InterruptedException, MalformedURLException{
		
		
		driver.get("http://10.10.12.189:4001/learning/index.php");
		elementStatus(driver.findElement(By.id("LoginForm_username")),"Teacher username text field","displayed");
		driver.findElement(By.id("LoginForm_username")).sendKeys("RaghuKiran-1-71-2");
		driver.findElement(By.id("LoginForm_password")).sendKeys("raghukiran92");
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='contentLogin']/div/div[1]/div[2]/section/div/div[3]/input")).click();
		Thread.sleep(5000);
		
		/*driver.findElement(By.xpath("//b[@class='caret']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		Thread.sleep(5000);*/
		driver.findElement(By.xpath("//span[text()='Courses']")).click();
		Thread.sleep(5000);
	WebElement element = driver.findElement(By.id("class_select"));
		Select select=new Select(element);
		Thread.sleep(4000);
		select.selectByValue("Class2~~2");
		WebElement element1 = driver.findElement(By.id("course_select"));
		Select select1=new Select(element1);
		select1.selectByVisibleText("Course 2");
		Thread.sleep(4000);
		driver.findElement(By.id("strt")).click();
		Thread.sleep(4000);
		WebElement element2 = driver.findElement(By.xpath("//iframe[@id='iframes']"));
		/*driver.switchTo().frame(0);
		driver.findElement(By.xpath(".//*[@id='index']/div/div[1]/a")).click();
		
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//ul[@class='list-group']/..//a[text()='Start Test']")).click();*/
		//String text=driver.findElement(By.xpath("//div[@class='clearfix']//div[@class='row m-b-xl']//div[@class='col-sm-4 animated fadeInUp']//ul//div[@id='slimScrollDiv1']//h1[text()='Instructions']")).getText();
		//System.out.println(text);
		/*Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@id='mywizard']//div[@class='actions']//button[@id='netbtn']")).getText());
		WebElement element6=driver.findElement(By.xpath("//div[@id='mywizard']//div[@class='actions']//button[@id='netbtn']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	   	  js.executeScript("arguments[0].click();", element6);*/
		driver.switchTo().frame(element2);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='index']/div/div[4]/a")).click();
		Set<String> allWindows=driver.getWindowHandles();
        Iterator<String> it = allWindows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);  
        Thread.sleep(6000);
        for(int i=1;i<=15;i++){
        	swtichhearderframe();
        	driver.switchTo().defaultContent();
        	swtichbarframe();
        	driver.switchTo().defaultContent();
        }
    	  
    	 
      driver.switchTo().window(parentWindowId);
        Thread.sleep(6000);
       driver.quit();
		
	}
	@Test(priority=2,enabled=false, description="To Verify the display of Elements in Auditor Login Page")
	public void adminlogin2() throws InterruptedException{
		
		driver.get("http://10.10.12.189:4001/learning/index.php");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='scrollDivSlide btn btn-primary form-control input-lg  pre-loader']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Student']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//input[@id='fld_first_name']")).sendKeys("CBT");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//input[@id='fld_last_name']")).sendKeys("Automation");
		Thread.sleep(2000);
		//fld_email
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//input[@id='fld_email']")).sendKeys("cbtautomation92@gmail.com");
		Thread.sleep(2000);
		//fld_mobile
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//input[@id='fld_mobile']")).sendKeys("8971222976");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//div[@id='divStudentBirthDate']//span//i[@class='fa fa-calendar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div[1]/table/thead/tr[1]/th[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/table/tbody/tr/td/span[1]")).click();
		driver.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//select[@id='fld_gender']")).click();
		WebElement genderlist=driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//select[@id='fld_gender']"));
		Select select=new Select(genderlist);
		select.selectByVisibleText("Male");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//input[@id='fld_Spassword']")).sendKeys("raghukiran92");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//input[@id='confirmfld_password']")).sendKeys("raghukiran92");
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//select[@id='fld_class']")).click();
		WebElement listclass=driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//select[@id='fld_class']"));
		Thread.sleep(2000);
		Select select1=new Select(listclass);
		select1.selectByVisibleText("Class 2");
		Thread.sleep(2000);
		//
		driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//select[@id='fld_section']")).click();
		WebElement listsection=driver.findElement(By.xpath("//form[@id='studentSignUp']//div//div//select[@id='fld_section']"));
		listsection.click();
		Select select2=new Select(listsection);
		Thread.sleep(2000);
		select2.selectByVisibleText("A");
		
		Thread.sleep(2000);
		driver.findElement(By.name("uSignUp")).click();
		Thread.sleep(5000);
		String text=driver.findElement(By.xpath("(//p[@class='page-sub-heading'])[1]")).getText();
		String text1=text.substring(11,17);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='blueText  pre-loader']")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("LoginForm_username")).sendKeys(text1);
		driver.findElement(By.id("LoginForm_password")).sendKeys("raghukiran92");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='contentLogin']/div/div[1]/div[2]/section/div/div[3]/input")).click();
		Thread.sleep(10000);
		
	}
		
		
}
