#Author: Kevin McGowan
Feature: Auto-139 Top Lists: Top 100 Items

  Scenario Outline: Top Lists: Top 100 Items
    Given a user navigates to the "Home" page
    And the user accepts terms of use
    #And the user logs in with <username> and <password>
    #Then the "Home" page is displayed
    #And there are no broken links on the page
    When the user navigates to the "Top Lists" page
    Then the "Top Lists" page is displayed
    When the user clicks the "Show all 100 Top Items" link
    Then the top 99 items are displayed
    When the user clicks a random top 100 item
    Then the random item page is displayed

    Examples: 
      | username                | password   |
      | kevin.m@stackunited.com | P123456789 |
