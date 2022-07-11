@SIT
Feature: Search should provide 10 suggestions.

Scenario Outline: Perform search with multiple values
	Given I am on the homepage 
	When I go to the homepage and type <searchData> then click the maginifying glass
	Then I should get <countResult>	
	Examples:
	  | searchData | countResult |
	  | "Back to the future" | 10 |
	  | "BMX Bandits" | 10 |
	  | "Rocky IV" | 10 |
	  | "Short Circuit" | 10 |
	  | "The Terminator" | 10 |
	  | "Ferris Bueller's day off" | 10 |