#Author: Kevin McGowan
Feature: Auto-132 Home Page: Newest Content Section
  
  @userexperience @homepage
  Scenario: Auto-132 Home Page: Newest Content Section
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
		And the guest clicks on Newest Content section link
		Then the correct store page is displayed