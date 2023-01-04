#Author: Kevin McGowan
Feature: Auto-130 Home Page: Featured Phone Stores Widget
  
  Scenario: Home Page: Featured Phone Stores Widget
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
		And the guest clicks on Featured Phone Stores widget image link
		Then the correct store page is displayed