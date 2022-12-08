#Author: Kevin McGowan
Feature: [All Queues] Studio Identification and Content Overview Update

  Background: 
    Given user has access to the CRP Review Dashboard

  Scenario Outline: 
    When user navigates to the <queueContent> Review Queue
    And the Reviewer clicks 'Store Name'
    Then The Reviewers browser will open the respective Admin panel in a new tab
		
  Scenario Outline: 
    When user navigates to the <queueContent> Review Queue
    And the Reviewer clicks 'Studio Name'
    Then The Reviewers browser will open the respective Admin panel in a new tab
  
  Examples:
  		| queueContent |
      | image        |
      
      