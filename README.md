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

