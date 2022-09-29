package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    String generatedString = RandomStringUtils.randomAlphabetic(1);

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName + generatedString;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName + generatedString;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
