package page.test;

import page.actions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import data.LoginData;

public class LoginTest extends LoginActions  {
	
	Object[][] returnValue;
	
	@Test(dataProvider = "getData")
	public void Login(LoginData logindata) throws Exception
	{
		InputUserNamePassword(logindata.getUsername(),logindata.getPassword());
		ClickSignIn();
	}
	
	@DataProvider
	public Object[][] getData() throws FileNotFoundException {
		try
		{
        JsonElement jsonData = new JsonParser().parse(new FileReader("/Users/amaanm/Desktop/ShaadiAutomationScript/src/main/java/data/login.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<LoginData> testData = new Gson().fromJson(dataSet, new TypeToken<List<LoginData>>() {
        }.getType());
        returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return returnValue;
    }
}






