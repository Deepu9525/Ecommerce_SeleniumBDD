package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    static{
        try{
            //FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            InputStream file = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (file == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            prop = new Properties();
            prop.load(file);

        }catch(IOException e){
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBrowser(){
        return prop.getProperty("browser", "chrome");
    }

    public static String getUrl(){
        return prop.getProperty("url");
    }

    public static int getTimeout() {
        String timeout = prop.getProperty("timeout");
        return (timeout != null) ? Integer.parseInt(timeout) : 10;
    }

}

