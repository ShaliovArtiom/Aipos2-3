package by.bsuir.Shaliov;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ShaliovArtiom
 */
public class ConfigReader {
    public ConfigReader() {

    }

    public static String getPORT() throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(getConfigString());
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println(jsonObj.get("PORT"));
        return jsonObj.get("PORT").toString();
    }

    private static String getConfigString(){
        StringBuilder string = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/config.json")));
        while (true){
            try {
                String str = reader.readLine();
                if (str == null || str.isEmpty()){
                    break;
                }
                string.append(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return string.toString();
    }
}
