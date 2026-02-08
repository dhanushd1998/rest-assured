import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class LocalAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }
    @Test
void get_test(){
    given()
            .param("user", "Meghana")
            .get("/users")
            .then()
            .statusCode(200)
            .log().all();
}

@Test
void post_test(){

        JSONObject obj = new JSONObject();
        obj.put("name", "Disha");
        obj.put("author", "QA");
    obj.put("subjectId", 2);
    given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(obj.toJSONString())
            .when()
            .post("/users")
            .then()
            .statusCode(201)
            .log().all();

}

@Test
void put_test(){
        JSONObject obj = new JSONObject();
        obj.put("name", "Karan");
    obj.put("subjectId", 3);
    obj.put("author", "Testing");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200)
                .log().all();

}

@Test
void delete_test(){
        given()
    .delete("/users/6")
                .then()
                .statusCode(200)
                .log().all();
}
}

