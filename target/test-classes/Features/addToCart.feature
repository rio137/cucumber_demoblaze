Feature: Feature to test add to cart functionality

  Background: 
    Given user is on login pop up for each steps
    When user enters valid credentials "user1010" and "pass1"
    And click on login button
    Then User is navigated to the home page for add to cart

  Scenario Outline: Add a product to the cart after successful login
    When scroll down
    And clicks on a product <productNumber>
    And clicks on add to cart button
    Then there will be a pop up that product added

    Examples: 
      | productNumber |
      |             0 |
      |             1 |

