#Author: Kevin McGowan
Feature: Member Access Want Cloud & Play Content

  Scenario Outline: Member Access Want Cloud & Play Content
    Given user navigates to IWC home page
    And member accepts terms of use
    And artist submits IWC username and password
    And the IWC home page is displayed
    When user navigates to Want Cloud subpage
#   And user selects All Clips tab
#		Then user clicks on a clip
#		And clip is played

    Examples: 
      | username                | password   | page       |
      | kevin.m@stackunited.com | P123456789 | Want Cloud |
