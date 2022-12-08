#Author: Kevin McGowan
Feature: Sign Up For Studio Account

  Scenario Outline: Sign Up For Studio Account
    Given user navigates to IWC home page
    When user accepts terms of use
    When user clicks join button
    And user selects to join as a fan
    Then the fan signup form is displayed
    When user submits signup form
    Then new user account is created

    Examples: 
      | accountType | username | gender | month   | day | year | email                   | password   | question                     | answer | country |
      | studio      | kevinm   | TV     | January |  01 | 2000 | kevin.m@stackunites.com | P123456789 | What is your favorite color? | Green  | Italy   |
