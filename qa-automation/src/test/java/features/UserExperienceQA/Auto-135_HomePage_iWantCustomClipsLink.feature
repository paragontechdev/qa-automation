#Author: Kevin McGowan
Feature: Home Page: iWantCustomClips Link

  Scenario: Home Page: iWantCustomClips Link
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest clicks the "iWant Custom Clips" link
    Then the "Custom Clip Stores" page is displayed
    
 