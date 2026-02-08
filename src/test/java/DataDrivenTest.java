import data.DataForTests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class DataDrivenTest extends DataForTests {




        @Test(dataProvider = "post_data")
        void post_test(String name, String author, int subjectId){

            JSONObject obj = new JSONObject();
            obj.put("name", name);
            obj.put("author", author);
            obj.put("subjectId", subjectId);
            baseURI = "http://localhost:3000";
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


    @Test(dataProvider = "delete_data")
    void delete_test(int userId){
         baseURI = "http://localhost:3000";
        given()
                .delete("/users/"+userId)
                .then()
                .statusCode(200)
                .log().all();
    }
    }


