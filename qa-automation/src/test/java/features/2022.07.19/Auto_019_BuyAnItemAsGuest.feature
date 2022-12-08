#Author: Kevin McGowan
Feature: Buy an Item as a Guest

  Scenario Outline: Buy an Item as a Guest
    Given user<userType> navigates to Artist<artistId> store
    And member accepts terms of use
    When user adds an item<itemId> to their shopping cart
    And user<userType> checks out
    Then a purchase confirmation message is displayed

    Examples: 
      | userType | artistId | itemId  |
      | guest    |   138463 | 3354183 |
