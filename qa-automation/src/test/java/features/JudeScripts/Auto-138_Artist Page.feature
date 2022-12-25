#Author: Kevin McGowan
Feature: Auto-138 Artist Page

  Scenario Outline: Title of your scenario
    Given <userType> navigates to the <iwcPage> page
    And <userType> accepts terms of use
    And <userType> logs in with <username> and <password>
    Then the <iwcPage> page is displayed
    #Given artist images are correctly displayed
    When <userType> navigates to the <iwcPage2> page
    Then the <iwcPage2> page is displayed

    Examples: 
      | username                | password   | userType | artistId | iwcPage | artistId | iwcPage2 |
      | kevin.m@stackunited.com | P123456789 | member   |   138463 | home    |   138463 | Artists  |

   
   # Scenario Outline:

   # When user navigates to an artist<artistId> store page
   # Then the Artist<artistId> store page is displayed
