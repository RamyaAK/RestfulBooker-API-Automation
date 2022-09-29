package client.restfulBooker.authenticateUser;

import client.restfulBooker.BaseResponse;

public class AuthResponse extends BaseResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
