#Author: Kevin McGowan
Feature: [CRP] Flagged Content Queue update

  Background: 
    Given user has access to the CRP Review Dashboard

  Scenario Outline: 
    When user navigates to the <queueContent> Review Queue
#    When A Reviewer selects 'Completed (issue found)'
#    And A Reviewer selects 'Rejected' or “Revision Needed” within a drop-down menu
#    Then Selecting 'Save' will send the appropriate 'Rejected'/'Revision Needed' email with the notes to the Artist/Sub-store(if email)/Studio
#    And Respective actions for the content are taken for “Rejected”(status 4)/Revision Needed”(status 30)

    Examples: 
      | queueContent    |
      | Flagged Content |
