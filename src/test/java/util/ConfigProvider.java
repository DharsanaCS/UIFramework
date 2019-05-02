package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {

    private static String propertyFilePath = System.getProperty("user.dir")+"/src/config.properties";
    private static ConfigProvider instance = new ConfigProvider();


    private Properties properties;

    private ConfigProvider(){
        properties = new Properties();
        try {
            //properties.load(this.getClass().getClassLoader().getResourceAsStream("../../config.properties"));
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigProvider getInstance(){
        return instance;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
