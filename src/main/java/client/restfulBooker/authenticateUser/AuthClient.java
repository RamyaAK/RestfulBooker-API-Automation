package client.restfulBooker.authenticateUser;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public AuthResponse authenticateUser(AuthRequest authrequest) {

        String url = String.format("%s/auth", API_Properties.baseURL);
        System.out.println(url);

        Response response = given()
                .when()
                .contentType("application/json")
                .body(authrequest)
                .post(url)
                .then()
                .log().all()
                .extract().response();

        AuthResponse authResponse = response.as(AuthResponse.class);
        authResponse.setHttpStatusCode(response.getStatusCode());

        return authResponse;
    }
}
