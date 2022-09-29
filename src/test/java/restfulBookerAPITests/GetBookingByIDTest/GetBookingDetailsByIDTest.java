package restfulBookerAPITests.GetBookingByIDTest;

import builders.CreateNewRequestBuilder;
import client.restfulBooker.createNewBooking.CreateNewBookingClient;
import client.restfulBooker.createNewBooking.request.CreateNewBookingRequestBody;
import client.restfulBooker.createNewBooking.response.BookingResponse;
import client.restfulBooker.getBookingDetailsById.GetBookingDetailsByIDClient;
import client.restfulBooker.getBookingDetailsById.response.GetBookingDetailsByID;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulBookerAPITests.BaseTest;

public class GetBookingDetailsByIDTest extends BaseTest {
    @Epic("Regression Tests")
    @Feature("Fetch Booking Details By BookingID")
    @Test(description = "Verifying Get Booking Details By ID API")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get Booking Details By Booking ID")
    @Story("Get Booking Details by BookingID Test")
    public void getBookingDetailsByPassingBookingIDTest() {

        //create a new booking
        CreateNewBookingRequestBody createNewBookingRequestBody = new CreateNewRequestBuilder().build();
        BookingResponse bookingResponse = new CreateNewBookingClient().createANewBooking(createNewBookingRequestBody);
        System.out.println("Booking ID that is being Updated " + bookingResponse.getBookingid());

        int id = bookingResponse.getBookingid();
        GetBookingDetailsByID getBookingDetailsByID = new GetBookingDetailsByIDClient().getBookingDetailsById(id);

        Assert.assertEquals(getBookingDetailsByID.getHttpStatusCode(), 200);
        Assert.assertEquals(getBookingDetailsByID.getFirstname(), "gg");
        Assert.assertEquals(getBookingDetailsByID.getLastname(), "Krishna");
        Assert.assertEquals(getBookingDetailsByID.getTotalprice(), 2347);
        Assert.assertTrue(getBookingDetailsByID.isDepositpaid());
        Assert.assertEquals(getBookingDetailsByID.getBookingdates().getCheckin(), "2020-01-01");
        Assert.assertEquals(getBookingDetailsByID.getBookingdates().getCheckout(), "2020-01-02");
        Assert.assertEquals(getBookingDetailsByID.getAdditionalneeds(), "Breakfast");

    }
}
