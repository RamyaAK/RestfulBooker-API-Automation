package restfulBookerAPITests;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.BeforeSuite;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseTest {
    @BeforeSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Testing Type","Backend API")
                        .put("Environment", "QA environment")
                        .put("URL", "https://restful-booker.herokuapp.com")
                        .build(),System.getProperty("user.dir")
                + "/allure-results/");
    }
}
