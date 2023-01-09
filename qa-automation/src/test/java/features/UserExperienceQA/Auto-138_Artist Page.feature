#Author: Kevin McGowan
Feature: Auto-138 Artist Page

  Background: 
    Given a guest navigates to the "Home" page
    And the guest accepts terms of use
    When the guest navigates to the "Artists" page
    Then the "Artists" page is displayed

#  Scenario Outline: Artist Page
#    When the guest navigates to an artist store page <artistId>
#    Then the artist store page <artistId> is displayed

#    Examples: 
#      | artistId |
#      |   138463 |

#  Scenario: Artist Page
#    When the guest navigates to a random artist store page
#    Then the correct store page is displayed
#
  Scenario: Artist Page
    And the guest verfies 10 "Artists" page links navigate to the correct page
  