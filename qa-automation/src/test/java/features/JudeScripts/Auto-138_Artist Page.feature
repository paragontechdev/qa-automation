#Author: Kevin McGowan

Feature: Auto-138 Artist Page

  Scenario Outline: Title of your scenario
    Given user<userType> navigates to IWC home page
    When user<userType> accepts terms of use
    And user<userType> submits IWC username<username> and password<password>
    Then the IWC home page is displayed
    #verify artist images are correctly displayed
    When user<userType> navigates to the Artists page
    Then the IWC Artists page is displayed
    When user<userType> navigates to an artist<artistId> store page
    Then the Artist<artistId> store page is displayed

    Examples: 
      | username                | password   | userType | artistId |
      | kevin.m@stackunited.com | P123456789 | member   |   138463 |
		