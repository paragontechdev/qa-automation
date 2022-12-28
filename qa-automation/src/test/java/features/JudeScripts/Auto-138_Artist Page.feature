#Author: Kevin McGowan
Feature: Auto-138 Artist Page

  Scenario Outline: Artist Page
    Given a member navigates to the "Home" page
    And the member accepts terms of use
    And the member logs in with <username> and <password>
    Then the "Home" page is displayed
    #And there are no broken links on the page
    When the member navigates to the "Artists" page
    Then the "Artists" page is displayed
    When the member navigates to an artist store page <artistId>
    Then the artist store page <artistId> is displayed

    Examples: 
      | username                | password   | artistId |
      | kevin.m@stackunited.com | P123456789 |   138463 |
