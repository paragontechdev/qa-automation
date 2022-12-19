#Author: marina.l@stackunited.com
Feature: Auto-147 IWCC page

  Scenario Outline: IWCC “Top Stores” section leads User to the Custom Store page
    Given user<userType> navigates to IWC home page
    When user<userType> accepts terms of use
    Then the IWC home page is displayed
    When user<userType> navigates to the CustomStore page
    Then the IWCC_HomePage is displayed
    When user<userType> navigates to an artist<artistId> Custom Store page
    Then the Artist<artistId> Custom Store page is displayed

    Examples: 
      | userType |
      | guest    |
