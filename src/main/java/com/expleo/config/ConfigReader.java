package com.expleo.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static String CONFIG_PATH="src/test/resources/config.properties";

    static {
        try {
            FileInputStream file=new FileInputStream(CONFIG_PATH);
            properties=new Properties();
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }

    public static String getBaseURI()
    {
        return properties.getProperty("github.base.uri");
    }

    public static String getOpenAPISpec()
    {
        return properties.getProperty("openapi.spec.path");
    }

}
