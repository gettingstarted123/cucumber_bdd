@SIT
Feature: Search should provide 10 suggestions.

Scenario: Do a search and count number of suggestions

	Given I am on the homepage
	When I type "super" into the search box
	Then I expect to see exactly 10 suggestions in the typeahead dropdown