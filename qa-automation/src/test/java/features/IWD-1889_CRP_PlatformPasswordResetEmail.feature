#Author: Kevin McGowan
Feature: [CRP] Platform Password Reset Email

  Background: 
    Given user has access to the CRP Review Dashboard
	
  Scenario: 
    When a user inputs their login email into the reset password field (https://admin.iwantglobal.com/password/reset)
    And click "Send Password Reset Link"
    Then a user will receive an email with a new password
    And a user can use the new password to log in with
