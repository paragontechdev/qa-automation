#Author: Kevin McGowan
Feature: Add Artists To My Favorites

	@demo
  Scenario Outline: Add Artists To My Favorites
    Given user navigates to IWC home page
    When member accepts terms of use
    And user submits IWC username<username> and password<password>
    Then the IWC home page is displayed
    When user navigates to Artists page
    And user navigates to artist store <artistId>
    #And user adds artist <artistId> to their favorites
    #Then artist <artistId> is displayed in user favorites

    Examples: 
      | username                | password   | artistId |
      | kevin.m@stackunited.com | P123456789 |   800302 |
