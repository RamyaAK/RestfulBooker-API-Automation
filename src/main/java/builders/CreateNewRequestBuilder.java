package builders;

import client.restfulBooker.createNewBooking.request.Bookingdates;
import client.restfulBooker.createNewBooking.request.CreateNewBookingRequestBody;
import io.qameta.allure.Step;

public class CreateNewRequestBuilder {
    public CreateNewBookingRequestBody createNewBookingRequestBody;
    public Bookingdates bookingdates;

    public CreateNewRequestBuilder() {
        createNewBookingRequestBody = new CreateNewBookingRequestBody();
        bookingdates = new Bookingdates();
        createNewBookingRequestBody.setFirstname("gg");
        createNewBookingRequestBody.setLastname("Krishna");
        createNewBookingRequestBody.setTotalprice(2347);
        createNewBookingRequestBody.setDepositpaid(true);
        bookingdates.setCheckin("2020-01-01");
        bookingdates.setCheckout("2020-01-02");
        createNewBookingRequestBody.setBookingdates(bookingdates);
        createNewBookingRequestBody.setAdditionalneeds("Breakfast");
    }

    public CreateNewBookingRequestBody build() {
        return createNewBookingRequestBody;
    }
}
