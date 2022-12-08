#Author: Kevin McGowan
Feature: CRP Review Approval

  Background: 
    Given I have access to CRP Review Dashboard

  Scenario Outline: CRP Document Review Approval
    When I navigate to <type> Review Queue
    And I open the page https://dev.admin.iwantglobal.com/review/<queue>
    And I choose a <type> on top of the list
    And user clicks the Review button
    Then <type> review page opened
    When I click Approved radio button
    # And I click Save blue button
    Then Current Status is <status>

    Examples: 
      | type     | status        | queue      |
      | Document | 1 - In Review | docqueue   |
      | Image    | 1 - In Review | imagequeue |
      | Video    | 1 - In Review | videoqueue |
