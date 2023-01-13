#Author: Kevin McGowan
Feature: Auto-136 Categories Page: Category Links

	@userexperience @categoriespage
  Scenario: Auto-136 Categories Page: Category Links
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
   	When the guest navigates to the "Categories" page
    Then the "Categories" page is displayed
    And the guest verfies all "Categories" page links navigate to the correct page

 