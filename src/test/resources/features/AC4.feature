@SIT
Feature: Ensure Themes link is accessible.

Scenario: Look for Themes in available menu options 

	Given I am on the homepage 
	When I click on the hamburger menu in the top right
	Then I expect to see a themes link