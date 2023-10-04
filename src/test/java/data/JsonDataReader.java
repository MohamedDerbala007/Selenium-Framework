package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class JsonDataReader 
{
	public String firstName , lastName , email , oldPassword;
	
	public void JsonReader() throws IOException, ParseException
	{
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray)parser.parse(new FileReader(srcFile));
		
		for(Object jsonObj : jArray)
		{
			JSONObject person = (JSONObject) jsonObj;
			firstName = (String) person.get("firstname");
			System.out.println(firstName);
			
			lastName = (String) person.get("lastname");
			System.out.println(lastName);
			
			email = (String) person.get("email");
			System.out.println(email);
			
			oldPassword = (String) person.get("password");
			System.out.println(oldPassword);
			
		}
	}

}
