package properties;

import org.testng.Reporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesReader {
    public Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        String environment = BaseProperties.qa_env;

        Reporter.log("ENVIRONMENT: " + BaseProperties.qa_env, true);

        String propertiesFilePath = environment + ".properties";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Execution Started on " + environment + " environment!");
        System.out.println("User " + getUsername() + " is currently loggedIn");

    }

    public String getBaseURL() {
        return properties.getProperty("url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
