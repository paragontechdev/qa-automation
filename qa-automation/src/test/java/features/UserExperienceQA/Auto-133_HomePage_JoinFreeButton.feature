#Author: Kevin McGowan
Feature: Auto-133 Home Page: Join Free! Button

  Background: 
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
    When the guest clicks the "Join Free!" link
    Then the Join Now modals are displayed

  Scenario: Home Page: Join Free! Button (Fan)
    When the guest clicks the Join Now button on the fan modal
    Then the member account creation form is displayed

  Scenario: Home Page: Join Free! Button (Artist)
    When the guest clicks the Join Now button on the artist modal
    Then the artist account creation form is displayed
