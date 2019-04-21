package api.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Resources {
    public static String defaultRequestWarning() {
        String warningText = "Error - Please check entered information";
        return warningText;
    }

    public static String defaultEnvWarning() {
        String warningText = "Error - Please check env.properties file";
        return warningText;
    }

    public static String envPropertyFilePath() {
        String envPropertyFilePath = "./swapiTestProj-master/src/main/resources/env.properties";
        return envPropertyFilePath;
    }

    public static String replacerPropertyFilePath() {
        String replacerPropertyFilePath = "./swapiTestProj-master/src/main/resources/replacer.properties";
        return replacerPropertyFilePath;
    }

    public static String getEnvValue() throws IOException {
        String serviceURL = null;
        String envValue = System.getProperty("urlConfig");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(Resources.envPropertyFilePath());
        prop.load(fis);

        if ("HERO".equals(envValue)) {
            serviceURL = (String) prop.get("ENDPOINT_HERO");
        } else {
            System.out.println(Resources.defaultEnvWarning());
        }
        return serviceURL;
    }

    public static String getTestParameter(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(Resources.replacerPropertyFilePath ());
        prop.load(fis);
        String value = (String) prop.get(key);
        return value;
    }

}
