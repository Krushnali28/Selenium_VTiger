package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_VTiger 
{
	public POM_VTiger(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(name = "user_name")
	WebElement user;
	
	public @FindBy(name="user_password")
	WebElement pass;
	
	public @FindBy(id="submitButton")
	WebElement submit;
	
	
	public @FindBy(linkText = "Organizations")
	WebElement org;
	
	public @FindBy(xpath = "//img[@alt='Create Organization...']")
	WebElement create_org;
	
	public @FindBy(name="accountname")
	WebElement org_name;
	
	public @FindBy(name="button")
	WebElement save;
	
	
	public @FindBy(name="industry")
	WebElement industry;
	
	public @FindBy(xpath = "(//td[@class='small'])[2]")
	WebElement profile;
	
	public @FindBy(linkText = "Sign Out")
	WebElement logout;
	
	public @FindBy(linkText = "Contacts")
	WebElement contact;
	
	public @FindBy(xpath = "//img[@alt='Create Contact...']")
	WebElement addContact;
	
	public@FindBy(name = "lastname")
	WebElement lname;
	
	public @FindBy(className = "dvHeaderText")
	WebElement verify;

}
