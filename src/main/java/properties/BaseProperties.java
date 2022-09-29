package properties;

public class BaseProperties {
    public static final String qa_env = System.getProperty("environment", "qa");
    public static final String prod_env = System.getProperty("environment", "prod");
    public static final String staging_env = System.getProperty("environment", "staging");
    public static final String TAGS = System.getProperty("tags", "smoke");


}
