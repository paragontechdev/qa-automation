#Author: Kevin McGowan
Feature: Auto-135 Home Page: iWantCustomClips Link
	
	@userexperience @homepage
  Scenario: Home Page: iWantCustomClips Link
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest clicks the "iWantCustomClips" link
    Then the "iWantCustomClips" page is displayed
    
 