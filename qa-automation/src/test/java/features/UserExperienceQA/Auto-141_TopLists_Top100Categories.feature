#Author: Kevin McGowan
Feature: Auto-141 Top Lists: Top 100 Categories

	@userexperience @toplists
  Scenario Outline: Top Lists: Top 100 Categories
    Given a user navigates to the "Home" page
    And the user accepts terms of use
    #And the user logs in with <username> and <password>
    #Then the "Home" page is displayed
    #And there are no broken links on the page
    When the user navigates to the "Top Lists" page
    Then the "Top Lists" page is displayed
    When the user clicks "Show all 100 Top Categories"
    Then the top 100 categories are displayed
    When the user clicks a random top 100 category
    Then the correct category page is displayed

    Examples: 
      | username                | password   |
      | kevin.m@stackunited.com | P123456789 |
