#Author: Kevin McGowan

Feature: Auto-138 Artist Page

  Scenario Outline: Title of your scenario
    Given <userType> navigates to IWC home page
    And <userType> accepts terms of use
    And <userType> logs in with <username> and <password>
    Then the <iwcPage> page is displayed

    Examples: 
      | username                | password   | userType | artistId | iwcPage |
      | kevin.m@stackunited.com | P123456789 | member   |   138463 | home    |

  Scenario Outline: 
    #Given artist images are correctly displayed
    When <userType> navigates to the Artists page
    Then the Artists <iwcPage> page is displayed

    Examples: 
      | userType | artistId | iwcPage |
      | member   |   138463 | artists |

  Scenario Outline: 
    When user navigates to an artist<artistId> store page
    Then the Artist<artistId> store page is displayed
