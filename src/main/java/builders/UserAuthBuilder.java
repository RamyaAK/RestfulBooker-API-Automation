package builders;

import client.restfulBooker.authenticateUser.AuthRequest;
import properties.API_Properties;

public class UserAuthBuilder {
    public AuthRequest authRequest;


    public UserAuthBuilder() {
        authRequest = new AuthRequest();
        authRequest.setUsername(API_Properties.userName);
        authRequest.setPassword(API_Properties.password);
    }

    public AuthRequest build() {
        return authRequest;
    }
}
