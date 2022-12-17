#Author: Kevin McGowan
Feature: Auto-138 Artist Page

  Scenario Outline: Title of your scenario
    Given <userType> navigates to IWC home page
    And <userType> accepts terms of use
    When <userType> logs in with <username> and <password>
    Then the <iwcPage> page is displayed
    #And artist images are correctly displayed
    When user navigates to the Artists page
    #Then the IWC Artists page is displayed
    When user navigates to an artist<artistId> store page
    Then the Artist<artistId> store page is displayed

    Examples: 
      | username                | password   | userType | artistId |
      | kevin.m@stackunited.com | P123456789 | member   |   138463 |
