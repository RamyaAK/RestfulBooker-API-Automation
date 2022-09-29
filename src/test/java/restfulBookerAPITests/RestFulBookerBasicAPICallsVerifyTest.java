package restfulBookerAPITests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utilities.Categories;
import utilities.RestUtils;

import static io.restassured.RestAssured.given;


public class RestFulBookerBasicAPICallsVerifyTest extends BaseTest{
    @Description("Get All Booking IDs")
    @Test(groups = {Categories.SMOKE})
    @Severity(SeverityLevel.TRIVIAL)
    public String getAllBookingIds() {
        String response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(400)
                .log().all().extract().toString();
        return response;
    }

    @Test(enabled = false, groups = {Categories.SMOKE})
    public void getBookingDetailsByID(int id) {
        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {Categories.SMOKE})
    @Severity(SeverityLevel.MINOR)
    public void createNewBookingTest() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}").when().post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(enabled = false)
    public void updateBookingDetailsTest() {
        given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=542c365639aaa6d")
                .body("{\n" +
                        "    \"firstname\": \"gj\",\n" +
                        "    \"lastname\": \"Krish\",\n" +
                        "    \"totalprice\": 111,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"Breakfast\"\n" +
                        "}")
                .put("https://restful-booker.herokuapp.com/booking/9350")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(enabled = false)
    public void deleteBookingByIdTest() {
        given()
                .header("Content-Type", "applicotion/json")
                .header("Cookie", "token=542c365639aaa6d")
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/9350")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(groups = {Categories.SMOKE})
    @Severity(SeverityLevel.NORMAL)
    public void testRestUtils() {
        RestUtils restUtils = new RestUtils();
        restUtils.setFirstName("john");
        System.out.println(restUtils.getFirstName());
    }
}
