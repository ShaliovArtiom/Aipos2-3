package by.bsuir.Shaliov;

import by.bsuir.Shaliov.service.TransporConnector;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс, предназначенный для задания клиенту порта и хоста
 * @author ShaliovArtiom, TruntsVitalij
 */
public class ConfigReader {
    public ConfigReader() {

    }

    /**
     * Функция получения порта
     * @return возращает значение порта
     * @throws ParseException ошибка чтения файла
     */
    public static String getPORT() throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(getConfigString());
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println(jsonObj.get("PORT"));
        return jsonObj.get("PORT").toString();
    }

    /**
     * Функция получения хоста
     * @return возращает значение хоста
     * @throws ParseException ошибка чтения файла
     */
    public static String getURL() throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(getConfigString());
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println(jsonObj.get("HOST"));
        return jsonObj.get("HOST").toString();
    }

    /**
     * Функция чтения файла config.json
     * @return возвращает содержимое файла в string
     */
    private static String getConfigString(){
        StringBuilder string = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(TransporConnector.class.getResourceAsStream("/config.json")));
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
