package TestSuite;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.BaseClass.Random_NO;
import com.crm.FileUtility.FileUtility;
import com.crm.POM.POM_VTiger;

@Listeners(com.crm.Listners.ListnersCreate_org.class)
public class CreateOrganization extends BaseClass
{
	@Test
	public void creareOrg() throws IOException
	{
		preCondition();
		login();
		POM_VTiger w=new POM_VTiger(driver);
		w.org.click();
		w.create_org.click();
		
		FileUtility org=new FileUtility();
		String create_org=org.createOrgExcel("Sheet1",0, 0);
		
		w.org_name.sendKeys(create_org + Random_NO.random());
		
		
		w.save.click();
		
		assertEquals(w.verify.getText().contains(create_org), "It is verifyyyy");
		logout();
			
		
	}

}
