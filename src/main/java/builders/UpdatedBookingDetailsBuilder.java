package builders;

import client.restfulBooker.updateBookingDetails.request.Bookingdates;
import client.restfulBooker.updateBookingDetails.request.UpdateBookingDetailsRequestBody;

public class UpdatedBookingDetailsBuilder {

    public UpdateBookingDetailsRequestBody updatedRequestBody;
    public Bookingdates bookingdates;

    public UpdatedBookingDetailsBuilder() {
        updatedRequestBody = new UpdateBookingDetailsRequestBody();
        bookingdates = new Bookingdates();

        updatedRequestBody.setFirstname("NewJJ");
        updatedRequestBody.setLastname("NewKrishna");
        updatedRequestBody.setTotalprice(3245);
        updatedRequestBody.setDepositpaid(true);
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        updatedRequestBody.setBookingdates(bookingdates);
        updatedRequestBody.setAdditionalneeds("Breakfast with Lunch");

    }

    public UpdateBookingDetailsRequestBody build() {
        return updatedRequestBody;
    }
}
