Feature: Create some items and modify them

  Scenario: I create, delete several items and invoke parameters and work with them.
    Given I add next items
      |first_name|last_name |staff_position|
      |Wonderr    | Woman    | hero         |
      |Boba      | Fett     | actor        |
      |Luke      | Skywalker| actor        |

    And I check the DB and it contains 3 items and statusCode is 200
    And I check that 1 hero has name and it has positon
      | Wonder | Woman | hero |
    When I delete 1 and 2 item from DB
    Then I check that DB contains only 1 item
    And This item has name and position
      | Luke | Skywalker | actor |



