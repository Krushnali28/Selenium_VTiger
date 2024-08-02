package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility 
{
	public String createOrgExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\91774\\Desktop\\VTiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("Sheet1");
		 String s=sheet.getRow(row).getCell(cell).toString();
		 return s;
		
	}

}
