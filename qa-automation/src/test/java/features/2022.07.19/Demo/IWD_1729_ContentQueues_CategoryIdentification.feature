#Author: Kevin McGowan
Feature: [Content Queues] Category Identification

  Background: 
    Given user has access to the CRP Review Dashboard

	Scenario Outline: 
    When user navigates to the <queueContent> Review Queue
    And user clicks the Review button
    Then the <queueContent> Review History page is opened
    Then the Content Overview section contains <heading>

    Examples: 
      | queueContent | heading    | 
      | image        | Categories | 
      | document     | Categories | 
      | video        | Categories | 
