$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("people.feature");
formatter.feature({
  "line": 1,
  "name": "Get description of 1st hero of the Star Wars world",
  "description": "",
  "id": "get-description-of-1st-hero-of-the-star-wars-world",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "I check the parameters of 22nd hero",
  "description": "",
  "id": "get-description-of-1st-hero-of-the-star-wars-world;i-check-the-parameters-of-22nd-hero",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Current hero\u0027s",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I get information about current hero",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Current hero exists and the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I check name and hero\u0027s skin_color",
  "rows": [
    {
      "cells": [
        "name",
        "Boba Fett"
      ],
      "line": 9
    },
    {
      "cells": [
        "skin_color",
        "fair"
      ],
      "line": 10
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I check that current hero has gender, eye_color and height",
  "rows": [
    {
      "cells": [
        "gender",
        "male"
      ],
      "line": 13
    },
    {
      "cells": [
        "eye_color",
        "brown"
      ],
      "line": 14
    },
    {
      "cells": [
        "height",
        "183"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Hero has a homeworld",
  "rows": [
    {
      "cells": [
        "homeworld",
        "https://swapi.co/api/planets/10/"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Hero is navigated the starship that was created",
  "rows": [
    {
      "cells": [
        "created",
        "2014-12-15T12:49:32.457000Z"
      ],
      "line": 21
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Hero has a film1",
  "rows": [
    {
      "cells": [
        "films[0]",
        "https://swapi.co/api/films/2/"
      ],
      "line": 24
    },
    {
      "cells": [
        "films[1]",
        "https://swapi.co/api/films/5/"
      ],
      "line": 25
    },
    {
      "cells": [
        "films[2]",
        "https://swapi.co/api/films/3/"
      ],
      "line": 26
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "Hero has a films",
  "rows": [
    {
      "cells": [
        "https://swapi.co/api/films/2/"
      ],
      "line": 29
    },
    {
      "cells": [
        "https://swapi.co/api/films/5/"
      ],
      "line": 30
    },
    {
      "cells": [
        "https://swapi.co/api/films/3/"
      ],
      "line": 31
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "test2",
  "keyword": "And "
});
formatter.match({
  "location": "swapiStepDefinitions.current_hero_exist_and_has_number()"
});
formatter.result({
  "duration": 1483878195,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.i_get_information_about_curent_hero()"
});
formatter.result({
  "duration": 3922486377,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 43
    }
  ],
  "location": "swapiStepDefinitions.current_hero_exists_and_the_status_code_is_200(int)"
});
formatter.result({
  "duration": 96655380,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.i_check_hero_skin_color(String,String\u003e)"
});
formatter.result({
  "duration": 1323747249,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.current_hero_has_number_gender_height(String,String\u003e)"
});
formatter.result({
  "duration": 73568632,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.current_hero_has_homeworld(String,String\u003e)"
});
formatter.result({
  "duration": 34292327,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.Hero_check_the_starship(String,String\u003e)"
});
formatter.result({
  "duration": 17305149,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.current_hero_has_film1(String,String\u003e)"
});
formatter.result({
  "duration": 71032181,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.Hero_has_a_films(String\u003e\u003e)"
});
formatter.result({
  "duration": 77309599,
  "status": "passed"
});
formatter.match({
  "location": "swapiStepDefinitions.test22()"
});
formatter.result({
  "duration": 19468581,
  "status": "passed"
});
});