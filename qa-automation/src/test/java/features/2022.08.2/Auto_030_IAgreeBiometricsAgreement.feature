#Author: Kevin McGowan
Feature: I Agree Biometrics Agreement

  Scenario Outline: Member Login
    Given artist navigates to IWC home page
    #When artist accepts terms of use
    And artist submits IWC username and password
    When artist clicks I Agree on the Biometric Information notice
    Then the artist updates page is displayed

    Examples: 
      | usertype | username | password |
      | artist   | qaartist | qaartist |
