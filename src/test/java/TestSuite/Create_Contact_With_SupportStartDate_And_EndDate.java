package TestSuite;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.POM.POM_VTiger;

@Listeners(com.crm.Listners.ListnersCreate_org.class)
public class Create_Contact_With_SupportStartDate_And_EndDate extends BaseClass
{
	@Test
	public void contact() throws IOException
	{
		preCondition();
		login();
		POM_VTiger w=new POM_VTiger(driver);
		w.contact.click();
		w.addContact.click();
		w.lname.sendKeys("jadhav");
		w.save.click();
		w.profile.click();
		w.logout.click();
		
		
	}

}
