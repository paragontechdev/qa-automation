#Author: Kevin McGowan
Feature: Tribute Artist as Member

  Scenario Outline: Tribute Artist as Member
    Given user<userType> navigates to Artist<artistId> store
    And user accepts terms of use
    And artist submits IWC username and password
    When user<userType> tributes <amount> dollars
    Then tribute<amount> has been sent
		And a purchase confirmation message is displayed
	
    Examples: 
      | username                | password   | userType | artistId | amount |
      | kevin.m@stackunited.com | P123456789 | member   |    37895 |    250 |
