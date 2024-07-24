package com.ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui_automation.base.BaseClass;

public class CredentialsPage extends BaseClass{
	
	@FindBy(xpath = "//td[contains(text(),'mngr26593')]") public WebElement userID;
	@FindBy(xpath = "//td[contains(text(),'123Abc@')]") public WebElement password;
	
	public CredentialsPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	public String getUsername() {
		return userID.getText();
	}
	public String getPassword() {
		return password.getText();
	}
	

}
