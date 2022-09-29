package client.restfulBooker.getAllBookingIds;

import client.restfulBooker.getAllBookingIds.response.GetAllBookingIdsResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class GetAllBookingIdsClient {

    //When the response body starts with array of objects.

    public GetAllBookingIdsResponse[] getAllBookingIds() {

        String url = String.format("%s/booking", API_Properties.baseURL);
        Response response = given()
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract().response();

        GetAllBookingIdsResponse[] getAllBookingIdsResponses = response.as(GetAllBookingIdsResponse[].class);
        return getAllBookingIdsResponses;
    }
}
