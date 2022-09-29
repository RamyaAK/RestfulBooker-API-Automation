package entities;

import client.restfulBooker.authenticateUser.AuthResponse;
import properties.API_Properties;
import utilities.RestUtils;

public class UserDetails {
    private String firstName;
    private String lastName;
    private String token;

    API_Properties api_properties = new API_Properties();
    AuthResponse authResponse = new AuthResponse();
    RestUtils restUtils = new RestUtils();

    public void setFirstName(String firstName) {
        this.firstName = restUtils.getFirstName();
    }

    public void setLastName(String lastName) {
        this.lastName = restUtils.getLastName();
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getToken() {
        return token;
    }
}
