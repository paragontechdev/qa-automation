#Author: Kevin McGowan
Feature: [IWC] Update Custom Clips Confirmation Pop-up After File is Uploaded

  Scenario: 
    Given The Artist/Sub-store has access to the 'Customs' tab
    And The Artist/Sub-store has a pending Order
    When The Artist/Sub-store uploads a file within the Order
    And The Artist/Sub-store clicks 'Send'
    Then The Artist/Sub-store is notified of their content submission by a pop-up when uploaded
