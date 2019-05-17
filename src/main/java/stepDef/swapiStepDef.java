package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class swapiStepDef {


    private Response response;
    private ValidatableResponse validationResponse;
    private RequestSpecification request;
    private String ENDPOINT_HERO_DESCRIPTION_BY_NUMBER = "https://swapi.co/api/people/22";

    @Given("Current hero's")
    public void current_hero_exist_and_has_number() {
        request = given();
    }

    @When("I get information about current hero")
    public void i_get_information_about_curent_hero() {
        response = request.when().get(ENDPOINT_HERO_DESCRIPTION_BY_NUMBER);
    }

    @Then("Current hero exists and the status code is (\\d+)")
    public void current_hero_exists_and_the_status_code_is_200(int status_code) {
        validationResponse = response.then().statusCode(status_code);

    }

    @And("I check name and hero's skin_color")
    public void i_check_hero_skin_color(Map<String, String> responseFields) {

        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                validationResponse.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                validationResponse.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @And("I check that current hero has gender, eye_color and height")
    public void current_hero_has_number_gender_height(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                validationResponse.body(field.getKey(), containsString((field.getValue())));
            } else {
                validationResponse.body(field.getKey(), containsString((field.getValue())));
            }
        }
    }

    @And("Hero has a homeworld")
    public void current_hero_has_homeworld(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            // validationResponse.body(field.getKey(), equalTo((field.getValue())));
            System.out.println("field.getKey: " + field.getKey() + ", field.getValue: " + field.getValue());
        }
    }

    @And("Hero is navigated the starship that was created")
    public void Hero_check_the_starship(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            validationResponse.body(field.getKey(), equalTo((field.getValue())));

        }
    }

    @And("Hero has a film1")
    public void current_hero_has_film1(Map<String, String> responseFields) {

        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            validationResponse.body(field.getKey(), equalTo((field.getValue())));
        }
    }


    @And("Hero has a films")
    public void Hero_has_a_starship(List<List<String>> responseFields) {
        int i = 0;
        for (List<String> next : responseFields) {
            for (String field : next) {
                String films_temp = "films[" + i + "]";
                validationResponse.body(films_temp, containsString((field)));
                i++;
            }
        }
    }

}
