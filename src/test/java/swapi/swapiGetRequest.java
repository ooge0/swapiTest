package swapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class swapiGetRequest {

        @BeforeClass
        public void setup () {
            RestAssured.baseURI = "https://swapi.co";
            RestAssured.basePath = "/api/";
        }

        @Test(enabled=true , description = "GET name of the 22nd hero in the list")
        public void getResponseHeroDescriptionByNumber () {
            Response res  =
                    given ()
                            /*
                    .param("name", "Luke Skywalker")
                    .param ("height","172")
                    .param("mass", "77")
                    .param("hair_color", "blond")
                            */
                    .when()
                    .get("/people/22");

            System.out.println(res.body().prettyPrint());

        }
    @Test(enabled=true , description = "check that name of the 22nd hero is Boba Fett")
    public void statusCodeVerification () {

        given ()
                        /*
                .param("name", "Luke Skywalker")
                .param ("height","172")
                .param("mass", "77")
                .param("hair_color", "blond")
                        */
                .when()
                .get("/people/22")
                .then()
                .and ()
                .body("name", equalTo("Boba Fett"))
                .and ()
                .body("gender", equalTo("male"))
                .and()
                .body("films [1]", equalTo("https://swapi.co/api/films/5/"))
                .and()
                .body("url", equalTo("https://swapi.co/api/people/22/"))
                .and()
                .body("starships[0]", equalTo("https://swapi.co/api/starships/21/"))
                        .contentType(ContentType.JSON);


    }




 }

