package api.items.starwars;

import api.helpers.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class StarwarsHero {
    String films;
    String results;
    String name;
    String height;
    String mass;
    String hair_color;
    String skin_color;
    String eye_color;
    String birth_year;
    String gender;
    String homeworld;
    private Response response;
    private RequestSpecification request;

    @Before
    public void setup() throws IOException {
        request = RestAssured.given();
        try {
            response = request.get(Resources.getEnvValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void JsonArrayToList() {
        String responseString = response.asString();
        JsonPath jspath = new JsonPath(responseString);

        List <String> all_films = jspath.get("results[0].films");
        System.out.println("all_films" + all_films);

        String selected_filmS = jspath.get("results[0].films[0]");
        System.out.println("selected filmS: " + selected_filmS);

    }

    @Test
    public void JsonArrayToString() {
        List <Map <String, String>> allHeroList = response.jsonPath().getList("results");
        System.out.println("Starwars hero as String " + allHeroList.toString());
    }

    @Test
    public void JsonArrayAsStringToListOfHeroByName() {
        List <Map <String, String>> allHeroList = response.jsonPath().getList("results");
        for (Map <String, String> hero : allHeroList) {
            System.out.println("Hero: " + hero.get("name") + " has the Homeworld: " + hero.get("homeworld"));
        }
    }


    @Test
    public void JsonArrayToListAndOutput1stHero_homeworld() {
        List <Map <String, String>> companies = response.jsonPath().getList("results");
        System.out.println(companies.get(1).get("homeworld"));
    }

    @Test
    public void JsonArrayToListAndOutput1stHero_films() {
        List <Map <String, String>> companies = response.jsonPath().getList("results");
        System.out.println(companies.get(1).get("homeworld"));
    }

    @Test
    public void JsonArrayToListAndOutputSomePeopleParameters() {
        List <Map <String, String>> companies = response.jsonPath().getList("results");
        System.out.println("This is a list of companies: ");
        for (Map <String, String> nxtComp : companies) {
            System.out.println(nxtComp.get("name") + " " + nxtComp.get("height") + " " + nxtComp.get("mass") + " " + nxtComp.get("homeworld"));
        }
    }


    @Test
    public void getValueOfSubListValue() {
        /*results [10]
            |-name(String)
            |-height (int)
            |-mass (int)
            |-hair_color (String)
            |-skin_color (String)
            |-eye_color (String)
            |-birth_year (String)
            |-gender (String)
            |-homeworld (String - URL)
            |-created (String)
            |-edited (String)
            |-url (String)
            |--films (List)
            |   |
            |   |-ArrayList<String>
            |--species (List)
            |   |-ArrayList<String>
            |--vehicles (List)
            |   |-ArrayList<String>
            |--starships (List)
            |   |-ArrayList<String>
            |--species (List)
            |   |-ArrayList<String>
            |--species (List)
                |-ArrayList<String>
        */
        ;
        List <Map <String, List <String>>> companies = response.jsonPath().getList("results");
        System.out.println(companies.get(1).get("name"));

    }

}
