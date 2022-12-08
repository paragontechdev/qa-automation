#Author: Kevin McGowan
Feature: Tribute Artist as Guest

  Scenario Outline: Tribute Artist as Guest
    Given user<userType> navigates to Artist<artistId> store
    And user accepts terms of use
    When And artist submits IWC username and password
		Then tribute<amount> has been sent
		And a purchase confirmation message is displayed
		
    Examples: 
      | userType | artistId | amount |
      | guest    |    37895 |    250 |
