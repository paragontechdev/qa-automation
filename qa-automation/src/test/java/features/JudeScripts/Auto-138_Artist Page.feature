#Author: Kevin McGowan
Feature: Auto-138 Artist Page

  Scenario Outline: Title of your scenario
    Given user navigates to IWC home page
    When user accepts terms of use
    And user submits IWC username<username> and password<password>
    Then the IWC home page is displayed
    #And verify artist images are correctly displayed
    When user navigates to the Artists page
    #Then the IWC Artists page is displayed
    When user navigates to an artist<artistId> store page
    Then the Artist<artistId> store page is displayed

    Examples: 
      | username                | password   | userType | artistId |
      | kevin.m@stackunited.com | P123456789 | member   |   138463 |
