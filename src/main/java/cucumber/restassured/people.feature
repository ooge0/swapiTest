Feature: Get description of 1st hero of the Star Wars world

  Scenario: I check the parameters of 22nd hero
    Given Current hero's
    When I get information about current hero
    Then Current hero exists and the status code is 200
    And I check name and hero's skin_color
      | name       | Boba Fett |
      | skin_color | fair      |

    And I check that current hero has gender, eye_color and height
      | gender    | male  |
      | eye_color | brown |
      | height    | 183   |

    And Hero has a homeworld
      |homeworld| https://swapi.co/api/planets/10/  |

    And Hero is navigated the starship that was created
      | created   | 2014-12-15T12:49:32.457000Z |

    And Hero has a film1
      |films[0]| https://swapi.co/api/films/2/  |
      |films[1]| https://swapi.co/api/films/5/  |
      |films[2]| https://swapi.co/api/films/3/  |

    And Hero has a films
      | https://swapi.co/api/films/2/  |
      | https://swapi.co/api/films/5/  |
      | https://swapi.co/api/films/3/  |
    And test2
