#Author: Kevin McGowan
Feature: Member Buying Item With Existing Funds

  Scenario Outline: Member Buying Item With Existing Funds
    Given user navigates to IWC home page
    When user accepts terms of use
    And artist submits IWC username<username> and password<password>
    When user<userType> navigates to Artist<artistId> store
    And user adds an item<itemId> to their shopping cart
    And user<userType> checks out
    Then a purchase confirmation message is displayed

    Examples: 
      | username                | password   | userType | artistId | itemId  |
      | kevin.m@stackunited.com | P123456789 | member   |   138463 | 3354183 |
