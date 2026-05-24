package utilities;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContent {
    private static Map<String, Object> data = new HashMap<>();

    public static void setData(String key, Object value){
        data.put(key, value);
    }

    public static Object getData(String key){
        return data.get(key);
    }

}
