package client.restfulBooker.getBookingDetailsById;

import client.restfulBooker.getBookingDetailsById.response.GetBookingDetailsByID;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class GetBookingDetailsByIDClient {

    public GetBookingDetailsByID getBookingDetailsById(int id) {

        String url = String.format("%s/booking/%d", API_Properties.baseURL, id);

        Response response = given()
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response();

        GetBookingDetailsByID getBookingDetailsByID = response.as(GetBookingDetailsByID.class);
        getBookingDetailsByID.setHttpStatusCode(response.getStatusCode());
        return getBookingDetailsByID;
    }
}
