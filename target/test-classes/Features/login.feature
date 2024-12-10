Feature: Feature to test login functionality

  @smoketest
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login pop up
    When user enters valid <username> and valid <password>
    And clicks on login button
    Then <username> is navigated to the home page

    Examples: 
      | username | password |
      | user1010 | pass1    |

  Scenario Outline: Check login is successful with valid username and invalid password
    Given user is on login pop up
    When user enters valid <username> and invalid <password>
    And clicks on login button
    Then user will still be inside the login pop up with wrong password

    Examples: 
      | username | password |
      | user1010 | pass11   |

  Scenario Outline: Check login is successful with invalid username and valid password
    Given user is on login pop up
    When user enters invalid <username> and valid <password>
    And clicks on login button
    Then user will still be inside the login pop up with invalid username

    Examples: 
      | username  | password |
      | user10101 | pass1    |

  Scenario Outline: Check login is successful with invalid username and invalid password
    Given user is on login pop up
    When user enters invalid <username> and invalid <password>
    And clicks on login button
    Then user will still be inside the login pop up with both invalid username and password

    Examples: 
      | username  | password |
      | user10101 | pass12   |
