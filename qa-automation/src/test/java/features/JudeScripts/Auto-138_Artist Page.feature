#Author: Kevin McGowan
 Feature: Auto-138 Artist Page

	Scenario Outline: Title of your scenario
    Given <userType> navigates to the <iwcPage> page
    And <userType> accepts terms of use
    And <userType> logs in with <username> and <password>
    Then the <iwcPage> page is displayed
    #And there are no broken links on the page
    When <userType> navigates to the <iwcPage2> page
    Then the <iwcPage2> page is displayed
		When <userType> navigates to an artist store page <artistId>
   	Then the artist store page <artistId> is displayed
   
    Examples: 
      | username                | password   | userType | artistId | iwcPage | artistId | iwcPage2 | iwcPage3|
      | kevin.m@stackunited.com | P123456789 | member   |   138463 | home    |   138463 | Artists  | Store|
