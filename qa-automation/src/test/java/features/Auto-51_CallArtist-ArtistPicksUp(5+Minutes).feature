#Author: marina.l@stackunited.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: CallArtistPickUp
  

  @tag1
  Scenario Outline: CallArtistPickUp(5+Minutes)
    Given Store <artistId> Phone Line Status ON
    And user has enouth funds to make a call
    Given user navigates to IWC home page
    When user accepts terms of use
    And member submits IWC username<username> and password<password>
    When user<userType> navigates to Artist<artistId> phone store
    And user clicks CallNow pink button
    And user Selects call duration 5 minutes
    And click Continue blue button
    And choose <Country Code>
    And add <phoneNumber>
    And clicks Start Call button 
    Then a page with pin code opened
    
    
     Examples: 
      | username                | password   | userType | artistId | Country Code |  phoneNumber |
      | kevin.m@stackunited.com | P123456789 | member   |   733808 |   US         |  5554321233  |
    
    
 


@tag2
	Scenario Outline: Title of your scenario outline
  	Given I want to write a step with <name>
  		When I check for the <value> in step
   		Then I verify the <status> in step

   		Examples: 
   		| name  | value | status  |
    	| name1 |     5 | success |
     	| name2 |     7 | Fail    |

   
      
      
 
  
   