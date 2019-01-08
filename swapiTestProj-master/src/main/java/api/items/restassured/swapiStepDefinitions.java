package api.items.restassured;

//import com.sun.xml.internal.xsom.impl.scd.Iterators;

import api.helpers.Resources;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.StringContains.containsString;

public class swapiStepDefinitions {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    String URL_HERO_BY_NUMBER;

    {
        try {
            URL_HERO_BY_NUMBER = Resources.getReplacer("URL_HERO_BY_NUMBER");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    private String ENDPOINT_HERO_DESCRIPTION_BY_NUMBER = "https://swapi.co/api/people/22";

    @Given("Current hero's")
    public void current_hero_exist_and_has_number()
    {
        request = given();
    }

    @When("I get information about current hero")
    public void i_get_information_about_curent_hero()  {
        response = request.when().get(URL_HERO_BY_NUMBER);
        System.out.println("response: " + response.prettyPrint());

    }

    @Then("Current hero exists and the status code is (\\d+)")
    public void current_hero_exists_and_the_status_code_is_200(int status_code) {
        json = response.then().statusCode(status_code);

    }

    @And("I check name and hero's skin_color")
    public void i_check_hero_skin_color(Map <String, String> responseFields) {

        for (Map.Entry <String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @And("I check that current hero has gender, eye_color and height")
    public void current_hero_has_number_gender_height(Map <String, String> responseFields) {
        for (Map.Entry <String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                json.body(field.getKey(), containsString((field.getValue())));
            } else {
                json.body(field.getKey(), containsString((field.getValue())));
            }
        }

    }

    @And("Hero has a homeworld")
    public void current_hero_has_homeworld(Map <String, String> responseFields) {
        for (Map.Entry <String, String> field : responseFields.entrySet()) {
            json.body(field.getKey(), equalTo((field.getValue())));
        }
    }

    @And("Hero is navigated the starship that was created")
    public void Hero_check_the_starship(Map <String, String> responseFields) {
        for (Map.Entry <String, String> field : responseFields.entrySet()) {
            json.body(field.getKey(), equalTo((field.getValue())));
        }
    }

    @And("Hero has a film1")
    public void current_hero_has_film1(Map <String, String> responseFields) {

        for (Map.Entry <String, String> field : responseFields.entrySet()) {
            json.body(field.getKey(), equalTo((field.getValue())));
        }
    }


    @And("Hero has a films")
    public void Hero_has_a_films(List <List <String>> responseFields) {
        int i = 0;
        for (List <String> next : responseFields) {
            for (String field : next) {
                String films_temp = "films[" + i + "]";
                json.body(films_temp, containsString((field)));
                i++;
            }
        }
    }

    @And("test2")
    public void test22() throws IOException {
        String REFERENCE_FILMS_URL = Resources.getReplacer("REFERENCE_FILMS_URL");
        json.body("films[0]", equalTo(REFERENCE_FILMS_URL));

    }

}
