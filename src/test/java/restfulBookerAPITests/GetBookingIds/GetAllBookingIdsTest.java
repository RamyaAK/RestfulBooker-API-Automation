package restfulBookerAPITests.GetBookingIds;

import client.restfulBooker.getAllBookingIds.GetAllBookingIdsClient;
import client.restfulBooker.getAllBookingIds.response.GetAllBookingIdsResponse;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulBookerAPITests.BaseTest;

public class GetAllBookingIdsTest extends BaseTest {
    @Epic("Regression Tests")
    @Feature("Fetch All Booking IDs Created so far")
    @Test(description = "Verifying GetAllBookingIDs API")
    @Severity(SeverityLevel.NORMAL)
    @Description("Lists all the Booking IDs created")
    @Story("Get all Booking IDs Created Test")
    public void GetAllBookingIdsTest() {
        //When the response body starts with array of objects.
        GetAllBookingIdsResponse[] getAllBookingIds = new GetAllBookingIdsClient().getAllBookingIds();
        System.out.println("Number of Booking Ids: " + getAllBookingIds.length);
        System.out.println(getAllBookingIds[0].getBookingid());
        Assert.assertNotNull(getAllBookingIds[100].getBookingid());

    }
}
