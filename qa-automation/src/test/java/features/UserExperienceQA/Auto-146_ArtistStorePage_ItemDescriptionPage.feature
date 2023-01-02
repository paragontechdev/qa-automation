#Author: Kevin McGowan
Feature: Auto-146 Artist Store Page: Item Description Page

  Scenario: Artist Store Page: Item Description Page
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest navigates to the "Artists" page
    Then the "Artists" page is displayed
    When the guest selects a random artist
    And the guest selects a random store item
    Then the item description page is displayed
