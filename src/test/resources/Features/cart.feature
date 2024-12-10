Feature: Feature to check whather user can place an order


Background: 
    Given user is on login pop up for testing cart
    When user enters valid credentials "user1010" and "pass1" for testing cart
    And click on login button for testing cart
    Then User is navigated to the home page for testing cart
    
    
  Scenario: Place an order from cart page after adding the product to cart
    Given User clicks on cart form nav bar
    And Clicks on place an order
    When pop up appeares and user inserts all the inputs
    And clicks on purchase button
    Then Another pop up will be appeared for successful purchase
    
