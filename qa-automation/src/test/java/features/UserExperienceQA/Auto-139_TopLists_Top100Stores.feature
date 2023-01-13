#Author: Kevin McGowan
Feature: Auto-139 Top Lists: Top 100 Stores

	@userexperience @toplists
  Scenario: Top Lists: Top 100 Stores
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the user navigates to the "Top Lists" page
    Then the "Top Lists" page is displayed
    When the user clicks "Show all 100 Top Stores"
    Then the top 100 stores are displayed
    When the user clicks a random top 100 store
    Then the correct store page is displayed
