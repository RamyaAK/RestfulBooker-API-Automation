package restfulBookerAPITests.UpdateBookingDetailsTest;

import builders.CreateNewRequestBuilder;
import builders.UpdatedBookingDetailsBuilder;
import builders.UserAuthBuilder;
import client.restfulBooker.authenticateUser.AuthClient;
import client.restfulBooker.authenticateUser.AuthRequest;
import client.restfulBooker.authenticateUser.AuthResponse;
import client.restfulBooker.createNewBooking.CreateNewBookingClient;
import client.restfulBooker.createNewBooking.request.CreateNewBookingRequestBody;
import client.restfulBooker.createNewBooking.response.BookingResponse;
import client.restfulBooker.updateBookingDetails.UpdateBookingDetailsClient;
import client.restfulBooker.updateBookingDetails.request.UpdateBookingDetailsRequestBody;
import client.restfulBooker.updateBookingDetails.response.UpdateBookingDetailsResponseBody;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulBookerAPITests.BaseTest;

public class UpdateBookingDetailsTest extends BaseTest {
    @Epic("Regression Tests")
    @Feature("Update Booking Details By BookingID")
    @Test(description = "Verifying Update Booking Details By ID API")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Update Booking Details for a given Booking ID")
    @Story("Update Booking Details By BookingID Test")
    public void updateBookingDetailsTest() {
        //Authenticate user to update the resource
        String tokenValue = authenticateUser();

        //create a new booking
        int id = createNewBooking();

        // call update booking details api and assert.
        System.out.println("Updating the Booking Details with Booking ID " + id);
        UpdateBookingDetailsRequestBody updatedRequestBody = new UpdatedBookingDetailsBuilder().build();
        UpdateBookingDetailsResponseBody updatedResponse = new UpdateBookingDetailsClient().updateBookingDetailsWith(id, updatedRequestBody, tokenValue);

        Assert.assertEquals(updatedResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(updatedResponse.getFirstname(), "NewJJ");
        Assert.assertEquals(updatedResponse.getLastname(), "NewKrishna");
        Assert.assertEquals(updatedResponse.getTotalprice(), 3245);
        Assert.assertTrue(updatedResponse.isDepositpaid());
        Assert.assertEquals(updatedResponse.getBookingdates().getCheckin(), "2018-01-01");
        Assert.assertEquals(updatedResponse.getBookingdates().getCheckout(), "2019-01-01");
        Assert.assertEquals(updatedResponse.getAdditionalneeds(), "Breakfast with Lunch");

    }

    public String authenticateUser() {
        System.out.println("Authenticating User and generating the token to be added in the req body while updating");
        AuthRequest authRequest = new UserAuthBuilder().build();
        AuthResponse authResponse = new AuthClient().authenticateUser(authRequest);
        String tokenValue = authResponse.getToken();
        System.out.println("Token Value = " + tokenValue);
        return tokenValue;
    }

    public int createNewBooking() {
        System.out.println("Creating a new Booking before Updating and fetching the BookingID to be added in the req body while updating");
        CreateNewBookingRequestBody createNewBookingRequestBody = new CreateNewRequestBuilder().build();
        BookingResponse bookingResponse = new CreateNewBookingClient().createANewBooking(createNewBookingRequestBody);
        System.out.println("Booking Id = " + bookingResponse.getBookingid());
        int id = bookingResponse.getBookingid();
        return id;
    }
}
