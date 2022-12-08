#Author: Kevin McGowan
Feature: Add "Legacy" after "Publish_Date" for Content dated < Oct 15th, 2021

  Background: 
    Given user has access to the CRP Review Dashboard
  
  Scenario:
    When user navigates to the <queueContent> Review Queue
    And user clicks the Review button
    And the uploaded content has a 'Publish_Date' prior to October 15th, 2021
    Then the Reviewer will see 'Legacy' after the date
