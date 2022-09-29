package client.restfulBooker.deleteBookingByID;

import io.restassured.response.Response;
import org.testng.Assert;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class DeleteByBookingIDClient {

    public void deleteBookingIDWith(int bookingID, String token) {

        String cookieValue = "token=" + token;
        System.out.println("Cookie Value: " + cookieValue + " Booking ID: " + bookingID);
        String url = String.format("%s/booking/%d", API_Properties.baseURL, bookingID);
        System.out.println("Delete Req URL: " + url);


        Response response = given()
                .header("Cookie", cookieValue)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .when()
                .delete(url)
                .then()
                .statusCode(201)
                .extract().response();

        String jsonResponse = response.asString();
        System.out.println(jsonResponse);
        Assert.assertEquals(jsonResponse.contains("Created"), true);
    }
}
