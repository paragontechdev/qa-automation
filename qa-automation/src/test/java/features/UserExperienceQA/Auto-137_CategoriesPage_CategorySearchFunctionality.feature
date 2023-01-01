#Author: Kevin McGowan
Feature: Auto-137 Categories Page: Category Search Functionality

  Scenario: Categories Page: Category Search Functionality
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest navigates to the "Categories" page
    Then the "Categories" page is displayed
    When the guest searches for a fetish category
    Then categories that contain the search term are displayed 

 