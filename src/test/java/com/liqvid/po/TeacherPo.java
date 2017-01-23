package com.liqvid.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TeacherPo {
		WebDriver driver = null;
		public TeacherPo(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
}
