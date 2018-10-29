package mail.utils;

import framework.PropertyReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class JsonReader {
    private static String PATH_TO_JSON = PropertyReader.class.getClassLoader().getResource("datafortests.json").getPath();
    private static String value;

    public static String getJSONData(String key) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(PATH_TO_JSON));
            JSONObject object = (JSONObject) obj;
            value = (String) object.get(key);
        } catch (IOException e){
            System.out.println("File not found");
        } catch (ParseException e){
            System.out.println("Parse ERROR!");
        }
        return value;
    }
}
