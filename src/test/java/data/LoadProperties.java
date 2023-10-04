package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	// Load the properties data from the file
	public static Properties UserData = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userData.properties");
	
	
	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		
		//Stream for reading file
		try 
		{
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("Error occurred : " + e.getMessage());
		}
		catch (IOException e) 
		{
			System.out.println("Error occurred : " + e.getMessage());
		}
		return pro;
	}

}
