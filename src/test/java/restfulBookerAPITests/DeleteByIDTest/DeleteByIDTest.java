package restfulBookerAPITests.DeleteByIDTest;

import builders.CreateNewRequestBuilder;
import builders.UserAuthBuilder;
import client.restfulBooker.authenticateUser.AuthClient;
import client.restfulBooker.authenticateUser.AuthRequest;
import client.restfulBooker.authenticateUser.AuthResponse;
import client.restfulBooker.createNewBooking.CreateNewBookingClient;
import client.restfulBooker.createNewBooking.request.CreateNewBookingRequestBody;
import client.restfulBooker.createNewBooking.response.BookingResponse;
import client.restfulBooker.deleteBookingByID.DeleteByBookingIDClient;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import restfulBookerAPITests.BaseTest;

public class DeleteByIDTest extends BaseTest {
    @Epic("Regression Tests")
    @Feature("Delete Booking")
    @Test(description = "Verifying DeleteBookingDetails By BookingId API")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete Booking Details for a given BookingId")
    @Story("Delete Booking Test")
    public void DeleteByIDTest() {

        // Authenticate user
        AuthRequest authRequest = new UserAuthBuilder().build();
        AuthResponse authResponse = new AuthClient().authenticateUser(authRequest);
        String token = authResponse.getToken();

        // create a new Booking
        CreateNewBookingRequestBody createNewBookingRequestBody = new CreateNewRequestBuilder().build();
        BookingResponse bookingResponse = new CreateNewBookingClient().createANewBooking(createNewBookingRequestBody);
        int id = bookingResponse.getBookingid();

        // delete Booking by passing the token and Booking Id to be deleted.
        DeleteByBookingIDClient deleteByBookingIDClient = new DeleteByBookingIDClient();
        deleteByBookingIDClient.deleteBookingIDWith(id, token);
    }
}
