Feature: Content Queues Keywords Identification

  Background: 
    Given user has access to the CRP Review Dashboard

  Scenario Outline: 
    When user navigates to the <queueContent> Review Queue
    And user clicks the Review button
    Then the <queueContent> Review History page is opened
    And Content Overview section contains <heading>

    Examples: 
      | queueContent | heading    |
      | Image        | Keywords		|
      | Document     | Keywords		|
      | Video        | Keywords		|