package restfulBookerAPITests.CreateNewBookingTest;

import builders.CreateNewRequestBuilder;
import client.restfulBooker.createNewBooking.CreateNewBookingClient;
import client.restfulBooker.createNewBooking.request.CreateNewBookingRequestBody;
import client.restfulBooker.createNewBooking.response.BookingResponse;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulBookerAPITests.BaseTest;

public class CreateNewBookingTest extends BaseTest {
    @Epic("Regression Tests")
    @Feature("Create Booking")
    @Test(description = "Verifying Create New Booking API")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create a New Booking")
    @Story("Create new Booking Test")
    public void createNewBookingTest(){

        CreateNewBookingRequestBody createNewBookingRequestBody = new CreateNewRequestBuilder().build();
        BookingResponse bookingResponse = new CreateNewBookingClient().createANewBooking(createNewBookingRequestBody);

        System.out.println(bookingResponse.getHttpStatusCode());
        System.out.println(bookingResponse.getBookingid());
        Assert.assertEquals(bookingResponse.getHttpStatusCode(), 200);
        Assert.assertEquals(bookingResponse.getBooking().getBookingdates().getCheckout(), "2020-01-02");

    }
}
