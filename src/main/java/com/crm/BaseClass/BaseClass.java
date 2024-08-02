package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.POM.POM_VTiger;

import JavaUtility.JavaUtility;

public class BaseClass 
{
	public static WebDriver driver;
	
	public void preCondition() throws IOException
	{
		String browser=JavaUtility.LoginData("browser");
		String url=JavaUtility.LoginData("url");
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	public void login() throws IOException
	{
		POM_VTiger w=new POM_VTiger(driver);

		String username= JavaUtility.LoginData("username");
		String password=JavaUtility.LoginData("password");		
		
		w.user.sendKeys(username);
		w.pass.sendKeys(password);
		w.submit.click();
	}
	public void logout()
	{
		POM_VTiger w=new POM_VTiger(driver);

		w.profile.click();
		w.logout.click();
	}
	public void postCondition()
	{
		driver.quit();
	}

}
