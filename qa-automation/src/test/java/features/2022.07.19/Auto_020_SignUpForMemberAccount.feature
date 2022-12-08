#Author: Kevin McGowan
Feature: Sign Up For Member Account

  Scenario Outline: Sign Up For Member Account
    Given user navigates to IWC home page
    When member accepts terms of use
    When user clicks join button
    And user selects to join as a fan
    Then the fan signup form is displayed
    When user submits signup form
    Then new user account is created

    Examples: 
      | accountType | username | gender | month   | day | year | email                   | password   | question                     | answer | country |
      | fan         | kevinm   | Male   | March   |  02 | 2002 | kevin.m@stackunites.com | P123456789 | What is your favorite color? | Red   | Guyana  |
