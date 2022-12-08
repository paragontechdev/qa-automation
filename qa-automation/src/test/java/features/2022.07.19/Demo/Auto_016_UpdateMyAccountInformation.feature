#Author: Kevin McGowan
Feature: Update My Account Information

  @demo
  Scenario Outline: Update My Account Information
    Given user navigates to IWC home page
    When member accepts terms of use
    And user submits IWC username<username> and password<password>
    Then the IWC home page is displayed
    When user navigates to IWC sub page <page>
    And user updates account information from <oldValue> to <newValue>
    Then updated account information is saved

    Examples: 
      | username                | password   | page       | oldValue   | newValue   |
      | kevin.m@stackunited.com | P123456789 | My Account | P123456789 | P123456789 |
      | kevin.m@stackunited.com | P123456789 | My Account | P12345     | P123456789 |
