package data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class DataProvider {
	
	public Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/45146523.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<LoginData> testData = new Gson().fromJson(dataSet, new TypeToken<List<LoginData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
