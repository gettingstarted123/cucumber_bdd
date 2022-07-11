@SIT
Feature: DuckDuckGo Logo should be visible on Home page

Scenario: Go to Home page and verify if logo is visible

	Given I am on the homepage
	When I look at the page
	Then I expect to see the duckduckgo logo on the page