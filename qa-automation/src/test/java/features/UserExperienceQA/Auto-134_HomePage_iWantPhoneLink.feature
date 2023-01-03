#Author: Kevin McGowan
Feature: Auto-134 Home Page: iWantPhone Link

  Scenario: Home Page: iWantPhone Link
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest clicks the "iWantPhone" link
    Then the "iWantPhone" page is displayed
    
 