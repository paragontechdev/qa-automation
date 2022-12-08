#Author: Kevin McGowan
Feature: Add Item to Wishlist

	@demo
	Scenario Outline: Add Item to Wishlist
    Given user navigates to IWC home page
    When member accepts terms of use
    And user submits IWC username<username> and password<password>
    Then the IWC home page is displayed
    When user adds item <itemId> to wishlist
    Then item <itemId> is displayed in user wishlist

    Examples: 
      | username                | password   | itemId  |
      | kevin.m@stackunited.com | P123456789 | 3128469 |
