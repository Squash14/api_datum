package datum.test;

import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RegisterTest  extends BaseTest {

    private static final String LOGIN_FAIL = "/register";
    private static final String LOGIN_USER = "/login";

    @Test
    public void testLoginFail() {
        given().
                body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"\" }").
        when().
                post(LOGIN_USER).
        then().
                body("error", is("Missing password"));

    }

    @Test
    public void testLogin() {
        given().
                body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }").
        when().
                post(LOGIN_FAIL).
        then().
                statusCode(HttpStatus.SC_OK).
                body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
