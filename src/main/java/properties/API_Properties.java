package properties;

public class API_Properties {
    public static final PropertiesReader properties = new PropertiesReader();
    public static final String baseURL = properties.getBaseURL();
    public static final String userName = properties.getUsername();
    public static final String password = properties.getPassword();
}
