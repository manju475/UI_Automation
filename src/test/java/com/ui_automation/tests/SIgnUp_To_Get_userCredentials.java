package com.ui_automation.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui_automation.base.BaseClass;
import com.ui_automation.pages.CredentialsPage;
import com.ui_automation.pages.SignUpPage;

@Listeners(com.ui_automation.utility.TestNGListeners.class)
public class SIgnUp_To_Get_userCredentials extends BaseClass{
	public static String emailID = "abc@gmail.com";
	public static String currentURL;
	@Test
	public static void signUp() {
		SignUpPage signUp= PageFactory.initElements(driver, SignUpPage.class);
		signUp.getEmailID(emailID);
		signUp.submitButton();
		currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://demo.guru99.com/access.php?uid=mngr26593%20&%20pass=123Abc@%20&%20email="+emailID);
		
		CredentialsPage LoginDetails = PageFactory.initElements(driver, CredentialsPage.class);
		String username = LoginDetails.getUsername();
		String password = LoginDetails.getPassword();
		Assert.assertEquals(currentURL,"https://demo.guru99.com/access.php?uid=mngr26593%20&%20pass=123Abc@%20&%20email="+emailID);	
	}

}
