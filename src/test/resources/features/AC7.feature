@SIT
Feature: Ensure Traffic page statistics are corrrect.

Scenario: Calculate traffic statistics for the year 2018
	Given I am on the traffic page 
	When  I click on the 2018 Traffic section
	Then I should see all the months listed in the order from Dec to Jan 
	