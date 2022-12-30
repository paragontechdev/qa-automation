#Author: Kevin McGowan
Feature: Auto-139 Top Lists: Top 100 Stores

  Scenario Outline: Top Lists: Top 100 Stores
    Given a user navigates to the "Home" page
    And the user accepts terms of use
    #And the user logs in with <username> and <password>
    #Then the "Home" page is displayed
    #And there are no broken links on the page
    When the user navigates to the "Top Lists" page
    Then the "Top Lists" page is displayed
    When the user clicks link "Show all 100 Top Items"
    Then the top 100 stores are displayed
    When the user clicks any artist profile image
    Then the random artist store page is displayed

    Examples: 
      | username                | password   |
      | kevin.m@stackunited.com | P123456789 |
