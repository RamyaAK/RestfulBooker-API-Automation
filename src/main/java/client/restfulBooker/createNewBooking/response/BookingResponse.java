package client.restfulBooker.createNewBooking.response;

import client.restfulBooker.BaseResponse;

public class BookingResponse extends BaseResponse {
    public int bookingid;
    public Booking booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
