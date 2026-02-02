import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class APITests {
    @Test
    public void testAPI1() {
       Response response = given()
           .header("x-api-key", "reqres_3bf9d9b1de804d7c8c07cd0f095e9090")
           .when()
           .get("https://reqres.in/api/users/2");

       System.out.println("API Test case 1 STATUS CODE: " + response.getStatusCode());
       System.out.println("API Test case 1 RESPONSE: " + response.asString());
       System.out.println("API Test case 1 BODY: " + response.getBody().asString());
       System.out.println("API Test case 1 TIME TAKEN: " + response.getTime());
       System.out.println("API Test case 1 HEADER Content-Type: " + response.getHeader("Content-Type"));
       int statusCode = response.getStatusCode();
       Assert.assertEquals(statusCode, 200, "Expected HTTP status 200");
    }

    @Test
     public void testAPI2() {
        given()
                .header("x-api-key", "reqres_3bf9d9b1de804d7c8c07cd0f095e9090")
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data[4].first_name",equalTo("George"))
                .body("data.first_name", hasItems("Michael", "Tobias"))
                .log().all();
    }
    @Test
    public void post_demo1() {
        JSONObject obj = new JSONObject();
        obj.put("first_name", "dhanush");

        given()
                .header("x-api-key", "reqres_3bf9d9b1de804d7c8c07cd0f095e9090")
                .contentType(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }
    @Test
    void put_demo2(){
        JSONObject obj = new JSONObject();
        obj.put("first_name", "meghana");
        obj.put("last_name", "dhanush");
        given()
                .header("x-api-key", "reqres_3bf9d9b1de804d7c8c07cd0f095e9090")
                .contentType(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    void patch_demo2(){
        JSONObject obj = new JSONObject();
        obj.put("first_name", "meghana");
        obj.put("last_name", "dhanush");
        given()
                .header("x-api-key", "reqres_3bf9d9b1de804d7c8c07cd0f095e9090")
                .contentType(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);

    }
    @Test
    void delete_demo2(){
        given()
                .header("x-api-key", "reqres_3bf9d9b1de804d7c8c07cd0f095e9090")
                .when()
                .delete("https://reqres.in/api/users/1")
                .then()
                .statusCode(204)
                .log().all();

    }


}
