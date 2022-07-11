@SIT
Feature: Personalisation of web page.

Scenario: Change theme background colour

	Given I am on the homepage 
	When I click on the themes link then click on the dark mode theme button
	Then My page background should change colour