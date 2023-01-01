#Author: Kevin McGowan
Feature: Auto-138 Artist Page

  Scenario Outline: Artist Page
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest navigates to the "Artists" page
    Then the "Artists" page is displayed
    When the guest navigates to an artist store page <artistId>
    Then the artist store page <artistId> is displayed

    Examples: 
      | artistId |
      |   138463 |
