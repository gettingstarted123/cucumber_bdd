@SIT
Feature: Search should provide me expected suggestions.

Scenario: Search and compare suggestions 

	Given I am on the homepage 
	When I type "supercalafragalistic" somewhere in the search box
	Then I expect the first result to be "supercalafragalisticexpialadoshus"