#Author: Kevin McGowan
Feature: Artist Login

  Scenario Outline: Artist Login
    Given artist navigates to IWC home page
    When member accepts terms of use
    And artist submits IWC username<username> and password<password>

    #Then artist updates page is displayed
    Examples: 
      | usertype | username                 | password |
      | artist   | qaartist@stackunited.com | qaartist |
