package client.restfulBooker.updateBookingDetails;

import client.restfulBooker.updateBookingDetails.request.UpdateBookingDetailsRequestBody;
import client.restfulBooker.updateBookingDetails.response.UpdateBookingDetailsResponseBody;
import io.restassured.response.Response;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class UpdateBookingDetailsClient {
    public UpdateBookingDetailsResponseBody updateBookingDetailsWith(int id, UpdateBookingDetailsRequestBody requestBody, String token) {
        System.out.println("id = " + id + " requestBody = " + requestBody + " token : " + token);
        String value = "token=" + token;
        System.out.println("Cookie value: " + value);
        String url = String.format("%s/booking/%d", API_Properties.baseURL, id);
        System.out.println(url);


        Response response = given()
                .header("Content-Type", "application/json")
                .header("Cookie", value)
                .header("accept", "application/json")
                .when()
                .body(requestBody)
                .put(url)
                .then()
                .log().all()
                .extract().response();

        UpdateBookingDetailsResponseBody updatedResponse = response.as(UpdateBookingDetailsResponseBody.class);
        updatedResponse.setHttpStatusCode(response.getStatusCode());
        return updatedResponse;
    }
}
