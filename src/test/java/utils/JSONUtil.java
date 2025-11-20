package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JSONUtil {

    public static JSONObject getJSON(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            FileReader reader = new FileReader(filePath);
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
