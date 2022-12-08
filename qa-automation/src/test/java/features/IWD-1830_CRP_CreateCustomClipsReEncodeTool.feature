#Author: Kevin McGowan
Feature: [CRP] Create Custom Clips Re-Encode Tool

  Background: 
    Given user has access to the CRP Review Dashboard
	
  Scenario: 
    And A file is not playable
    When The reviewer adds a Custom Clip Order # to be re-encoded
    And Clicks Submit
    Then The file will be re-encoded into an H.264 .MP4
