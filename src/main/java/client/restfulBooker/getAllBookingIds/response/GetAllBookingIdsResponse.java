package client.restfulBooker.getAllBookingIds.response;

import client.restfulBooker.BaseResponse;

public class GetAllBookingIdsResponse extends BaseResponse {
    public int bookingid;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }
}
