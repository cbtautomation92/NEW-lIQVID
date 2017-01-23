package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StudentPo {
	WebDriver driver = null;
	public StudentPo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
