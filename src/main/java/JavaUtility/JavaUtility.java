package JavaUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JavaUtility 
{
	public static String LoginData(String key) throws IOException 
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("./Configuration file\\CommonData.properties");
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
	}

}
