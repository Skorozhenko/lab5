import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MainTest {

    @Test
    public void test1() {
        String s = "{\"id\":11}";

        given().
                contentType("application/json").
                body(s).
                when().
                post("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).
                body("id", equalTo(11));
    }

    @Test
    public void testGet() {
        RestAssured
                .get("https://petstore.swagger.io/v2/pet/11")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", equalTo(11));
    }

    @Test
    public void testGetNotFoundPet() {
        RestAssured
                .get("https://petstore.swagger.io/v2/pet/11")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testPut() {
        String s = "{\"id\":11}";
        given().
                contentType("application/json").
                body(s).
                when().
                put("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).
                body("id", equalTo(11));
    }

    @Test
    public void testPutRequest() {

        String requestBody = "{\"id\": 11, \"name\": \"snake\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("snake"))
                .extract()
                .response();
    }

    @Test
    public void testDeleteRequestError() {

        Response response;
        response = given()
                .when()
                .delete("https://petstore.swagger.io/v2/pet/8")
                .then()
                .statusCode(404)
                .extract()
                .response();
    }
}