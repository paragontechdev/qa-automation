#Author: Kevin McGowan
Feature: Ability to Input/Update RightSignature link for a Studio/Artist/Sub-store

  Scenario: 
    Given An iWC Admin has access to the iWC Admin page
    And visits a Studio/Artist/Sub-store page
    When An iWC Admin adds a RightSignature URL link on the Admin page
    And clicks 'Save'
    Then The input field with the URL will dissapear
    And a 'RS Link' button
    And an 'Edit' button will appear
