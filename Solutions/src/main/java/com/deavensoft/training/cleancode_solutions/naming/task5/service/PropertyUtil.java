package com.deavensoft.training.cleancode_solutions.naming.task5.service;

import com.deavensoft.training.cleancode_solutions.naming.task5.thirdpartyjar.MissingConfigFileException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyUtil {

    private static final Logger LOGGER = Logger.getLogger(PropertyUtil.class.getName());
    private static final String CONFIG_FILE_NAME = "config.properties";

    private PropertyUtil() {
    }

    public static String loadProperty(String property) {
        Properties properties = loadProperties();
        return properties.getProperty(property);
    }

    private static Properties loadProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        loadPropertiesFileFromClassLoader(classLoader, properties);
        return properties;
    }

    private static void loadPropertiesFileFromClassLoader(ClassLoader classLoader, Properties properties) {
        try (InputStream inputStream = classLoader.getResourceAsStream(CONFIG_FILE_NAME)) {

            if (inputStream == null) {
                throw new MissingConfigFileException("Missing properties file...");
            }

            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while loading properties file", e);
        }
    }
}
