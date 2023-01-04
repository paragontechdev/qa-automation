#Author: Kevin McGowan
Feature: Auto-129 Home Page: Top Selling Content
  
  Scenario: Home Page: Top Selling Content
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
		And the guest clicks on Top Selling Content widget image link
		Then the correct store page is displayed
		
