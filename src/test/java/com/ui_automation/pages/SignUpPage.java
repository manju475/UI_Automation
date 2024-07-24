package com.ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui_automation.base.BaseClass;

public class SignUpPage extends BaseClass{
	
	@FindBy(name="emailid") public WebElement emailID;
	@FindBy(name="btnLogin") public WebElement submitButton;
	
	public SignUpPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	
	public void getEmailID(String username) {
		emailID.sendKeys(username);
	}
	
	public void submitButton() {
		submitButton.click();
	}

}
