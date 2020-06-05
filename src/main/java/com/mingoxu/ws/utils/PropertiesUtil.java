package com.mingoxu.ws.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static Logger logger = Logger.getLogger(PropertiesUtil.class);
    private static PropertiesUtil propertiesUtil = new PropertiesUtil();
    private static Properties properties = new Properties();
    private static String config = "config.properties";

    private PropertiesUtil() {}

    static {
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(config);
        try {
            properties.load(in);
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static PropertiesUtil getInstance() {
        return propertiesUtil;
    }

    public static Properties getProperties() {return properties;}

    public String getProperty(String key) {

        return properties.getProperty(key);
    }
}
