package com.fresco.play;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App 
{
    public static void main(String[] args) {

        App app = new App();
        Properties prop = app.loadPropertiesFile("db.properties");
        System.out.println("Loading DB Properties for active profile");        
        prop.forEach((k, v) -> System.out.println("\t"+k + " : " + v));

    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}
