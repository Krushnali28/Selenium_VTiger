package TestSuite;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.FileUtility.FileUtility;
import com.crm.POM.POM_VTiger;
@Listeners(com.crm.Listners.Listner_Create_Org_With_Industry.class)
public class Create_Organization_With_Industry extends BaseClass
{
	@Test
	public void industry() throws IOException
	{
		preCondition();
		login();
		POM_VTiger w=new POM_VTiger(driver);
		w.org.click();
		w.create_org.click();
		
		FileUtility org=new FileUtility();
		
		String name=org.createOrgExcel("Sheet1",0, 0);
		String drop=org.createOrgExcel("Sheet1", 1, 0);
		
		w.org_name.sendKeys(name);
		Select s=new Select(w.industry);
		s.selectByValue(drop);
		w.save.click();
		
	}

}
