Feature: Student App CRUD Functionality

  Scenario Outline: I can successfully run CRUD operation on Student App API
    When I create a new student record with "<firstName>", "<lastName>", 'email', "<programme>", "<course1>" and "<course2>"
    And  I can read the created record using 'email'
    And update the created record using studentID with PUT request and details "<firstName>" "<lastName>", "<programme>", "<course1>", "<course2>"
    And read updated record using studentID
    And delete newly created record with same studentID
    Then verify that no record can be found using same studentID
    Examples:
      | firstName | lastName | programme        | course1 | course2 |
      | Chetan    | patel    | Computer Science | JAVA    | Ruby    |
      | Sam       | Mandes   | Computer Science | JAVA    | Ruby    |
      | Alan      | Johnson  | Computer Engg    | php     | C#      |

    ## Added first
