package cucumber.loopback.work_pack;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import java.security.PublicKey;
import java.util.List;

public class loopback_test {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_STAFF = "http://localhost:3000/api/staffs";

    @Given("^I add next items$")
    public void iAddNextItems(DataTable table) throws Throwable {

        JSONObject requestBody = new JSONObject();
        System.out.println("I create several heroes.");
        //create an ArrayList
        List<Staff> staffs;
        //store all items
        staffs = table.asList(Staff.class);
        //create FOR cycle for each elements of List<Staff>
        for (Staff staff : staffs) {
            requestBody.put("first_name", staff.f_name);
            requestBody.put("last_name", staff.l_name);
            requestBody.put("staff_position", staff.st_position);
            RequestSpecification request = RestAssured.given();
            request.header("Content-Type", "application/json");
            request.body(requestBody.toString());
            io.restassured.response.Response response = request.post("http://localhost:3000/api/staffs");
            //System.out.println("Hero name is : " + staff.f_name + " " + staff.l_name + ". And it has position as: " + staff.st_position);
        }
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    @And("^I check the DB and it contains (\\d+) items and statusCode is (\\d+)$")
    public void i_check_the_DB_and_it_contains_items_and_statusCode_is(int arg1, int arg2) throws Throwable {
        System.out.println("!!!!!!======!!!!!!");
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I check that (\\d+) hero has name and it has positon$")
    public void i_check_that_hero_has_name_and_it_has_positon(int arg1, DataTable arg2) throws Throwable {
        System.out.println("!!!!!!======!!!!!!");
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @When("^I delete (\\d+) and (\\d+) item from DB$")
    public void i_delete_and_item_from_DB(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I check that DB contains only (\\d+) item$")
    public void i_check_that_DB_contains_only_item(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^This item has name and position$")
    public void this_item_has_name_and_position(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @Then("^user open the window$")
    public void userOpenTheWindow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    /*@Test
    public void postRequestExampleItems() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("first_name", "Wonder");
        requestBody.put("last_name", "woman");
        requestBody.put("staff_position", "hero");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        io.restassured.response.Response response = request.post("http://localhost:3000/api/staffs");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Status Code is : " + statusCode);
        System.out.println(response.getBody().asString());

    }*/

    public class Staff {
        public String f_name;
        public String l_name;
        public String st_position;

        Staff (String firstName, String lastName, String staffPosition) {
            l_name = lastName;
            f_name = firstName;
            st_position = staffPosition;
        }
    }

}
