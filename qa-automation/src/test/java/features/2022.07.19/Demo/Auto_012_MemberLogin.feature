#Author: Kevin McGowan
Feature: Member Login

  @demo
  Scenario Outline: Member Login
    Given a member navigates to IWC home page
    When member accepts terms of use
    And user submits IWC username<username> and password<password>
    Then the IWC home page is displayed

    Examples: 
      | username                | password   |
      | kevin.m@stackunited.com | P123456789 |
