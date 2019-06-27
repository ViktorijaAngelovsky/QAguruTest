Feature: Testing reservation with GET

  Scenario: New reservation creation test

    Given reservation data:
      | name     | Viktorija  |
      | surname  | Angelovska |
      | afrom    | RIX        |
      | ato      | SVO        |
      | bugs     | 1          |
      | discount | R3B5       |
      | children | 0          |
      | flight   | 15         |
      | adults   | 1          |
      | seat     | 7          |

    When fill reservation form and close browser
    And we are requesting data


    Then we check reservation presence and info

