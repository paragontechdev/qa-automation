#Author: Kevin McGowan
Feature: Auto-132 Home Page: Featured Stores Widget
  
  Scenario: Home Page: Featured Stores Widget
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
		And the guest clicks on Featured Stores section link
		Then the correct store page is displayed