#Author: Kevin McGowan
Feature: [CRP] Biometric Profile Queue 'Unable to Create' Button

  Background: 
    Given user has access to the CRP Review Dashboard

  Scenario Outline: 
    When user navigates to the <queueContent> Review Queue
    And A reviewer clicks the <link> link in the Biometric Profile Review
    Then The Arist/Sub-store will be hidden from the queue
    And The reviewer will return to the 'Biometric Profile Queue'
    And The Artist/Sub-store will not return to the queue upon a new upload
    And The Biometrics Queue total will be reduced

    Examples: 
      | queueContent      | link             |
      | Biometric Profile | Unable to Create |
			