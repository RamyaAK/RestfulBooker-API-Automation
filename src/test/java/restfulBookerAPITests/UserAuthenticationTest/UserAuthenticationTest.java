package restfulBookerAPITests.UserAuthenticationTest;

import builders.UserAuthBuilder;
import client.restfulBooker.authenticateUser.AuthClient;
import client.restfulBooker.authenticateUser.AuthRequest;
import client.restfulBooker.authenticateUser.AuthResponse;
import entities.UserDetails;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulBookerAPITests.BaseTest;

public class UserAuthenticationTest extends BaseTest {
    @Epic("Regression Tests")
    @Feature("UserAuthentication Test")
    @Test(description = "Verifying UserAuthentication API")
    @Severity(SeverityLevel.BLOCKER)
    @Description("User Authentication and Token Generation for performing HTTP operations")
    @Story("User Authentication test")
    public void userAuthenticationTest() {
        AuthRequest authRequest = new UserAuthBuilder().build();
        AuthResponse authResponse = new AuthClient().authenticateUser(authRequest);

        Assert.assertEquals(authResponse.getHttpStatusCode(), 200);
        Assert.assertNotNull(authResponse.getToken());

        // verifying from the response class obj:

        authResponse.setToken(authResponse.getToken());
        System.out.println(authResponse.getToken());

        // verifying from the User Details class obj:

        UserDetails userDetails = new UserDetails();
        userDetails.setToken(authResponse.getToken());
        System.out.println(userDetails.getToken());
    }
}
