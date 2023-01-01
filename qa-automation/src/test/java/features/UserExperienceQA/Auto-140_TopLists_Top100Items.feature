#Author: Kevin McGowan
Feature: Auto-140 Top Lists: Top 100 Items

  Scenario: Top Lists: Top 100 Items
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the user navigates to the "Top Lists" page
    Then the "Top Lists" page is displayed
    When the user clicks the "Show all 100 Top Items" link
    Then the top 100 items are displayed
    When the user clicks a random top 100 item
    Then the random item page is displayed