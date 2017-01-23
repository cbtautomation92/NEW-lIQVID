package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminPo {

	WebDriver driver = null;
	public AdminPo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
