package org.finalExamTae.utils.webtestdata;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * This class gas the methods to get data from a json
 */
public class WebData {
    private static final String JSON_FILE_PATH = "src/test/resources/web_data.json";
    private static final JsonParser parser = new JsonParser();

    /**
     * method to get the information from a json
     * @param Data the information you need to use
     * @return the information requested
     */
    public static String returnData(String Data) {
        return getJsonDataProperty(Data);
    }

    /**
     * Method for get data form JSON file.
     * @param value String
     * @return the value as a string
     */
    private static String getJsonDataProperty(String value) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(value)
                    .getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
