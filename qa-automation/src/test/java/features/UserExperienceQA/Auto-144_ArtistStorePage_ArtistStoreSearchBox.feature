#Author: Kevin McGowan
Feature: Auto-144 Artist Store Page: Artist Store Search Box

  Background: 
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
    When the guest navigates to the "Artists" page
    Then the "Artists" page is displayed

  Scenario Outline: Artist Page
    When the guest navigates to a random artist store page
    Then the correct store page is displayed
		When the guest selects My Content filter item
		Then results how items tagged with filter selected
