#Author: Kevin McGowan
Feature: [Message Center] Add Column in Messages Needing Review Queue

  Background: 
    Given user has access to the CRP Review Dashboard
  
  Scenario: 
    When user navigates to the <queueContent> Review Queue
    And A Message Attachment needs review
    Then The type of message (Single, Group/ALL) will display in the 'Recipients' column.
