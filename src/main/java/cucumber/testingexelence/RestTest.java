package cucumber.testingexelence;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestTest {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();

    }

    public static void main(String[] args) {
        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");

        //System.out.println("response: " + response.prettyPrint());
        List<String> jsonResponse = response.jsonPath().getList("$");

        //In the above example, if we wanted to get the username of all entries, we could use
        System.out.println(jsonResponse.size());
        String usernames = response.jsonPath().getString("username");
        System.out.println(usernames);

        //If we then want to get the username of the first entry we could use
        //usernames = response.jsonPath().getString("username[0]");
        jsonResponse = response.jsonPath().getList("username");
        System.out.println(jsonResponse.get(0));

        response = doGetRequest("https://jsonplaceholder.typicode.com/users/1");

        Map<String, String> company = response.jsonPath().getMap("company");
        System.out.println(company.get("name"));

        //alternativly
        response = doGetRequest("https://jsonplaceholder.typicode.com/users/");

        List<Map<String, String>> companies = response.jsonPath().getList("company");
        System.out.println(companies.get(1).get("name"));

    }
}