package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.liqvid.library.GenericLib;

public class Teachermainpo {
	public WebDriver driver;
	Teachermainpo(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void test(){
		driver.get("http://www.google.com");
	}
	
}
