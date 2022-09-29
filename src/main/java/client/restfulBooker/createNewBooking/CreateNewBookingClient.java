package client.restfulBooker.createNewBooking;

import client.restfulBooker.createNewBooking.request.CreateNewBookingRequestBody;
import client.restfulBooker.createNewBooking.response.BookingResponse;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import properties.API_Properties;

import static io.restassured.RestAssured.given;

public class CreateNewBookingClient {

    public BookingResponse createANewBooking(CreateNewBookingRequestBody createNewBookingRequestBody) {

        String url = String.format("%s/booking", API_Properties.baseURL);
        System.out.println(url);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(createNewBookingRequestBody)
                .post(url)
                .then()
                .log().all()
                .extract().response();

        BookingResponse bookingResponse = response.as(BookingResponse.class);
        bookingResponse.setHttpStatusCode(response.getStatusCode());
        return bookingResponse;
    }

}
