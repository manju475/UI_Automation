package com.ui_automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.ui_automation.base.BaseClass;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;

public class ReadPropertyFile{
	public static Properties prop;
	public static FileInputStream fs;
	public static String fileLocation = "/Users/manjunatha/JAVA/Hybrid_Framework/UI_Automation_Project/TestData/config.Properties";
	public static String browserName;
	public static String url;
	
	public ReadPropertyFile() throws IOException, FileNotFoundException {
		fs = new FileInputStream(fileLocation);
		prop = new Properties();
		prop.load(fs);
		
		
	}
	public static String getURL() {
		url = prop.getProperty("url");
		return url;
	}
	public static String getBrowser() {
		browserName = prop.getProperty("browser");
		return browserName;
	}

}
