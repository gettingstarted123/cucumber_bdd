# BDD with Cucumber , Selenium and Java
reference:
https://www.youtube.com/watch?v=C7cSKtnovEo

## Prerequisite
- Java 8 compiler and JRE needs to be installed locally ( this code was developed with version : 1.8.0_312
- Apache Maven 3.8.4
- Google Chrome Version 103.0.5060.114 (Official Build) (64-bit)
- Google Chrome driver needs to be on PATH 

## Running tests 
- on command prompt / gitbash console navigate to root of project 
- Then run the command ```mvn test```
- This will execute the tests written for each of the Acceptance criteria 

## Viewing Results
- after doing a maven build HTML reports are located under /target/HtmlReports


## Todos
- Use AND in last test
- Last test checks for months order which is not an elegant solution
- Last test checks for search statistics correctly but needs to be refactored
- Better reporting tool
- Possibly use Headless for better performant tests ?

## Refactoring
- Added ```Before``` and ```After``` to close Driver after each step
- Code cleanup

## Notes
- Presently all feature tests would run . To disable any specific feature test to run change annotation of feature to @smokeTest
- All Feature tests will execute which are annotated with @SIT
- Acceptance Criteria 3 is Failing as the behaviour of website is not honouring the specified criteria. Either a fix is required or acceptance criteria needs to be changed.

## Acceptance criteria details:
Description:
This practical challenge is to build browser based tests
• The production version of the website we are trying to test is https://start.duckduckgo.com/
• The traffic page url is https://start.duckduckgo.com/traffic
• In this fictitious example you are the automation tester in the team
• The business analyst has written the below acceptance criteria to be implemented
• The developers have completed their work, you need to write automated tests to validate the application is working as intended

AC1
Given I am on the homepage When I look at the page Then I expect to see the duckduckgo logo on the page

AC2
Given I am on the homepage When I type "super" into the search box Then I expect to see exactly 10 suggestions in the typeahead dropdown

AC3
Given I am on the homepage When I type "supercalafragalistic" into the search box Then I expect the first result to be "supercalafragalisticexpialadoshus"

AC4
Given I am on the homepage When I click on the hamburger menu in the top right Then I expect to see a themes link

AC5
Given I am on the homepage When When I click on the themes link then click on the dark mode theme button Then My page background should change colour

AC6
Given I am on the homepage When I go to the homepage and type then click the maginifying glass Then I should get 10 results on the results page

Data:
• Back to the future
• BMX Bandits
• Rocky IV
• Short Circuit
• The Terminator
• Ferris Bueller's day off

AC7
Given I am on the traffic page When I click on the 2018 Traffic section Then I should see all the months listed in the order from Dec to Jan And The Total Direct Queries should be equal to the sum of all the total directs from each month

Deliverables:
• Spend as little or as much time as you like on the challenge.
• Use whatever language and framework you want
• Please Include readme file in your solution and document setup instructions and pre-requisites to run your solution
• The output of the efforts must be committed back into a Public Repo in Github and share the repo URL back to us for a review.
• Using a BDD natural language solution implementation would be preferred

